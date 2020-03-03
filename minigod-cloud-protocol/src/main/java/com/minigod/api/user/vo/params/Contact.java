package com.minigod.api.user.vo.params;

import java.util.List;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

@TransferBean
public class Contact extends SNUserBase {

	private static final long serialVersionUID = -8973605427918040551L;
	
	@Emoji
	private List<Contacts> phoneNums;

	public List<Contacts> getPhoneNums() {
		return phoneNums;
	}

	public void setPhoneNums(List<Contacts> phoneNums) {
		this.phoneNums = phoneNums;
	}
}