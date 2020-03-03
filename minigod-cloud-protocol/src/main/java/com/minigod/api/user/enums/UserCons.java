package com.minigod.api.user.enums;


public class UserCons {
	
	public static class CHLCOFTYPE{
		public final static int PT = 1;
		public final static int DZ = 2;
	}
	
	public static enum QRCODE {
		_QD(1, "推广渠道二维码");
		private int val;

		private QRCODE(int val, String desc) {
			this.val = val;
		}

		public int val() {
			return val;
		}
		
		public static Boolean isExist(int flag) {
			boolean bool = false;
			for (QRCODE ext : QRCODE.values()) {
				if (ext.val() == flag) {
					bool = true;
				}
			}
			return bool;
		}

	}
}
