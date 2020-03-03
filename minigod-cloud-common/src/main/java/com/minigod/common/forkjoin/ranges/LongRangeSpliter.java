package com.minigod.common.forkjoin.ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: LongRangeSpliter.java
 * @Description: 长整型数的平均分配
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-3-13 下午4:53:37
 * @version v1.0
 */

public class LongRangeSpliter implements RangeSpliter<Long> {
	public List<Range<Long>> split(Long start, Long end, int pieces) {
		List<Range<Long>> pairList = new ArrayList<Range<Long>>();
		double step = (end - start + 1) / (double) pieces;
		for (double i = start; i < end; i += step) {
			Range<Long> range = new Range<Long>(Math.round(i), Math.round(i + step - 1));
			pairList.add(range);
		}
		return pairList;
	}

	public List<Range<Long>> split(Range<Long> range, int pieces) {
		return split(range.getStart(), range.getEnd(), pieces);
	}
}
