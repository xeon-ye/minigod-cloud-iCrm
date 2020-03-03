package com.minigod.common.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Title: IDUtils.java
 * @Description: 协议层通用Id转换工具
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author 许德祐
 * @date 2015-3-23 上午11:24:10
 * @version v1.0
 */

public class IDTransUtil {

	public static void main(String[] args) {
		System.err.println(encodeId(123456, 123456));
		int key = 123;
		/*for (long id = 999999990; id < 999999999; id++) {
			long encode = encodeId(id, key);
			System.err.println("加密" + id + "=" + encode);
			long decode = decodeId(encode, key);
			System.err.println("解密" + id + "=" + decode);
			System.out.println(String.format("原值：%d,加密值十进制:%d,加密值（十六进制）：%s,还原后值：%d是否相等：%b", id, encode, Long.toHexString(encode), decode, decode == id));
		}*/
		long l = 102;
		long el = encodeId(l, SecurityKey.ID_KEY);
		System.out.println(el);
	}

	//注意末尾必须要有l
	private static long LONGMASK = 0x00000000ffffffffl;

	private static final int A_NUMBER = 1458453879;

	private static Map<Integer, Integer> HEX_SWITCH_MAP = new HashMap<Integer, Integer>();

	static {
		HEX_SWITCH_MAP.put(0, 0);
		HEX_SWITCH_MAP.put(3, 6);
		HEX_SWITCH_MAP.put(4, 7);
		HEX_SWITCH_MAP.put(6, 5);
		HEX_SWITCH_MAP.put(8, 1);
		HEX_SWITCH_MAP.put(10, 4);
		HEX_SWITCH_MAP.put(13, 2);
		HEX_SWITCH_MAP.put(15, 3);
	}

	private static int INT_MASK[] = { 0x0000000f, //
			0x000000f0,//
			0x00000f00,//
			0x0000f000,//
			0x000f0000,//
			0x00f00000,//
			0x0f000000,//
			0xf0000000
	//		
	};

	private static long LONG_MASK[] = { 0x000000000000000fl,//
			0x00000000000000f0l,//
			0x0000000000000f00l,// 
			0x000000000000f000l,// 
			0x00000000000f0000l,// 
			0x0000000000f00000l,// 
			0x000000000f000000l,//
			0x00000000f0000000l,//
			0x0000000f00000000l,//
			0x000000f000000000l,//
			0x00000f0000000000l,//
			0x0000f00000000000l,//
			0x000f000000000000l,//
			0x00f0000000000000l,//
			0x0f00000000000000l,//
			0xf000000000000000l
	//		
	};

	/**
	 * 加密:对整数id进行可逆混淆 
	 * @param id 待混淆的id
	 * @return
	 */
	public static Long encodeId(long id, long key) {
		if (id > 0) {
			long encoded = 0;

			int length = INT_MASK.length - 1;

			//这里填入的字段,解密时需要用到
			Long sid = id ^ key;
			for (Entry<Integer, Integer> entry : HEX_SWITCH_MAP.entrySet()) {
				long part = sid & INT_MASK[length - entry.getValue()] & LONGMASK;
				int deltaPos = ((16 - entry.getKey()) - (8 - entry.getValue())) * 4;
				if (deltaPos > 0) {
					part <<= deltaPos;
				}

				if (deltaPos < 0) {
					//无符号右移
					part >>>= -deltaPos;
				}

				encoded |= part;
			}

			//这里填入的字段,用于混淆,解密时无需使用;997为质数,为了使得加1减1产生的变化更大,运算不可逆;求余是为了防止溢出;
			long useLessPart = -(Math.abs(id - A_NUMBER) * 997 % Long.MAX_VALUE) ^ key;

			for (int i = 0, j = 0; i < 16; i++) {
				Integer integer = HEX_SWITCH_MAP.get(i);
				if (integer != null) {
					continue;
				}

				//找到了空缺的位置,将其按序填上
				long part = LONGMASK & (useLessPart & INT_MASK[length - j]);
				int deltaPos = ((16 - i) - (8 - j)) * 4;
				if (part > 0) {
					part <<= deltaPos;
				}
				if (part < 0) {
					//无符号右移
					part >>>= deltaPos;
				}
				encoded |= part;
				j++;
			}
			return encoded;
		}
		return id;
	}

	/**
	 * 解密:对通过encodeId混淆的id进行还原 
	 * @param id 待还原的id
	 * @return
	 */
	public static Long decodeId(long id, long key) {
		if (id > 0) {
			long decoded = 0;
			int length = LONG_MASK.length - 1;
			for (Entry<Integer, Integer> entry : HEX_SWITCH_MAP.entrySet()) {
				Integer longPos = entry.getKey();
				long lMask = LONG_MASK[length - longPos];
				long part = lMask & id;

				int deltaPos = ((16 - entry.getKey()) - (8 - entry.getValue())) * 4;
				if (deltaPos > 0) {
					part >>>= deltaPos;
				}
				if (deltaPos < 0) {
					//无符号右移
					part <<= -deltaPos;
				}
				decoded |= part;
			}
			return decoded = decoded ^ key;
		}
		return id;
	}
}
