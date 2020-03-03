package com.minigod.api.adviser.vo.flag;

public enum AdviserSwitchFlag {
	firstPlace(1 << 0), //第一位
	secondPlace(1 << 1); //第二位

	//属性的顺序,从0开始
	private int index;

	//构造参数
	private AdviserSwitchFlag(int index) {
		this.index = index;
	}

	//判断当前属性字段位移后是否为真
	public boolean isFlag(Integer flag) {
		return (flag & this.getIndex()) != 0;
	}

	//获取当前顺序
	private int getIndex() {
		return index;
	}
}