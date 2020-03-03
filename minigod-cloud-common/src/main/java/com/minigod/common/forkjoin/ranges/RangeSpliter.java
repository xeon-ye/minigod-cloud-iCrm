package com.minigod.common.forkjoin.ranges;

import java.util.List;

/**
 * @Title: RangeSpliter.java
 * @Description: 数的范围，用于记录整数和长整数的范围,用于动态切割
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-3-13 下午4:53:37
 * @version v1.0
 */

public interface RangeSpliter<T extends Number> {

	/**
	 * 把从值域范围的值均分成pieces份
	 * @param start 开始值
	 * @param end 结束值
	 * @param pieces 要分成的片
	 * @return
	 */
	List<Range<T>> split(T start, T end, int pieces);

	List<Range<T>> split(Range<T> range, int pieces);
}
