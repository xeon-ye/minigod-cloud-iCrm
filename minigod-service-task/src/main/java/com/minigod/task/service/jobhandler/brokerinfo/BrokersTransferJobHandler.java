package com.minigod.task.service.jobhandler.brokerinfo;

import com.minigod.persist.brokerinfo.mapper.BrokerDataMapper;
import com.minigod.persist.brokerinfo.mapper.BrokerinfoMapper;
import com.minigod.protocol.brokerinfo.model.BrokerData;
import com.minigod.protocol.brokerinfo.model.Brokerinfo;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@JobHandler(value = "brokersTransferJobHandler")
@Component
@Slf4j
public class BrokersTransferJobHandler extends IJobHandler {
    @Autowired
    BrokerinfoMapper brokerinfoMapper;
    @Autowired
    BrokerDataMapper brokerDataMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReturnT<String> execute(String param) throws Exception {
        try {
            List<Brokerinfo> brokerinfos = brokerinfoMapper.selectAll();

            for (Brokerinfo brokerinfo : brokerinfos) {
                String c = brokerinfo.getC();

                if(c.equals("1130")){
                    log.info("1130");
                }
                try {
                    List<BrokerData> brokerDataList = brokerDataMapper.selectAllByCode(c);
                    if (brokerDataList.size() == 0) {
                        continue;
                    }
                    String s = brokerinfo.getS();

                    StringBuilder builder = new StringBuilder();

                    if (StringUtils.isNotEmpty(s)) {
                        builder.append(s);
                        builder.append(",");
                    }
//
                    for (BrokerData brokerData : brokerDataList) {
                        String newBrokerS = brokerData.getBrokerNo();
                        if (StringUtils.isNotEmpty(newBrokerS)) {
                            builder.append(newBrokerS);
                            builder.append(",");
                        }
                    }


                    String newS = builder.toString();

                    String[] tempS = newS.split(",");
                    ArrayList list = new ArrayList();
                    for (int i = 0; i < tempS.length; i++) {
                        if (!list.contains(tempS[i])) {
                            list.add(tempS[i]);
                        }
                    }

                    String[] tempS2 = (String[]) list.toArray(new String[0]);

                    String outS = String.join(",", tempS2);

                    brokerinfo.setS(outS);
                    brokerinfoMapper.updateByPrimaryKeySelective(brokerinfo);
                } catch (Exception e) {
                    log.error("e = {}", e);
                    return FAIL;
                }
            }


//        List<BrokerData> brokerDataList = brokerDataMapper.selectAll();

//        for(BrokerData brokerData: brokerDataList){
//            String id = brokerData.getId();
//            Brokerinfo brokerinfo = brokerinfoMapper.selectOneByC(id);
//
//            if(brokerinfo == null){
//                brokerinfo = new Brokerinfo();
//                brokerinfo.setS("");
//                brokerinfoMapper.insertSelective(brokerinfo);
//            }
//
//            String brokerS = brokerinfo.getS();
//            String newBrokerS = brokerData.getBrokerNo();
//
//            StringBuilder builder = new StringBuilder();
//
//            if(StringUtils.isNotEmpty(brokerS)){
//                builder.append(brokerS);
//                builder.append(",");
//            }
//            builder.append(newBrokerS);
//
//            String s = builder.toString();
//
//            brokerinfo.setS(s);
//
//            BrokerinfoExample example = new BrokerinfoExample();
//            example.or().andCEqualTo(id);
//
//            brokerinfoMapper.updateByExampleSelective(brokerinfo, example);
//
//        }

            return SUCCESS;
        } catch (Exception e) {
            log.error("e = {}", e);
            return FAIL;
        }


    }
}
