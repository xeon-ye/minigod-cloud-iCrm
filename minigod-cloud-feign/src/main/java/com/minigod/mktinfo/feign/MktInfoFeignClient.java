package com.minigod.mktinfo.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "minigod-mktinfo-service")
public interface MktInfoFeignClient {

	/**
	 * 资产的状态，正常0的情况下细分为未开盘6；交易中7；已收盘8
	 * @param assetId
	 * @return
	 */
	@RequestMapping(value = "/mktInfo/getDetailStkStatus", method = RequestMethod.GET)
	int getDetailStkStatus(@RequestParam("assetId") String assetId);

}
