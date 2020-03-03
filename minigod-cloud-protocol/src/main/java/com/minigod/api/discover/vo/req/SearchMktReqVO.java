
package com.minigod.api.discover.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;


public class SearchMktReqVO extends SNVersion {

	private static final long serialVersionUID = 1825011933664783416L;

	private SearchMktVO params;

	/**
	 * @return the params
	 */
	public SearchMktVO getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(SearchMktVO params) {
		this.params = params;
	}
	
	public static class SearchMktVO extends BaseVO {

		private static final long serialVersionUID = 1L;

		private String condition;// 搜索条件
		private Integer flag;// 1<<0 搜索股票/基金/指数  1<<1 搜索概念  1<<2 搜索行业  组合：拉取股票及概念则为 1<<0 + 1<<1 = 1 + 2 =3
		private Integer pageSize;//一页返回的记录数
//		private String locateId;//定位ID
		
		public static final int SEARCH_STK_FUD_IDX = 1<<0;
		public static final int SEARCH_CCT = 1<<1;
		public static final int SEARCH_INDU = 1<<2;
		
		public static boolean isFlag(int reqFlag,int mask) {
			return (reqFlag & mask) != 0;
		}

		/**
		 * @return the condition
		 */
		public String getCondition() {
			return condition;
		}

		/**
		 * @param condition
		 *            the condition to set
		 */
		public void setCondition(String condition) {
			this.condition = condition;
		}

		public Integer getFlag() {
			return flag;
		}

		public void setFlag(Integer flag) {
			this.flag = flag;
		}

		public Integer getPageSize() {
			return pageSize;
		}

		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}

//		public String getLocateId() {
//			return locateId;
//		}
//
//		public void setLocateId(String locateId) {
//			this.locateId = locateId;
//		}
	}

}
