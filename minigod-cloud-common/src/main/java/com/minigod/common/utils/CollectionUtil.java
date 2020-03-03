package com.minigod.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtil {

	public static <T> List<List<T>> split(Collection<T> array, int pageSize) {
		List<T> list = new ArrayList<T>();
		list.addAll(array);
		List<List<T>> result = new ArrayList<List<T>>(list.size() / pageSize + 1);
		for (int i = 0, next, max = list.size(); i < max; i = next) {
			next = i + pageSize;
			if (next > max) {
				next = max;
			}
			result.add(list.subList(i, next));
		}
		return result;
	}

	public static void main(String[] args) {
		List<Object> lists = new ArrayList<Object>();
		for (int i = 0; i < 23; i++) {
			lists.add(i);
		}
		System.err.println(split(lists, 20));
	}
}
