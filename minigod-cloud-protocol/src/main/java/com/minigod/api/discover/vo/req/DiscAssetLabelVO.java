
package com.minigod.api.discover.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * <code>DiscAssetLabelVO<code>
 *
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-05)
 *
 */
public class DiscAssetLabelVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private String mkt; // 市场代码，如：HK、US，若不传则搜全部
	private String condition;// 搜索条件

	private Integer flag;// 1<<0 搜索股票  1<<1 搜索概念  1<<2 搜索指数  组合：拉取股票及概念则为 1<<0 + 1<<1 = 1 + 2 =3
	
	public static final int SEARCH_STK = 1<<0;
	public static final int SEARCH_CCT = 1<<1;
	public static final int SEARCH_IDX = 1<<2;
	
	public String getMkt() {
		return mkt;
	}

	public void setMkt(String mkt) {
		this.mkt = mkt;
	}

	public static boolean isFlag(int reqFlag,int mask) {
		return (reqFlag & mask) != 0;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}


}
