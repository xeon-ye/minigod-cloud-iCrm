/**
 * @Title： GrpPaidNoticeForAdviserVO.java
 * @Copyright： © 2015 minigod
 * @Company： minigod
 */

package com.minigod.api.im.vo;

import java.text.MessageFormat;
import java.util.Date;

import com.minigod.api.im.vo.GrpPaidNoticeForBeginnerVO;
import com.minigod.common.utils.DateUtils;
import com.minigod.common.utils.DateUtils.TimeFormatter;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-11-30 下午8：12：33
 * @version v1.0
 */

public class GrpPaidNoticeForAdviserVO extends GrpPaidNoticeForBeginnerVO {
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		StringBuilder oBuilder = new StringBuilder();
		oBuilder.append(MessageFormat.format("<font color=#666666>你好，有人加入了你的直播群【{0}】。</font><br><br>", getGroupName()))
		.append("<font color=#999999>金额：</font><font color=#666666>")
		.append(getAmount())
		.append("富尊币</font><br>")
		.append("<font color=#999999>购买人：</font><font color=#666666>")
		.append(getName())
		.append("</font><br>")
		.append("<font color=#999999>服务期：</font><font color=#666666>")
		.append(getQty())
		.append("个月，")
		.append(DateUtils.dateToString(new Date(getStartTs()), TimeFormatter.YYYY_MM_DD))
		.append("至")
		.append(DateUtils.dateToString(new Date(getEndTs()), TimeFormatter.YYYY_MM_DD))
		.append("</font><br><font color=#999999>实际收入：</font><font color=#ff5a00>")
		.append(getActAmount())
		.append("富尊币</font><br>");
		return oBuilder.toString();
	}
}
