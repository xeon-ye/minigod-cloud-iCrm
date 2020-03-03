package com.minigod.api.weixin.vo.resp;

import java.io.Serializable;

public class WeiXinUserInfo extends WeiXin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String openid;//普通用户的标识，对当前开发者帐号唯一
	private String nickname;//普通用户昵称
	private Integer sex;//普通用户性别，1为男性，2为女性
	private String province;//普通用户个人资料填写的省份
	private String city;//普通用户个人资料填写的城市
	private String country;//国家，如中国为CN
	//用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
	private String headimgurl;//http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0
	private String unionid;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public Boolean getSexYQNBoolean() {
		if (sex != null && sex > 0) {
			if (sex == 1) {
				return true;
			} else if (sex == 2) {
				return false;
			} else {
				throw new RuntimeException("微信数据性别类型异常，其值为" + sex);
			}
		}
		return null;
	}

	public Integer getSexYQNInt() {
		if (sex != null && sex > 0) {
			if (sex == 1) {
				return 1;
			} else if (sex == 2) {
				return 0;
			} else {
				throw new RuntimeException("微信数据性别类型异常，其值为" + sex);
			}
		}
		return null;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
}
