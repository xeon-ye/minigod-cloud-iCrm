package com.sunline.modules.dbs.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.common.utils.StringUtils;
import com.sunline.modules.dbs.entity.DbsAreBankFlowEntity;
import com.sunline.modules.dbs.protocol.DbsReqPackag;
import com.sunline.modules.dbs.protocol.response.DbsAreProtocol;
import com.sunline.modules.dbs.service.DbsAREBusinessService;
import com.sunline.modules.dbs.service.DbsAreBankFlowService;
import com.sunline.modules.dbs.service.DbsCommManageService;
import com.sunline.modules.dbs.service.SecItemaccountApplyService;
import com.sunline.modules.fund.entity.DbsIccBankFlowEntity;
import com.sunline.modules.fund.entity.DepositBankBillFlowEntity;
import com.sunline.modules.fund.service.DepositBankBillFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * 请求DBS获取ARE业务处理类
 * @author xia Liu
 * @date 2020-05-15
 */
@Service("dbsAREBusinessService")
public class DbsAREBusinessServiceImpl implements DbsAREBusinessService {
    private static final Logger logger = LoggerFactory.getLogger(DbsAREBusinessServiceImpl.class);

    @Autowired
    private DbsAreBankFlowService dbsAreBankFlowService;
    @Autowired
    private DepositBankBillFlowService depositBankBillFlowService;

    String rangeUrl="rapid/enquiry/v1/account/range";
    String rangeKey = ConfigUtils.get("dbs.request.KeyId1");


    /**
     * ICC流水请求星展 ACCOUNT RANGE ENQUIRY MESSAGE
     */
    @Override
    public boolean sendICCARE(DbsIccBankFlowEntity dbsIccBankFlowEntity, String createBy){
        //开始存入发起请求数据
        DbsAreBankFlowEntity dbsAreBankFlow = new DbsAreBankFlowEntity();
        dbsAreBankFlow.setSourceMsgId(dbsIccBankFlowEntity.getMsgId());
        dbsAreBankFlow.setCreateTime(new Date());
        dbsAreBankFlow.setCreateUser(createBy);
        dbsAreBankFlowService.save(dbsAreBankFlow);

        try {
            String areMsgId = DateUtil.format(new Date(), "yyyyMMdd") + dbsAreBankFlow.getId();
            Map<String, Object> accInfo = new HashMap<>();
            accInfo.put("accountNo", dbsIccBankFlowEntity.getReceiveAccNo());
            accInfo.put("accountCcy", dbsIccBankFlowEntity.getTxnCcy());
            accInfo.put("fromDate", DateUtil.format(dbsIccBankFlowEntity.getTxnDate(), "yyyy-MM-dd"));
            accInfo.put("toDate", DateUtil.format(dbsIccBankFlowEntity.getTxnDate(), "yyyy-MM-dd"));
            accInfo.put("drCrInd", "D");
            //accInfo.put("noTxnInd", "1000");
            //accInfo.put("chronoFlag","Y");
            String pubStr = DbsReqPackag.accountRangeEnquityReq(areMsgId, accInfo);
            //开始保存请求报文and请求时间
            DbsAreBankFlowEntity reqDbsAreBankFlow =new DbsAreBankFlowEntity();
            reqDbsAreBankFlow.setId(dbsAreBankFlow.getId());
            reqDbsAreBankFlow.setMsgId(areMsgId);
            reqDbsAreBankFlow.setReqMessage(pubStr);
            reqDbsAreBankFlow.setReqTime(new Date());
            reqDbsAreBankFlow.setUpdateUser(createBy);
            reqDbsAreBankFlow.setUpdateTime(new Date());
            dbsAreBankFlowService.update(reqDbsAreBankFlow);

            String  business = "AREBusiness";
            //开始加密明文报文
            String sendStr = DbsCommManageService.encrypt(pubStr, business, areMsgId);
            //开始发送请求,获得响应密文 (调试不同接口需要修改 accountUrl/KeyId)
            String responseMes = DbsCommManageService.send(rangeUrl, sendStr, rangeKey, business, areMsgId);
            String decResponse = DbsCommManageService.decrypt(responseMes, business, areMsgId);
                    //"{\"header\":{\"msgId\":\"2020052137LXTEST\",\"orgId\":\"HK9FPS\",\"timeStamp\":\"2020-05-21T15:15:22.127\",\"ctry\":\"HK\"},\"txnEnqResponse\":{\"enqStatus\":\"ACSP\",\"acctInfo\":[{\"accountNo\":\"000292053\",\"accountCcy\":\"USD\",\"availableBal\":\"10000.0000 (as of 2020-05-21)\",\"initiatingParty\":[{\"name\":\"Name1\",\"txnInfo\":[{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"TRANSFER\\rCHGS T210520152026 EBHVT91105898309 EBHVT91105898309 DBS-IDEALPAYE\\rDBS-IDEALPAYEEWITHENDINGSPACE      \\rHKD 100  \\rUETR Ref:01ca35bb-3ff2-448a-9693-bf0b15c8cffc\",\"txnDate\":\"2020-05-21 00:00:00.000\",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520151936 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520151852 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520151804 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"TRANSFER\\rCHGS T210520151717 EBHVT91105898309 EBHVT91105898309 DBS-IDEALPAYE\\rDBS-IDEALPAYEEWITHENDINGSPACE      \\rHKD 100  \\rUETR Ref:01ca35bb-3ff2-448a-9693-bf0b15c8cffc\",\"txnDate\":\"2020-05-21 00:00:00.000\",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"TRANSFER\\rCHGS T210520151619 EBHVT91105898309 EBHVT91105898309 DBS-IDEALPAYE\\rDBS-IDEALPAYEEWITHENDINGSPACE      \\rHKD 100  \\rUETR Ref:01ca35bb-3ff2-448a-9693-bf0b15c8cffc\",\"txnDate\":\"2020-05-21 00:00:00.000\",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"TRANSFER\\rCHGS T210520151522 EBHVT91105898309 EBHVT91105898309 DBS-IDEALPAYE\\rDBS-IDEALPAYEEWITHENDINGSPACE      \\rHKD 100  \\rUETR Ref:01ca35bb-3ff2-448a-9693-bf0b15c8cffc\",\"txnDate\":\"2020-05-21 00:00:00.000\",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520151440 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520151249 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520151150 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520150946 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"TRANSFER\\rCHGS T210520150622 EBHVT91105898309 EBHVT91105898309 DBS-IDEALPAYE\\rDBS-IDEALPAYEEWITHENDINGSPACE      \\rHKD 100  \\rUETR Ref:01ca35bb-3ff2-448a-9693-bf0b15c8cffc\",\"txnDate\":\"2020-05-21 00:00:00.000\",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"TRANSFER\\rCHGS T210520150516 EBHVT91105898309 EBHVT91105898309 DBS-IDEALPAYE\\rDBS-IDEALPAYEEWITHENDINGSPACE      \\rHKD 100  \\rUETR Ref:01ca35bb-3ff2-448a-9693-bf0b15c8cffc\",\"txnDate\":\"2020-05-21 00:00:00.000\",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"20.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520150425 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520150320 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520150204 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"20.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520150109 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520150006 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520142943 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520141002 \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520151335LX \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520143155LX \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"20.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520151655LX \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\": \"FPS FEE for Dan202001051512 \\rT210520150233LX \",\"valueDate\":\"2020-05-21 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"20.0000\"}]}]}]}}";

            //保存响应报文
            DbsAreBankFlowEntity resDbsAreBankFlow =new DbsAreBankFlowEntity();
            resDbsAreBankFlow.setId(dbsAreBankFlow.getId());
            resDbsAreBankFlow.setResMessage(decResponse);
            resDbsAreBankFlow.setResTime(new Date());
            resDbsAreBankFlow.setUpdateUser(createBy);
            resDbsAreBankFlow.setUpdateTime(new Date());
            dbsAreBankFlowService.update(resDbsAreBankFlow);
            return this.businessResARE(reqDbsAreBankFlow, decResponse, dbsIccBankFlowEntity, createBy);

        }catch (Exception e) {
            this.saveErrorInfo(dbsAreBankFlow.getId(), createBy);
            logger.error(dbsIccBankFlowEntity.getMsgId() +"请求DBS ARE查询异常："+e.toString());
            return false;
        }
    }

    /**
     * 处理响应报文对应的业务逻辑
     */
    private boolean businessResARE(DbsAreBankFlowEntity dbsAreBankFlow,String decResponse, DbsIccBankFlowEntity dbsIccBankFlowEntity, String createBy){
        try {
            //解析响应报文
            JSONObject jsonObj=new JSONObject(decResponse);
            String headerStr = jsonObj.getStr("header");
            String msgId = new JSONObject(headerStr).getStr("msgId");
            String txnEnqResponseStr = jsonObj.getStr("txnEnqResponse");
            //ACSP-获取成功； RJCT-获取失败； PART-获取成功但超过1000条
            String enqStatus = new JSONObject(txnEnqResponseStr).getStr("enqStatus");
            /* 暂时屏蔽校验
            if(!msgId.equals(dbsAreBankFlow.getMsgId())){
                return false;
            }*/
            //更新对应的DbsAreBankFlow 记录
            DbsAreBankFlowEntity dbsAreBankFlowRes = new DbsAreBankFlowEntity();
            dbsAreBankFlowRes.setId(dbsAreBankFlow.getId());
            dbsAreBankFlowRes.setReqStatus("1");
            dbsAreBankFlowRes.setEnqStatus(enqStatus);
            dbsAreBankFlowService.update(dbsAreBankFlowRes);

            DepositBankBillFlowEntity queryCondition = new DepositBankBillFlowEntity();
            queryCondition.setMsgId(dbsIccBankFlowEntity.getMsgId());
            queryCondition.setReferenceNo(dbsIccBankFlowEntity.getTxnRefId());
            queryCondition.setFlowSource(1);
            List<DepositBankBillFlowEntity> depositBankBillFlowEntityList = depositBankBillFlowService.queryListByBean(queryCondition);
            DepositBankBillFlowEntity depositBankBillFlow = depositBankBillFlowEntityList.get(0);
            if(StringUtils.isEmpty(enqStatus) || "RJCT".equals(enqStatus)){
                //更新对应的DepositBankBillFlowEntity记录为失败
                DepositBankBillFlowEntity updateBankBillFlow = new DepositBankBillFlowEntity();
                updateBankBillFlow.setId(depositBankBillFlow.getId());
                updateBankBillFlow.setAreEnqStatus(enqStatus);
                updateBankBillFlow.setAreTime(new Date());
                depositBankBillFlowService.updateAREData(updateBankBillFlow);
                return false;
            }

            List<DbsAreProtocol> areProtocolList = new ArrayList<>();
            //获得acctInfo 数组
            JSONArray acctInfoList=new JSONObject(txnEnqResponseStr).getJSONArray("acctInfo");
            for (int i=0; i<acctInfoList.size(); i++){
                String acctInfo = acctInfoList.getStr(i);
                JSONArray initiatingPartyList = new JSONObject(acctInfo).getJSONArray("initiatingParty");
                for (int j=0; j<initiatingPartyList.size(); j++){
                    String initiatingParty = initiatingPartyList.getStr(j);
                    String txnInfoString = new JSONObject(initiatingParty).getStr("txnInfo");
                    JSONArray txnInfoArray = JSONUtil.parseArray(txnInfoString);
                    areProtocolList.addAll(txnInfoArray.toList(DbsAreProtocol.class)) ;
                }
            }
            //开始获取手续费
            String txnAmountFee = "";
            //需要匹配的iccTxnRefId
            String iccTxnRefId = dbsIccBankFlowEntity.getTxnRefId();
            for (DbsAreProtocol dbsAre:areProtocolList){
                //交易手续费, txnDesc会以 CHGS 或 FEE 来表示 (视乎那种付/收款方式), 同样可用transaction reference number 做关联
                String txnDesc = dbsAre.getTxnDesc();
                //先判断是否包含iccTxnRefId值
                if(!txnDesc.contains(iccTxnRefId)){
                    continue;
                }
                //TT/CHATS 方式 txnDesc 在第一个 \r 之後用 CHGS 来展示这是一个手续费，再判断当前交易是否是手续费
                if(!txnDesc.contains("CHGS") && !txnDesc.contains("FPS FEE")){
                    continue;
                }
                txnAmountFee = dbsAre.getTxnAmount();
            }

            //将手续费和到账金额、本次查询状态 保存到DepositBankBillFlowEntity表中
            if(StringUtils.isEmpty(txnAmountFee)){
                txnAmountFee=0+"";
            }
            DepositBankBillFlowEntity updateBankBillFlow = new DepositBankBillFlowEntity();
            updateBankBillFlow.setId(depositBankBillFlow.getId());
            updateBankBillFlow.setAreEnqStatus(enqStatus);
            updateBankBillFlow.setAreChargeMoney(new BigDecimal(txnAmountFee));
            updateBankBillFlow.setAreTime(new Date());
            BigDecimal creditAmount = depositBankBillFlow.getActualMoney().subtract(new BigDecimal(txnAmountFee));
            updateBankBillFlow.setCreditAmount(creditAmount);
            depositBankBillFlowService.updateAREData(updateBankBillFlow);
            return true;
        }catch (Exception e){
            this.saveErrorInfo(dbsAreBankFlow.getId(), createBy);
            logger.error(dbsIccBankFlowEntity.getMsgId() +"DBS ARE响应报文逻辑处理异常："+e.toString());
            return false;
        }

    }

    /**
     * 保存请求失败
     * @param id
     * @param updateBy
     */
    private void saveErrorInfo(Long id, String updateBy){
        DbsAreBankFlowEntity dbsAreBankFlow = new DbsAreBankFlowEntity();
        dbsAreBankFlow.setId(id);
        dbsAreBankFlow.setReqStatus("0");
        dbsAreBankFlow.setUpdateTime(new Date());
        dbsAreBankFlow.setUpdateUser(updateBy);
        dbsAreBankFlowService.update(dbsAreBankFlow);
    }
}
