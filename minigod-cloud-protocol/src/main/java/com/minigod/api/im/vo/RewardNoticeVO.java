/**
 * @Title： RewardNoticeVO.java
 * @Copyright： © 2015 minigod
 * @Company： minigod
 */

package com.minigod.api.im.vo;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;

import com.minigod.api.im.enums.EPayBusCode;
import com.minigod.common.utils.DateUtils;
import com.minigod.common.utils.DateUtils.TimeFormatter;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-30 下午8：50：24
 * @version v1.0
 */

public class RewardNoticeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String title;

	private String amount;

	private Long ts;

	private String name;

	private EPayBusCode payBusCode;

	private String actAmount; // 实际金额

	@Override
	public String toString() {
		StringBuilder oBuilder = new StringBuilder();
		String str = null;
		if (EPayBusCode.REWD001 == payBusCode) {
			str = "直播群";
		} else if (EPayBusCode.REWD002 == payBusCode) {
			str = "观点";
		} else {
			throw new RuntimeException("不支持的类型，payBusCode=" + payBusCode);
		}
		oBuilder.append(
				MessageFormat.format("<font color=#666666>你好，你的{0}【{1}】收到一笔赞赏。</font><br><br>",
						str, title))
				.append("<font color=#999999>金额：</font><font color=#666666>")
				.append(amount)
				.append("元</font><br>")
				.append("<font color=#999999>赞赏人：</font><font color=#666666>")
				.append(name)
				.append("</font><br><font color=#999999>时间：</font><font color=#666666>")
				.append(DateUtils.dateToString(new Date(ts), TimeFormatter.YYYY_MM_DD_HH_MM_SS))
				.append("</font><br><font color=#999999>实际收入：</font><font color=#ff5a00>")
				.append(actAmount)
				.append("元</font><br>");
		
		return oBuilder.toString();
	}

	public String getActAmount() {
		return actAmount;
	}

	public void setActAmount(String actAmount) {
		this.actAmount = actAmount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EPayBusCode getPayBusCode() {
		return payBusCode;
	}

	public void setPayBusCode(EPayBusCode payBusCode) {
		this.payBusCode = payBusCode;
	}

}
