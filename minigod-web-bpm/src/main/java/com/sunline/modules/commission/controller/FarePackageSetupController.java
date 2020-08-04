package com.sunline.modules.commission.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.commission.entity.FarePackageSetupEntity;
import com.sunline.modules.commission.service.FarePackageSetupService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunline.modules.common.utils.PageUtils;
import com.sunline.modules.common.utils.Query;
import com.sunline.modules.common.utils.Result;


/**
 * 柜台佣金套餐设置表
 *
 * @author lcs
 * @email
 * @date 2018-08-20 13:17:13
 */
@RestController
@RequestMapping("farePackageSetup")
public class FarePackageSetupController extends BaseController {
    @Autowired
    private FarePackageSetupService farePackageSetupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//	@RequiresPermissions("farePackageSetup:list")
    public Result list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<FarePackageSetupEntity> farePackageSetupList = farePackageSetupService.queryList(query);
        int total = farePackageSetupService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(farePackageSetupList, total, query.getLimit(), query.getPage());

        return Result.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//	@RequiresPermissions("farePackageSetup:info")
    public Result info(@PathVariable("id") String fareKind) {
        Map<String, Object> entity = Maps.newHashMap();
        entity.put("fareKind",fareKind);
        StringBuffer tips = new StringBuffer();
        List<FarePackageSetupEntity> farePackageSetupList = farePackageSetupService.queryList(entity);
        for (FarePackageSetupEntity fareInfo : farePackageSetupList) {
            tips.append("证券市场：" + CodeUtils.getCodeName("SEC_EXCHANGE_TYPE", fareInfo.getExchangeType()) + "</br>付费数值：" + fareInfo.getBalanceRatio().stripTrailingZeros() +
                    "</br>固定费用：" + fareInfo.getFeeCountFix().toString() + "</br>最高费用：" + fareInfo.getMaxFare().toString() + "</br>最低费用：" + fareInfo.getMinFare().toString()+"</br>");
        }
        return Result.ok().put("tips", tips);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("farePackageSetup:save")
    public Result save(@RequestBody FarePackageSetupEntity farePackageSetup) {
        farePackageSetupService.save(farePackageSetup);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("farePackageSetup:update")
    public Result update(@RequestBody FarePackageSetupEntity farePackageSetup) {
        farePackageSetupService.update(farePackageSetup);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("farePackageSetup:delete")
    public Result delete(@RequestBody Integer[] ids) {
        farePackageSetupService.deleteBatch(ids);

        return Result.ok();
    }

}
