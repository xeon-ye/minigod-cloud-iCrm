/**
 * @Title: PortfolioDaoImpl.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 组合信息值对象
 * 
 * @author minigod
 * @date 2015-5-13 下午10:26:00
 * @version v1.0
 */

@TransferBean
public class FetchInfoVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	/** 请求组合的类型 : A - 全部组合；F - 关注的组合；B - 买入的组合；*/
	private String type;
	
	/** 组合ID,服务器根据组合ID和排序方式来判断接下来该给哪些数据。不传递此参数表示拉取服务器当前最新的count条数据。 */
	@TransferID
	private Long ptfId;
	
	/** 拉取组合的数量,页码的大小 */
	private Integer count;
	/** 拉取数据的方式: 0表示拉取更新，1表示拉取更多历史数据。 */
	private Integer action;
	/** 排序方式: 0 - 日增长率；1 - 累计收益率； 2 - 创建时间；3 - 月收益率 */
	private Integer sort;
	/** 排序方向: A - 升序；D - 降序 */
	private String sortDir;
	/** 字段标志位，用于表示需要获取组合的哪些字段。*/ 
	private Long flag;
	/** 实盘模拟盘标志位：A - 代表所有类型，S - 模拟，R - 实盘*/ 
	private String isReal;
	
	/** 用户ID：0 - 所有，其他代表具体用户ID,这个字段用来代表需要被查看的用户ID，注意区分sessionID内的userID。*/ 
	@TransferID
	private Long userId;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Long getFlag() {
		return flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}

	public String getSortDir() {
		return sortDir;
	}

	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}

	public String getIsReal() {
		return isReal;
	}

	public void setIsReal(String isReal) {
		this.isReal = isReal;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
