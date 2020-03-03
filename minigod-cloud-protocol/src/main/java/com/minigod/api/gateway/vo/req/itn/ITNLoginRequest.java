/**
 * @Title: ITNLoginRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.itn;

/**
 * @description iTN登陆请求
 *
 * @author 余俊斌
 * @date 2015年7月2日 上午9:48:51
 * @version v1.0
 */

public class ITNLoginRequest extends ITNRequest {

	private static final long serialVersionUID = 1L;
	// 目标机构编码
	private String targetcomp_id;
	// 发送机构编码
	private String sendercomp_id;
	// 业务系统编号，证券交易必须填1000
	private String targetbusinsys_no;
	// 站点信息
	private String op_station;
	// 密钥信息
	private String secret_key_info;
	// 密码
	private String password;
	// 帐号类别, 1表示资金帐号，6表示客户号
	private String input_content;
	// 资金帐号或者客户号
	private String account_content;
	// 终端设备IMEI
	private String imei_code;
	// 终端设备UUID
	private String mobile_uuid;
	// 终端设备标识字符串，如：IPHONE、IPAD等
	private String terminal_device;
	// 终端设备的操作系统 如：iOS 6.1、Windows 8等
	private String terminal_os;
	// 浏览器的产品名称/应用的产品名称
	private String terminal_platform;

	public String getTargetcomp_id() {
		return targetcomp_id;
	}

	public void setTargetcomp_id(String targetcomp_id) {
		this.targetcomp_id = targetcomp_id;
	}

	public String getSendercomp_id() {
		return sendercomp_id;
	}

	public void setSendercomp_id(String sendercomp_id) {
		this.sendercomp_id = sendercomp_id;
	}

	public String getTargetbusinsys_no() {
		return targetbusinsys_no;
	}

	public void setTargetbusinsys_no(String targetbusinsys_no) {
		this.targetbusinsys_no = targetbusinsys_no;
	}

	public String getOp_station() {
		return op_station;
	}

	public void setOp_station(String op_station) {
		this.op_station = op_station;
	}

	public String getSecret_key_info() {
		return secret_key_info;
	}

	public void setSecret_key_info(String secret_key_info) {
		this.secret_key_info = secret_key_info;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInput_content() {
		return input_content;
	}

	public void setInput_content(String input_content) {
		this.input_content = input_content;
	}

	public String getAccount_content() {
		return account_content;
	}

	public void setAccount_content(String account_content) {
		this.account_content = account_content;
	}

	public String getImei_code() {
		return imei_code;
	}

	public void setImei_code(String imei_code) {
		this.imei_code = imei_code;
	}

	public String getMobile_uuid() {
		return mobile_uuid;
	}

	public void setMobile_uuid(String mobile_uuid) {
		this.mobile_uuid = mobile_uuid;
	}

	public String getTerminal_device() {
		return terminal_device;
	}

	public void setTerminal_device(String terminal_device) {
		this.terminal_device = terminal_device;
	}

	public String getTerminal_os() {
		return terminal_os;
	}

	public void setTerminal_os(String terminal_os) {
		this.terminal_os = terminal_os;
	}

	public String getTerminal_platform() {
		return terminal_platform;
	}

	public void setTerminal_platform(String terminal_platform) {
		this.terminal_platform = terminal_platform;
	}
}
