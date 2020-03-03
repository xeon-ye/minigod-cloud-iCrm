/**
 * @Title: BrokerLoginVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-7-7 上午9:11:42
 * @version v1.0
 */

public class BrokerLoginVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private Integer bId;// 券商ID
	private Integer accTyp;// 账号类型
	private String acc;// 账号
	private String pwd;// 密码
	private String opSta;// 操作站点
	private String imei;// 移动终端IMEI
	private String uuid;// 移动终端UUID
	private String key;// 解密的Key

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public Integer getAccTyp() {
		return accTyp;
	}

	public void setAccTyp(Integer accTyp) {
		this.accTyp = accTyp;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getOpSta() {
		return opSta;
	}

	public void setOpSta(String opSta) {
		this.opSta = opSta;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
