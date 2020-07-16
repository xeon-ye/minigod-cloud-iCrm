package com.sunline.modules.common.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.call.protocol.request.CallRecordRequest;
import com.sunline.modules.call.sync.CallRecordSync;
import com.sunline.modules.commission.service.ChannelClientFareSetupService;
import com.sunline.modules.commission.service.ChannelFareSetupLogService;
import com.sunline.modules.commission.service.ChannelFareSetupService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.protocol.DbsApiTestProtocol;
import com.sunline.modules.common.utils.EasyExcelUtils;
import com.sunline.modules.common.utils.PdfboxUtils;
import com.sunline.modules.common.utils.ShiroUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.dbs.service.DbsCommManageService;
import com.sunline.modules.sys.dao.UserDao;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @description: CRM辅助功能
 * @author: Larry Lai
 * @date: 2018/10/23 10:33
 * @version: v1.0
 */

@RequestMapping("/crm_test")
@Controller
public class CrmTestController {

    private static final Logger logger = LoggerFactory.getLogger(CrmTestController.class);

    @Autowired
    private ChannelFareSetupService channelFareSetupService;
    @Autowired
    private ChannelClientFareSetupService channelClientFareSetupService;
    @Autowired
    private ChannelFareSetupLogService channelFareSetupLogService;
    @Autowired
    private UserDao userDao;

    /**
     * 测试专用
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/test")
    public
    @ResponseBody
    void donatedStockdTest(HttpServletRequest request, HttpServletResponse response) {
        try {
//            downLoad("https://sns.zszhizhu.com:8000/openaccount/2018/11/12/b27b5bed8b6a4bfe9b08a79e5dd7f0bf__1080x810.jpg", response, true);
//            downLoad("http://10.1.5.113:7777/cubp/file/data/bpm/report/openAccount/2019010410000008/%E7%8E%96%E5%AF%8C%E8%AF%81%E5%88%B8%E8%AF%81%E5%88%B8%E8%B4%A6%E6%88%B7%E5%BC%80%E6%88%B7%E5%8D%8F%E8%AE%AE.pdf", response, true);
//            downLoad("http://121.35.249.12:8000/openaccount/2018/12/22/b4abf4c9f15245f0b7eb4ddbc0e376c4__1250x474.jpg", response, true);

            String accountOpenUserReportRootPath = "D:\\data\\bpm\\report\\openAccount\\2019010810000001";
            File[] files = new File[0];
            try {
                files = FileUtil.ls(accountOpenUserReportRootPath);
            } catch (Exception e) {
                logger.error("Not directory", e);
            }

            List<String> pdfPaths = Lists.newArrayList();

            if (!files[0].getPath().contains("开户表格")) {
                for (File file : files) {
                    if (file.getPath().contains("开户表格")) {
                        pdfPaths.add(file.getPath().replace("\\", "/"));
                    }
                }
                for (File file : files) {
                    if (!file.getPath().contains("开户表格")) {
                        pdfPaths.add(file.getPath().replace("\\", "/"));
                    }
                }
            } else {
                for (File file : files) {
                    pdfPaths.add(file.getPath().replace("\\", "/"));
                }
            }

            PdfboxUtils.mergePdfFiles(pdfPaths.toArray(new String[pdfPaths.size()]), ConfigUtils.get("openAccount.user.report.userForm") + "2019010810000001" + "/" + ConfigUtils.get("ca.open.account.file.url") + ".pdf");
        } catch (Exception e) {
            logger.error("异常", e);
        }
    }

    /**
     * 手动导出Excel文件
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/ExpExcelFile")
    public
    @ResponseBody
    ResponseVO excelFileExp(HttpServletRequest request, HttpServletResponse response) {
        ResponseVO responseVO = new ResponseVO();

        try {

            // 自定义表头
            String definedHeaders = "序号|姓名|帐号";

            String[] headerArray = definedHeaders.split("\\|");

            List<List<String>> headers = Lists.newArrayList();
            for (int i = 0; i < headerArray.length; i++) {
                List<String> headColumn = Lists.newArrayList();
                headColumn.add(headerArray[i]);
                headers.add(headColumn);
            }

            // 数据集
            List<String> info;
            List<List<String>> list = Lists.newArrayList();

            for (int i = 0; i < 100; i++) {
                info = Lists.newArrayList();
                info.add(String.valueOf(i + 1));
                info.add("赖洁强");
                info.add("aljqiang");

                list.add(info);
            }

            EasyExcelUtils.expDefinedHeaderXlsxFile(list, headers, response);

            responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(BpmCommonEnum.CodeType.OK.getMessage());

        } catch (Exception e) {
            logger.error("手动导出Excel文件异常", e);
            responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(e.getMessage());
            return responseVO;
        }

        return responseVO;
    }

    /**
     * 在线读取文件
     *
     * @param filePath
     * @param response
     * @param isOnLine
     * @throws Exception
     */
    private void downLoad(String filePath, HttpServletResponse response, boolean isOnLine) throws Exception {

        int httpResult;
        BufferedInputStream br = null;
        OutputStream out = null;

        try {

            URL url = new URL(filePath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            httpResult = conn.getResponseCode();
            if (httpResult != HttpURLConnection.HTTP_OK) {
                response.sendError(404, "File Not Found!");
                return;
            }

            InputStream inputStream = conn.getInputStream();

            br = new BufferedInputStream(inputStream);
            byte[] buf = new byte[1024];
            int len = 0;

            // 清空buffer，设置页面不缓存
            response.reset();

            if (isOnLine) {
                // 在线打开方式
                URL u = new URL("file:///" + filePath);
                response.setContentType(u.openConnection().getContentType());
                response.setCharacterEncoding("UTF-8");
                // TODO 文件名根据实际情况修改
                response.setHeader("Content-Disposition", "inline; filename=" + "test.pdf");
            } else {
                // 纯下载方式
                response.setContentType("application/x-msdownload");
                response.setCharacterEncoding("UTF-8");
                // TODO 文件名根据实际情况修改
                response.setHeader("Content-Disposition", "attachment; filename=" + "test.pdf");
            }

            out = response.getOutputStream();

            while ((len = br.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        } catch (Exception e) {
            logger.error("在线读取文件异常", e);
        } finally {
            if (null != br) {
                br.close();
            }
            if (null != out) {
                out.close();
            }
        }
    }

    /**
     * 同步通话记录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/syncCallRecord")
    public
    @ResponseBody
    ResponseVO syncCallRecord(HttpServletRequest request, HttpServletResponse response) {
        ResponseVO responseVO = new ResponseVO();

        try {

            CallRecordRequest callRecordRequest = new CallRecordRequest();
            CallRecordSync callRecordSync = new CallRecordSync();

            callRecordRequest.setBeginTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse("2019-01-01")), "yyyy-MM-dd HH:mm:ss"));
            callRecordRequest.setEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse("2019-01-07")), "yyyy-MM-dd HH:mm:ss"));

            callRecordSync.syncData(callRecordRequest);

            for (int i = 0; i < 10; i++) {
                callRecordRequest.setBeginTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.offsetDay(DateUtil.parse(callRecordRequest.getEndTime()), 1)), "yyyy-MM-dd HH:mm:ss"));
                callRecordRequest.setEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.offsetDay(DateUtil.parse(callRecordRequest.getEndTime()), 7)), "yyyy-MM-dd HH:mm:ss"));

                callRecordSync.syncData(callRecordRequest);
            }

            responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(BpmCommonEnum.CodeType.OK.getMessage());

        } catch (Exception e) {
            logger.error("同步通话记录异常", e);
            responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(e.getMessage());
            return responseVO;
        }

        return responseVO;
    }

    /**
     * 重置用户登录密码
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/resetUserPwd")
    public
    @ResponseBody
    ResponseVO resetUserPwd(HttpServletRequest request, HttpServletResponse response) {
        ResponseVO responseVO = new ResponseVO();

        try {

            Map<String, String> userNamePwdMap = Maps.newHashMap();

            // 内部用户
            userNamePwdMap.put("7bb9325d36254d07a213325396ff1ebe", "B8bumdNg");
            userNamePwdMap.put("a2c8545a61cb434a9bfc9a2ec3f71c25", "4Asqcjs1");
            userNamePwdMap.put("d478d5285ef34ff59009c71e6aceab82", "9T5dCgiT");
            userNamePwdMap.put("cfc436d240c841e3a06fac53b62202d3", "klyThP4B");
            userNamePwdMap.put("1b758b6063c547dab7d0b3e1073e6239", "aKN6hvIZ");
            userNamePwdMap.put("b0aaa8811e1d44169db55463e14a1f97", "PDLQHvA6");
            userNamePwdMap.put("56711040803c4a579bc874c1e0bb88d3", "vmCLSXn6");
            userNamePwdMap.put("c667cddf00ad4f3dbfdb88878d2ca3a9", "kunZzlR5");
            userNamePwdMap.put("d0445b4bbdc844228291ac6900356dc3", "Wq1iZRaw");
            userNamePwdMap.put("4ef14d6537f84585af5c9b4652e513a2", "8JUxWzPs");
            userNamePwdMap.put("aa5133adfe7a4782a2b075a6aefcbfa2", "f39eVnna");
            userNamePwdMap.put("96f89a8e0c8641e9b060137117e0ecc2", "bM9lIjPj");
            userNamePwdMap.put("16efc55453a342459358549ad5ee7e17", "cUkXPPW4");
            userNamePwdMap.put("175dd13f889a46d0869009a290bd55fd", "5zDdxyIJ");
            userNamePwdMap.put("52e55a7de9984a27a7273d2e5e657ee3", "iGR9CPT2");
            userNamePwdMap.put("db4e3d7b2f954e6486431185ffb8d5ed", "xfPv58ID");
            userNamePwdMap.put("83c8b00896714584a319368475fabc36", "47PHUpni");
            userNamePwdMap.put("24e616225a4949f4ae5a9024d44b8cbb", "V2eVcCnm");
            userNamePwdMap.put("52576c5681a545ed817fce276263d4d4", "ZP6KGDeH");
            userNamePwdMap.put("b7bb223c123d42f0926a4d4affbb96b8", "uaP1Uy3l");
            userNamePwdMap.put("593886cd359d498b90a9e2d25017c997", "uBPd8i6l");
            userNamePwdMap.put("5596e360525445f7a6409ad7079eecbc", "Bk4vSq6q");
            userNamePwdMap.put("0ab1638f376b4153873b9b074ca45477", "r8xZ1hpW");
            userNamePwdMap.put("b219be05932943e9b449c1109a20b62d", "51lEsClS");
            userNamePwdMap.put("24e2043daf2243a68d7638da0453b288", "GZu5ccPG");
            userNamePwdMap.put("6245bdef7e7c4607a25789cd4b393d35", "fPskv94n");
            userNamePwdMap.put("65cc50b1926748cc913afa286031a3f9", "myVbR4iS");
            userNamePwdMap.put("6842472702584e8dafd63be137fa3b0d", "u9NbS2jf");
            userNamePwdMap.put("fb924ef09ff54860be29d51925be89be", "y68nV1Tt");
            userNamePwdMap.put("3204b9999f9845828b3b4389b7b5cefe", "7XUDuQME");
            userNamePwdMap.put("ef7fedbc49aa4ae79103ba6d639954a6", "DjNZ3zAT");
            userNamePwdMap.put("52443403c8724777ad463a5cba9b8a1f", "VS7k5Vt5");
            userNamePwdMap.put("7693829d67874b4bbbdba2f6a5982c1b", "zm2VPRgb");
            userNamePwdMap.put("a5951a379aa640f2b376cf8d7e2c31d7", "8wP5qGHD");
            userNamePwdMap.put("617fe96c353245daa7cd95b150a55f27", "p9GNwuSn");
            userNamePwdMap.put("5579152fce9d41068f18778383f4e6fe", "WJSmTwC3");
            userNamePwdMap.put("79ce2af8d7b146228f4c3b09378ec634", "SNHM9bxM");
            userNamePwdMap.put("beba14f3522144cb8159e7ee1388d4fd", "CN8pIXqm");
            userNamePwdMap.put("408baf1561df40f5b3d6e2d82ecc2159", "Db5H5xRu");
            userNamePwdMap.put("db68308a95c14dbeafe9686afcd1a389", "2UCmlZFg");
            userNamePwdMap.put("3261f4aff11f4ec18da6c744fcd872ca", "Dt7TdEzP");
            userNamePwdMap.put("6e177475aa8144848434d5137d40b904", "8EEa498X");
            userNamePwdMap.put("7c943d68485b4aa7a556ce5df1a22a9b", "KJvI5PGj");
            userNamePwdMap.put("d5fc519bd3f447ce93f78649691af24c", "PPVyl2Pq");
            userNamePwdMap.put("7e296b38d9df4ccd919d5f3ab62d62e4", "xTN4nweK");
            userNamePwdMap.put("81c0fcde92fd4e0bbc1d59b0fdbb497f", "VPP4UEei");
            userNamePwdMap.put("0e1c44c498b549a5a1275cf932b19910", "uUzyUg4P");
            userNamePwdMap.put("66febc200cec49249fd8ed748b01d3cb", "qeKPf6Qc");
            userNamePwdMap.put("060e5451998e49cf97df0e1be733f421", "UtPUfL1Q");
            userNamePwdMap.put("f7527b2535604139a63346906da45747", "7EzD5Aib");

            // 外部用户
            userNamePwdMap.put("9b829632f5004039be7671deca4f6597", "kUxCfkq3");
            userNamePwdMap.put("a7cfd55a0ee64d6e9b2f4ebf88800f1a", "Gy44FNvp");
            userNamePwdMap.put("893d3a0c8da443a29503b1951f37dc92", "V2DMiaXJ");
            userNamePwdMap.put("6420b987e2384bf986b1a9e9ea63b997", "St7l5lsK");
            userNamePwdMap.put("eb1390aa879446faa7fcbd8e17006863", "lsXwcc25");
            userNamePwdMap.put("66254ebd15274d9d8528dd407e6e53c0", "jtqc8QHp");
            userNamePwdMap.put("66dc5cafc115413cb41cf54823766cae", "iMMa5kWb");
            userNamePwdMap.put("00ca47037b8441c5b806cab25d0cc973", "s8thZMgy");
            userNamePwdMap.put("4a9efe1adbfb4bb6bbf774bf9d84316c", "32czsjW1");
            userNamePwdMap.put("53c589a6bcf14771b670366410f0bfb5", "Rn4v3IZn");
            userNamePwdMap.put("9a3baef88f5c4ed1921236c8a405ab5e", "xnd3ET8F");
            userNamePwdMap.put("7c9b2a916fe341909299e9189d6991d4", "2RUPIafx");
            userNamePwdMap.put("1ccc251d92294b9194eb87c5cefab4fc", "yE8bAwiM");
            userNamePwdMap.put("90aa6d0fd6874fa0a7d608c4f79d46af", "H8Eb5PRX");
            userNamePwdMap.put("86336c1e4fa440a7a1cbb5051bb3555e", "btiD8kVE");
            userNamePwdMap.put("2e2ed2ab9f5648ec9b109e570a060849", "dFD4Ka58");
            userNamePwdMap.put("1f5c1047e420457ba14148cc91f8dc16", "7WJjYgI8");
            userNamePwdMap.put("4ac18bdd81ae42cd9c05a12d6ef9b124", "K4ZHfzAl");
            userNamePwdMap.put("55defb08cae9413392f99952eb2ce4db", "INV79Xtr");
            userNamePwdMap.put("ef449dd517804dc9b4d4002988eb264b", "qVEpP9c9");
            userNamePwdMap.put("fb4b46631e214194af0ae58ea43986a0", "DwaG9dZQ");
            userNamePwdMap.put("27842d1b43fc45b6a7907ec6c81916d8", "TE33r8FX");
            userNamePwdMap.put("c6bd2b22c83c4876bca07760797a0b1e", "8Mv8vgbi");
            userNamePwdMap.put("072c430e28714244951c67e7273778f2", "A4UbKXMW");
            userNamePwdMap.put("4780ba3ed0774628abaab6861169a4fb", "s8Mf8d44");
            userNamePwdMap.put("e31a0bff668544e999276a8d09bc3dd8", "jaDusm1q");
            userNamePwdMap.put("c0cb8c303c344c048c9e33e4f1c76ecf", "mJIFP2WI");
            userNamePwdMap.put("5156c31eafe74da4880b222d4745fd74", "2pZwxIpw");
            userNamePwdMap.put("a93e7bfe4ef0476c82621ffad699b038", "86pENeYz");
            userNamePwdMap.put("ed7a35d7cf68427e99292e2db101e43f", "WhGP1RCv");
            userNamePwdMap.put("23dae477e3ea4ea496289f6d42d3d923", "dxI3Wfcx");
            userNamePwdMap.put("7ebfd582c6a6443983a2ab33ae0f37f8", "fYYG9fl3");
            userNamePwdMap.put("007b07052e104ba5870526ffe966d11b", "TXJPp8RC");
            userNamePwdMap.put("82a9247ed1034cd4b5471a108a1551bd", "8Bh1MJfL");
            userNamePwdMap.put("36a7ca6045b04f1e861b3e6104307d84", "QPSAG4pw");
            userNamePwdMap.put("ac45a99362e14ef5bffb34d6f5fcdf82", "qH13VDtW");
            userNamePwdMap.put("ee836e3ac8b940879d9a85d89c148ae9", "nTwku8Lp");
            userNamePwdMap.put("aa3f4d4b9fdf4b9ca0aa5d96ff3503b1", "qJBp6e7Q");
            userNamePwdMap.put("3d195aebe5be4e7881c937d28e69875c", "66feVZNq");
            userNamePwdMap.put("35a75305150244aeb7b831147c8fd4c8", "pP8ydNge");
            userNamePwdMap.put("35c2d7b420674cee98c8950e60eebb55", "g5BCdxL2");
            userNamePwdMap.put("7deeebc59a5d4a31b51e2c98012094ca", "6NChQ5Yv");

            for (Map.Entry<String, String> entry : userNamePwdMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                Map<String, Object> params = Maps.newHashMap();
                // 生成salt
                String salt = RandomStringUtils.randomAlphanumeric(20);
                params.put("ids", new String[]{key});
                params.put("salt", salt);
                params.put("passWord", ShiroUtils.EncodeSalt(value, salt));

                int count = userDao.resetPassWord(params);

                if (count > 0) {
                    logger.info("已重置[" + userDao.queryObject(key).getLoginName() + "]的登录密码");
                }
            }

            responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(BpmCommonEnum.CodeType.OK.getMessage());

        } catch (Exception e) {
            logger.error("重置用户登录密码异常", e);
            responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(e.getMessage());
            return responseVO;
        }

        return responseVO;
    }

    /**
     * DBS接口测试
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/DBSApi")
    public
    @ResponseBody
    ResponseVO testDBSApi(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false)DbsApiTestProtocol dbsApi) {
        ResponseVO responseVO = new ResponseVO();
        try {
            String apiUrl= dbsApi.getApiUrl();
            String sendStr= dbsApi.getSendStr();
            String key= dbsApi.getKey();
            String business= dbsApi.getBusiness();
            String msgId= dbsApi.getMsgId();
            String encryptStr = DbsCommManageService.encrypt(sendStr, business, msgId);
            String responseMes = DbsCommManageService.send(apiUrl, encryptStr, key, business, msgId);
            String decResponse = DbsCommManageService.decrypt(responseMes, business, msgId);
            responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(decResponse);
        } catch (Exception e) {
            logger.error("DBSApi 测试接口异常：", e);
            responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(e.getMessage());
            return responseVO;
        }
        return responseVO;
    }
}
