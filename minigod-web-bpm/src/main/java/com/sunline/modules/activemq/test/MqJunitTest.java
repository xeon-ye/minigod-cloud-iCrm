package com.sunline.modules.activemq.test;

import com.alibaba.fastjson.JSON;
import com.sunline.modules.activemq.entity.ActiveMqBizCode;
import com.sunline.modules.activemq.entity.ActiveMsgEntity;
import com.sunline.modules.activemq.protocol.UserInfoExt;
import com.sunline.modules.activemq.service.impl.ActiveMqServiceImpl;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: TODO
 * @author: Larry Lai
 * @date: 2019/10/30 19:38
 * @version: v1.0
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MqJunitTest {

    private static final Logger logger = LoggerFactory.getLogger(MqJunitTest.class);

    @Autowired
    private ActiveMqServiceImpl activeMqService;

    @Test
    public void test2() {
        UserInfoExt userInfoExt = new UserInfoExt();
        userInfoExt.setUserId(1005333);
        userInfoExt.setTradeAccount("1000002611");
        userInfoExt.setFundAccount("100002211");
        userInfoExt.setFundAccountType(1);
        userInfoExt.setPhoneNumber("13800138000");
        userInfoExt.setEmail("abc@123.com");
        userInfoExt.setClientStatus("0");
        userInfoExt.setOpenAccountStatus(0);
        userInfoExt.setOptType(1);

        // 推送到用户中心扩展
//        UserInfoExt userInfoExt=new UserInfoExt();
//        userInfoExt.setUserId(1005391);
//        userInfoExt.setTransferInStatus(1);
//        userInfoExt.setOptType(2);

        GenericSunlineRequest<UserInfoExt> request = new GenericSunlineRequest<>();
        request.setParams(userInfoExt);

        ActiveMsgEntity<Object> msg = new ActiveMsgEntity<>();
        msg.setBizCode(ActiveMqBizCode.USER_INFO_EXT);
        msg.setPublishType(1);
        msg.setMsgType(2);
        msg.setMessage(JSON.toJSONString(request));

        activeMqService.sendMessage(msg);
    }

    @Test
    public void test1() {

        String jsonStr = "{\"header\":{\"msgId\":\"M110320175423768\",\"orgId\":\"HK9FPS\",\"timeStamp\":\"2020-03-11T17:03:45.045\",\"ctry\":\"HK\"},\"txnInfo\":{\"txnType\":\"INCOMING RTGS\",\"customerReference\":\"202003111728\",\"txnRefId\":\"T110320175423\",\"txnDate\":\"2020-03-11\",\"valueDt\":\"2020-03-11\",\"receivingParty\":{\"name\":\"\",\"accountNo\":\"000292053\",\"virtualAccountNo\":\"\",\"virtualAccountName\":\"\"},\"amtDtls\":{\"txnCcy\":\"HKD\",\"txnAmt\":0.01},\"senderParty\":{\"name\":\"LAIXIAOER\",\"accountNo\":\"6212262606000575497\",\"senderBankId\":\"HSBCHKHH\"},\"rmtInf\":{\"paymentDetails\":\"\",\"addtlInf\":\"\"}}}";

        ActiveMsgEntity<Object> msg = new ActiveMsgEntity<>();
        msg.setBizCode(ActiveMqBizCode.CUBP_DBS_ICC_MSG_QUEUE);
        msg.setPublishType(1);
        msg.setMsgType(2);
        msg.setMessage(jsonStr);

        for (int i = 0; i < 1; i++) {
            activeMqService.sendMessage(msg);
        }

    }


}
