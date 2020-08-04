package com.sunline.modules.call.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @description: 查询通话记录回参协议
 * @author: Larry Lai
 * @date: 2019/3/4 17:42
 * @version: v1.0
 */

public class CallRecordResponse {

    private Boolean success;

    private String message;

    private List<CallRecordData> data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CallRecordData> getData() {
        return data;
    }

    public void setData(List<CallRecordData> data) {
        this.data = data;
    }

    public class CallRecordData {

        @JSONField(name = "id")
        private String _id;

        @JSONField(name = "callSheetId")
        private String CALL_SHEET_ID;

        @JSONField(name = "callNo")
        private String CALL_NO;

        @JSONField(name = "calledNo")
        private String CALLED_NO;

        @JSONField(name = "callId")
        private String CALL_ID;

        @JSONField(name = "endTime")
        private String END_TIME;

        @JSONField(name = "connectType")
        private String CONNECT_TYPE;

        @JSONField(name = "status")
        private String STATUS;

        @JSONField(name = "exten")
        private String EXTEN;

        @JSONField(name = "disposalAgent")
        private String DISPOSAL_AGENT;

        @JSONField(name = "beginTime")
        private String BEGIN_TIME;

        @JSONField(name = "offeringTime")
        private String OFFERING_TIME;

        @JSONField(name = "recordFileName")
        private String RECORD_FILE_NAME;

        @JSONField(name = "customerName")
        private String CUSTOMER_NAME;

        @JSONField(name = "refCallSheetId")
        private String REF_CALL_SHEET_ID;

        @JSONField(name = "pbx")
        private String PBX;

        @JSONField(name = "queueName")
        private String QUEUE_NAME;

        @JSONField(name = "fileServer")
        private String FILE_SERVER;

        @JSONField(name = "province")
        private String PROVINCE;

        @JSONField(name = "district")
        private String DISTRICT;

        @JSONField(name = "districtCode")
        private String DISTRICT_CODE;

        @JSONField(name = "keyTag")
        private String KEY_TAG;

        @JSONField(name = "callTimeLength")
        private Integer CALL_TIME_LENGTH;

        @JSONField(name = "investigate")
        private String INVESTIGATE;

        @JSONField(name = "actionId")
        private String ACTION_ID;

        public String getCALL_SHEET_ID() {
            return CALL_SHEET_ID;
        }

        public void setCALL_SHEET_ID(String CALL_SHEET_ID) {
            this.CALL_SHEET_ID = CALL_SHEET_ID;
        }

        public String getCALL_NO() {
            return CALL_NO;
        }

        public void setCALL_NO(String CALL_NO) {
            this.CALL_NO = CALL_NO;
        }

        public String getCALLED_NO() {
            return CALLED_NO;
        }

        public void setCALLED_NO(String CALLED_NO) {
            this.CALLED_NO = CALLED_NO;
        }

        public String getCALL_ID() {
            return CALL_ID;
        }

        public void setCALL_ID(String CALL_ID) {
            this.CALL_ID = CALL_ID;
        }

        public String getEND_TIME() {
            return END_TIME;
        }

        public void setEND_TIME(String END_TIME) {
            this.END_TIME = END_TIME;
        }

        public String getCONNECT_TYPE() {
            return CONNECT_TYPE;
        }

        public void setCONNECT_TYPE(String CONNECT_TYPE) {
            this.CONNECT_TYPE = CONNECT_TYPE;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getEXTEN() {
            return EXTEN;
        }

        public void setEXTEN(String EXTEN) {
            this.EXTEN = EXTEN;
        }

        public String getDISPOSAL_AGENT() {
            return DISPOSAL_AGENT;
        }

        public void setDISPOSAL_AGENT(String DISPOSAL_AGENT) {
            this.DISPOSAL_AGENT = DISPOSAL_AGENT;
        }

        public String getBEGIN_TIME() {
            return BEGIN_TIME;
        }

        public void setBEGIN_TIME(String BEGIN_TIME) {
            this.BEGIN_TIME = BEGIN_TIME;
        }

        public String getOFFERING_TIME() {
            return OFFERING_TIME;
        }

        public void setOFFERING_TIME(String OFFERING_TIME) {
            this.OFFERING_TIME = OFFERING_TIME;
        }

        public String getRECORD_FILE_NAME() {
            return RECORD_FILE_NAME;
        }

        public void setRECORD_FILE_NAME(String RECORD_FILE_NAME) {
            this.RECORD_FILE_NAME = RECORD_FILE_NAME;
        }

        public String getCUSTOMER_NAME() {
            return CUSTOMER_NAME;
        }

        public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
            this.CUSTOMER_NAME = CUSTOMER_NAME;
        }

        public String getREF_CALL_SHEET_ID() {
            return REF_CALL_SHEET_ID;
        }

        public void setREF_CALL_SHEET_ID(String REF_CALL_SHEET_ID) {
            this.REF_CALL_SHEET_ID = REF_CALL_SHEET_ID;
        }

        public String getPBX() {
            return PBX;
        }

        public void setPBX(String PBX) {
            this.PBX = PBX;
        }

        public String getQUEUE_NAME() {
            return QUEUE_NAME;
        }

        public void setQUEUE_NAME(String QUEUE_NAME) {
            this.QUEUE_NAME = QUEUE_NAME;
        }

        public String getFILE_SERVER() {
            return FILE_SERVER;
        }

        public void setFILE_SERVER(String FILE_SERVER) {
            this.FILE_SERVER = FILE_SERVER;
        }

        public String getPROVINCE() {
            return PROVINCE;
        }

        public void setPROVINCE(String PROVINCE) {
            this.PROVINCE = PROVINCE;
        }

        public String getDISTRICT() {
            return DISTRICT;
        }

        public void setDISTRICT(String DISTRICT) {
            this.DISTRICT = DISTRICT;
        }

        public String getDISTRICT_CODE() {
            return DISTRICT_CODE;
        }

        public void setDISTRICT_CODE(String DISTRICT_CODE) {
            this.DISTRICT_CODE = DISTRICT_CODE;
        }

        public String getKEY_TAG() {
            return KEY_TAG;
        }

        public void setKEY_TAG(String KEY_TAG) {
            this.KEY_TAG = KEY_TAG;
        }

        public Integer getCALL_TIME_LENGTH() {
            return CALL_TIME_LENGTH;
        }

        public void setCALL_TIME_LENGTH(Integer CALL_TIME_LENGTH) {
            this.CALL_TIME_LENGTH = CALL_TIME_LENGTH;
        }

        public String getINVESTIGATE() {
            return INVESTIGATE;
        }

        public void setINVESTIGATE(String INVESTIGATE) {
            this.INVESTIGATE = INVESTIGATE;
        }

        public String getACTION_ID() {
            return ACTION_ID;
        }

        public void setACTION_ID(String ACTION_ID) {
            this.ACTION_ID = ACTION_ID;
        }
    }
}
