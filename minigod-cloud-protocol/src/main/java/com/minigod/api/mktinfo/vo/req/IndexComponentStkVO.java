/**
 * @Title: IndexComponentStkVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * <code>IndexComponentStkVO</code>
 * 
 * @author XIONGPAN
 * @date 2015-7-1 下午1:46:23
 * @version v1.0
 */
public class IndexComponentStkVO extends BaseVO {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String indAssetId ;//指数资产id
	private String flag ;//从右到左第一位为涨跌幅，第二位为换手率，如"1_0"，表示只返回成分股的换手率列表
	private int count=10;//拉取的条数 默认为10条
	private String compAssetId;//首次请求传空，之后的下拉请求传上次最后一条的compAssetId
	private int sortField;//排序方式   0表示按日涨跌，1表示换手率
	private String sortDir;//排序方向  A 表示升序,即ascend;  D 表示降序,即descend
	
	public String getIndAssetId() {
		return indAssetId;
	}
	public void setIndAssetId(String indAssetId) {
		this.indAssetId = indAssetId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCompAssetId() {
		return compAssetId;
	}
	public void setCompAssetId(String compAssetId) {
		this.compAssetId = compAssetId;
	}
	public int getSortField() {
		return sortField;
	}
	public void setSortField(int sortField) {
		this.sortField = sortField;
	}
	public String getSortDir() {
		return sortDir;
	}
	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}
	
	
	
}
