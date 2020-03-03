package com.minigod.common.forkjoin.ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: IntegerRangeSpliter.java
 * @Description: 整型数字的平均切分
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-3-13 下午4:53:37
 * @version v1.0
 */

public class IntegerRangeSpliter implements RangeSpliter<Integer> {
	public List<Range<Integer>> split(Integer start, Integer end, int pieces) {
		List<Range<Integer>> pairList = new ArrayList<Range<Integer>>();
		float step = (end - start + 1) / (float) pieces;
		for (float i = start; i < end; i += step) {
			Range<Integer> range = new Range<Integer>(Math.round(i), Math.round(i + step - 1));
			pairList.add(range);
		}
		return pairList;
	}

	public List<Range<Integer>> split(Range<Integer> range, int pieces) {
		return split(range.getStart(), range.getEnd(), pieces);
	}
}
