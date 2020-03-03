/**
 * @Title: ITNOrderRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.itn;

/**
 * @description iTN委托请求
 *
 * @author 余俊斌
 * @date 2015年7月2日 上午10:28:15
 * @version v1.0
 */

public class ITNOrderRequest extends ITNRequest {

	private static final long serialVersionUID = 1L;
	// 交易类别 - 1-上海 2-深圳 9-特转A A-特转B D-沪B H-深B
	private String exchange_type;
	// 证券账号 - 当前市场的主证券账户
	private String stock_account;
	// 证券代码
	private String stock_code;
	// 委托数量
	private Double entrust_amount;
	// 委托价格
	private Double entrust_price;
	// 买卖方向
	private String entrust_bs;
	// 委托属性 - 0-买卖 3-申购 (股转 b,c,d,e) (市价委托 上海：R,U 深圳：Q,R,S,T,U,V)
	private String entrust_prop;

	public String getExchange_type() {
		return exchange_type;
	}

	public void setExchange_type(String exchange_type) {
		this.exchange_type = exchange_type;
	}

	public String getStock_account() {
		return stock_account;
	}

	public void setStock_account(String stock_account) {
		this.stock_account = stock_account;
	}

	public String getStock_code() {
		return stock_code;
	}

	public void setStock_code(String stock_code) {
		this.stock_code = stock_code;
	}

	public Double getEntrust_amount() {
		return entrust_amount;
	}

	public void setEntrust_amount(Double entrust_amount) {
		this.entrust_amount = entrust_amount;
	}

	public Double getEntrust_price() {
		return entrust_price;
	}

	public void setEntrust_price(Double entrust_price) {
		this.entrust_price = entrust_price;
	}

	public String getEntrust_bs() {
		return entrust_bs;
	}

	public void setEntrust_bs(String entrust_bs) {
		this.entrust_bs = entrust_bs;
	}

	public String getEntrust_prop() {
		return entrust_prop;
	}

	public void setEntrust_prop(String entrust_prop) {
		this.entrust_prop = entrust_prop;
	}
}
