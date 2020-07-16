package com.sunline.modules.quartz.task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import cn.hutool.core.date.DateUtil;

import com.google.common.collect.Lists;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.dbs.entity.SecItemaccountApplyEntity;
import com.sunline.modules.dbs.service.SecItemaccountApplyService;
import com.sunline.modules.dbs.util.GnuPG;
import com.sunline.modules.dbs.util.SFTPUtils;
import com.sunline.modules.notice.service.MessageSendInfoService;
import com.sunline.modules.sys.service.SysConfigService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;


@Component("dbsPgpJob")
public class DbsPgpJob {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private SecItemaccountApplyService secItemaccountApplyService;
    
    @Autowired
    private MessageSendInfoService messageSendInfoService;
    
    @Autowired
    private SysConfigService sysConfigService;
    
    private static String gpgRunningKey = "gpgRunningKey";
	private String filePath;
//	private String ascPath;
	private String outbox;
	private String inbox;
	String ftpHost;
	String port;
	String ftpUserName;
	String priKeyBasePath;
	String priUserId;
	String pubUserId;
//	private static boolean isStop = false;
	private static int sn = 1;
	@PostConstruct
	protected void init() {
		filePath = ConfigUtils.get("pgp.local.filePath");
		ftpHost = ConfigUtils.get("pgp.remote.ftpHost");
	    port = ConfigUtils.get("pgp.remote.ftpPort");
	    ftpUserName = ConfigUtils.get("pgp.remote.ftpUserName");
	    outbox = ConfigUtils.get("pgp.remote.outbox");
	    inbox = ConfigUtils.get("pgp.remote.inbox");
	    port = ConfigUtils.get("pgp.remote.ftpPort");
	    priUserId = ConfigUtils.get("pgp.key.priUserId");
	    pubUserId = ConfigUtils.get("pgp.key.pubUserId");
//	    ascPath = this.getClass().getResource("/").getPath()+"pgp/JiuFu-DBS-PRO.pub.asc";
//	    priKeyBasePath = this.getClass().getResource("/").getPath()+"pgp/id_rsa";
	    priKeyBasePath = ConfigUtils.get("pgp.rsa.file");
	}
	

    public void excute(String params) throws Exception {
        logger.info(params + "星展数据任务开始");
        String isGpgRunning = SysConfigUtil.getSysConfigValue(gpgRunningKey, "1");
        if("0".equals(isGpgRunning)){
        	sendEmailCloud("服务器回执失败",new Date());
        	logger.info(">>>>>>>>星展数据文件上传任务已停止>>>>>>>>>");
			return;
        }
        try{
        	doing();
        }catch (Exception e) {
        	sn = 1;
        	SFTPUtils.closeChannel();
        	sendEmailCloud("服务器连接失败",new Date());
        	logger.error("执行星展数据文件上传任务异常:", e);
		}
        logger.info(params + "星展数据任务结束");
    }
    
	private void doing() throws Exception{
		Date now = new Date();
		SecItemaccountApplyEntity entity = new SecItemaccountApplyEntity();
		entity.setExportState(0);
		List<SecItemaccountApplyEntity> secItemaccountApplyVOS = secItemaccountApplyService.queryListByBean(entity);
		StringBuilder sb = new StringBuilder();;
        String subAccountNo = "";
        String folderName = DateUtil.format(now, "yyyy-MM-dd")+"/";
		if(!CollectionUtils.isEmpty(secItemaccountApplyVOS)){
			SFTPUtils.getConnect(ftpHost, port, ftpUserName, priKeyBasePath);
			logger.info("sftpchannel:" + SFTPUtils.channel);
        	List<String> listfiles = SFTPUtils.listFiles(inbox);
        	if(CollectionUtils.isEmpty(listfiles)&&sn>1){
        		SFTPUtils.closeChannel();
        		sendEmailCloud("服务器回执失败",now);
//        		sysConfigService.updateValueByKey(gpgRunningKey, "0");
        		logger.error("Inbox listfiles is null");
        		return;
        	}
        	downfile(listfiles,folderName);
        
			for (int i = 0; i < secItemaccountApplyVOS.size(); i++) {
                sb.append("A,");//一列
                SecItemaccountApplyEntity secItemaccountApplyVO = secItemaccountApplyVOS.get(i);
                subAccountNo = secItemaccountApplyVO.getSubAccountNo();
                if(StringUtils.isNotEmpty(subAccountNo)){
                    String[] str = subAccountNo.split("-");
                    if(str.length==3){
                        sb.append(str[0]).append(",")//二列
                                .append(str[1]).append(",")//三列
                                .append(str[2]).append(",");//四列

                    }else{
                        sb.append(" ,")//二列
                                .append(" ,")//三列
                                .append(" ,");//四列
                    }
                }
                sb.append(secItemaccountApplyVO.getAccountName()).append("\r\n");//五列
                
           }
			
			String filename = createCSV(sb.toString(), now,folderName);
			String localfile = filePath + folderName + filename;
			String pgpfile = localfile + ".pgp";
			GnuPG pgp = new GnuPG();
			pgp.encrypt(priUserId, pubUserId, pgpfile + " " + localfile, null);
			SFTPUtils.getConnect(ftpHost, port, ftpUserName, priKeyBasePath);
			logger.info("sftpchannel2:" + SFTPUtils.channel);
			SFTPUtils.uploadFile(pgpfile, outbox);
			for (SecItemaccountApplyEntity updateEntity:secItemaccountApplyVOS) {
				updateEntity.setUpdateTime(now);
				updateEntity.setExportState(1);//已导出
				secItemaccountApplyService.update(updateEntity);
			}
			sn += 1;
			
		}
		
     
	}
	
	private void sendEmailCloud(String desc,Date now){
		DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		messageSendInfoService.generateSendEmailText("星展子账户开通异常提醒",  "星展子账户处理异常,"+desc+",Date:"+DateUtil.format(now, "yyyy-MM-dd HH:mm:ss"), 
				0, ConfigUtils.get("pgp.notice.email"), Lists.newArrayList());
	}
	
	private void downfile(List<String> listfiles,String folderName) throws Exception{
		if(!CollectionUtils.isEmpty(listfiles)){
			SFTPUtils.channel.cd(inbox);
			for(String fileName:listfiles){
				SFTPUtils.downloadFile(inbox, filePath+folderName+fileName);
			}
			SFTPUtils.deleteAllFile(inbox,listfiles);
		}
	}
	

	public String createCSV(String data,Date now,String folderName) {
		
		String fileName = "DSG_VAHKL."+DateUtil.format(now, "yyyyMMdd_HHmm")+".CSV";// 文件名称
		try {
			File csvFile = new File(filePath +folderName+ fileName);
			File parent = csvFile.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			csvFile.createNewFile();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(csvFile), "gbk"));
			bw.write(data);
			bw.newLine();
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return fileName;
	}
	

}
