package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * @Author: PENGFENG
 * @Description:
 * @Date: Created in 11:35 2017/10/11
 * @Modified By:
 */
public class OpenDerivativeVO extends SNVersion {

    private OpenDerivativeReqVO params;

    public OpenDerivativeReqVO getParams() {
        return params;
    }

    public void setParams(OpenDerivativeReqVO params) {
        this.params = params;
    }

    public class OpenDerivativeReqVO extends BaseVO {

        private String info;

        private String requestSource; // 终端类型 andriod ios h5

        private Integer approveBusinessType; // 0:未知 1:衍生品交易 2:美股增开户

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getRequestSource() {
            return requestSource;
        }

        public void setRequestSource(String requestSource) {
            this.requestSource = requestSource;
        }

        public Integer getApproveBusinessType() {
            return approveBusinessType;
        }

        public void setApproveBusinessType(Integer approveBusinessType) {
            this.approveBusinessType = approveBusinessType;
        }
    }

}
