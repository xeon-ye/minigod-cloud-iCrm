package com.sunline.modules.dbs.protocol;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.dbs.protocol.response.DbsAreProtocol;


import java.util.*;


/**
 * 包装请求DBS数据
 */
public class DbsReqPackag {

    /**
     *
     * @param msgId
     * @param accInfo
     * @return
     */
    public static String accountRangeEnquityReq(String msgId, Map<String, Object> accInfo){
        String orgId = ConfigUtils.get("dbs.request.orgId");
        //封装header
        Map<String, Object> header = new HashMap<>();
        header.put("msgId", msgId);
        header.put("orgId", orgId);
        header.put("timeStamp", DateUtil.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSS"));
        header.put("ctry","HK");

        //封装body
        Map<String, Object> body = new HashMap<>();
        body.put("header",header);
        body.put("accInfo",accInfo);
        return JSONUtil.parseObj(body).toString();
    }

    public static void main(String[] args) throws Exception {
        String resString ="{\"header\":{\"msgId\":\"202005121\",\"orgId\":\"HK9FPS\",\"timeStamp\":\"2020-05-12T15:23:10.166\",\"ctry\":\"HK\"},\"txnEnqResponse\":{\"enqStatus\":\"ACSP\",\"acctInfo\":[{\"accountNo\":\"000292053\",\"accountCcy\":\"USD\",\"availableBal\":\"10000.0000 (as of 2020-05-12)\",\"initiatingParty\":[{\"txnInfo\":[{\"drCrInd\":\"C\",\"txnCode\":\"TRF\",\"txnDesc\":\"REMITTANCE TRANSFER OF FUNDS TESTING\",\"txnDate\":\"2020-05-10 00:00:00.000\",\"valueDate\":\"2020-05-10 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"400.0000\"},{\"drCrInd\":\"C\",\"txnCode\":\"TRF\",\"txnDesc\":\"REMITTANCE TRANSFER OF FUNDS TESTING\",\"txnDate\":\"2020-05-10 00:00:00.000\",\"valueDate\":\"2020-05-10 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"300.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\":\"REMITTANCE TRANSFER OF FUNDS TESTING\",\"txnDate\":\"2020-05-10 00:00:00.000\",\"valueDate\":\"2020-05-10 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"200.0000\"},{\"drCrInd\":\"D\",\"txnCode\":\"TRF\",\"txnDesc\":\"REMITTANCE TRANSFER OF FUNDS TESTING\",\"txnDate\":\"2020-05-10 00:00:00.000\",\"valueDate\":\"2020-05-10 00:00:00.000\",\"txnCcy\":\"USD\",\"txnAmount\":\"100.0000\"}]}]}]}}";
        JSONObject jsonObj=new JSONObject(resString);
        String headerStr = jsonObj.getStr("header");
        String msgId = new JSONObject(headerStr).getStr("msgId");
        String txnEnqResponseStr = jsonObj.getStr("txnEnqResponse");
        String enqStatus = new JSONObject(txnEnqResponseStr).getStr("enqStatus");

        List<DbsAreProtocol> areProtocolList = new ArrayList<>();
        //获得acctInfo 数组
        JSONArray acctInfoList=new JSONObject(txnEnqResponseStr).getJSONArray("acctInfo");
        for (int i=0; i<acctInfoList.size(); i++){
            String acctInfo = acctInfoList.getStr(i);
            JSONArray initiatingPartyList = new JSONObject(acctInfo).getJSONArray("initiatingParty");
            for (int j=0; j<initiatingPartyList.size(); j++){
                String initiatingParty = initiatingPartyList.getStr(i);
                String txnInfoString = new JSONObject(initiatingParty).getStr("txnInfo");
                JSONArray txnInfoArray = JSONUtil.parseArray(txnInfoString);
                areProtocolList.addAll(txnInfoArray.toList(DbsAreProtocol.class)) ;
            }

        }
    }


}
