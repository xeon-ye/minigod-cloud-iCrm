package com.minigod.api.mktmgr.enums;

import java.util.HashMap;
import java.util.Map;


public interface MktmgrCons {
	
	public static enum CodeType{
	 	MKTMGR_CLICK_ERROR(888, "点击数不够或无权限"), 
    	MKTMGR_STREAM_ERROR(889, "服务已过期"),
	 	MKTMGR_SESSION_ERROR(890, "行情认证失败"),
	 	MKTMGR_APPLY_ERROR(891, "行情申请失败");
	 	
        private int code;
        private String message;

        private CodeType(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    	
	}
	
	public static enum OrderWay {
		_ZG("1", "支付"), _ZS("2", "赠送");
		private String val;

		private OrderWay(String val, String desc) {
			this.val = val;
		}

		public String val() {
			return val;
		}
	}
	
	
	public static enum PCode {
		_TC1("1", "套餐1(港串流)"), _TC2("2", "套餐2(bpm&点击报价)"), _TC4("4", "套餐4(美串流)");
		private String val;

		private PCode(String val, String desc) {
			this.val = val;
		}

		public String val() {
			return val;
		}
		
		public static Boolean isExist(String flag) {
			boolean bool = false;
			for (PCode ext : PCode.values()) {
				if (ext.val().equals(flag)) {
					bool = true;
				}
			}
			return bool;
		}

	}
	
	public static enum MarketType {
		_GGHQ("1", "港股行情","HK"), _MGHQ("2", "美股行情","US");
		private String val;
		private String key;
		private MarketType(String val, String desc,String key) {
			this.val = val;
			this.key = key;
		}

		public String key() {
			return key;
		}


		public String val() {
			return val;
		}
	}
	
	public static enum FeeWay {
		_CL("1", "串流"), _BMP("2", "bmp"),_DJ("3", "点击");
		private String val;

		private FeeWay(String val, String desc) {
			this.val = val;
		}

		public String val() {
			return val;
		}
	}
	
	
	public static enum Exchange{
		A("NYSE"),B("AMEX/ARCA"),C("Nasdaq");
		private String desc;
		private Exchange(String desc) {
			this.desc = desc;
		}
		public String desc(){
			return desc;
		}
		
	}

}
