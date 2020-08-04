package com.sunline.modules.stock.controller;

import cn.hutool.json.JSONObject;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.modules.hundsun.protocol.request.FundRequest;
import com.sunline.modules.hundsun.service.HsFundManageService;
import com.sunline.modules.hundsun.service.HsStockManageService;
import com.sunline.modules.notice.entity.NoticeCaseEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import com.sunline.modules.notice.service.NoticeCaseService;
import com.sunline.modules.notice.service.UserNoticeService;
import com.sunline.modules.stock.entity.HsFundEntity;
import com.sunline.modules.stock.entity.StockOrderInfoEntity;
import com.sunline.modules.stock.entity.StockPositionEntity;
import com.sunline.modules.stock.service.StockOrderInfoService;
import com.sunline.modules.stock.utils.StockUtils;
import com.sunline.modules.sys.entity.NoticeEntity;
import com.sunline.modules.sys.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 * 股票订单信息表
 * 
 * @author lcs
 * @date 2018-12-07 15:19:20
 */

@Controller
@RequestMapping("/stockOrderInfo")
public class StockOrderInfoController extends BaseController {

    @Autowired
    StockOrderInfoService stockOrderInfoService;
    @Autowired
    UserNoticeService userNoticeService;
    @Autowired
    NoticeCaseService noticeCaseService;
    @Autowired
    UserService userService;
    @Autowired
    MessageSendInfoService messageSendInfoService;
    @Autowired
    SecUserInfoService secUserInfoService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/stockOrderList")
    @RequiresPermissions("stockOrderInfo:list")
    public String stockOrderList(HttpServletRequest request, Model model, StockOrderInfoEntity stockOrderInfo){
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        Page<StockOrderInfoEntity> page = stockOrderInfoService.findPage(stockOrderInfo, pageNum);

        model.addAttribute("page",page);
        model.addAttribute("stockOrderInfo",stockOrderInfo);
        return "stock/stockOrderList";
    }

    @RequestMapping(value = "/stockOrderDetail")
//    @RequiresPermissions("stockOrderInfo:detail")
    public String stockOrderDetail(HttpServletRequest request, Model model, StockOrderInfoEntity stockOrderInfo){

        StockOrderInfoEntity stockOrderResult = stockOrderInfoService.queryObject(stockOrderInfo.getId());
        model.addAttribute("stockOrderResult",stockOrderResult);

        return "stock/stockOrderDetail";
    }

    @RequestMapping(value = "/saveAndUpdate")
    public @ResponseBody Result saveStockOrder(StockOrderInfoEntity stockOrderInfo){
        int count = 0;
        try{
            if(null == stockOrderInfo.getId() || StringUtils.isEmpty(stockOrderInfo.getId())){
                stockOrderInfo.setCreateTime(new Date());
                stockOrderInfo.setCreateUser(UserUtils.getCurrentUser().getUserName());
                //默认未发送
                stockOrderInfo.setStatus(0);
                count = stockOrderInfoService.save(stockOrderInfo);
            }else{
                count = stockOrderInfoService.update(stockOrderInfo);
            }

        }catch (Exception e){
            logger.error("股票下单失败",e);
            return Result.error("股票下单失败");
        }

        if(count>0){
            return Result.ok("下单成功");
        }else{
            return Result.error("股票下单失败");
        }
    }

    //删除下单指令
    @RequestMapping(value = "/deleteOrder")
    public @ResponseBody Result deleteOrder(StockOrderInfoEntity stockOrderInfo){
        int count = 0;
        try{
            count = stockOrderInfoService.delete(stockOrderInfo.getId());
        }catch (Exception e){
            logger.error("股票下单删除失败",e);
            return Result.error("股票下单删除失败");
        }

        if(count>0){
            return Result.ok("删除成功");
        }else{
            return Result.error("股票下单删除失败");
        }
    }

    //发送下单通知
    @RequestMapping(value = "/sendOrderNotice")
    @Transactional(rollbackFor = Exception.class)
    public @ResponseBody Result sendOrderNotice(StockOrderInfoEntity stockOrderInfo){
        int count = 0;
        try{
            count = stockOrderInfoService.updateStatus(stockOrderInfo.getId());
            if(count>0){
                stockOrderInfo = stockOrderInfoService.queryObject(stockOrderInfo.getId());
                // 发送通知
                NoticeEntity params = new NoticeEntity();
                //下单通知的方案code 为 1
                NoticeCaseEntity noticeCase = noticeCaseService.queryByCode("1");
                String context = noticeCase.getNoticeContext();
                params.setTitle(noticeCase.getNoticeCaseName());
                //获取自营账户信息
                SecuritiesUserInfoEntity userInfoEntity = new SecuritiesUserInfoEntity();
                userInfoEntity.setFundAccount(SysConfigUtil.getSysConfigValue("DONATED_STK_FUND_ACCOUNT",null));
                SecuritiesUserInfoEntity securitiesUserInfo =  secUserInfoService.queryObject(userInfoEntity);

                context = context.replace("{stockCode}",stockOrderInfo.getStockCode()).replace("{stockName}",stockOrderInfo.getStockName())
                        .replace("{stockDirection}",CodeUtils.getCodeName("STOCK_DIRECTION",String.valueOf(stockOrderInfo.getStockDirection())))
                        .replace("{expiryDate}", stockOrderInfo.getExpiryDate()).replace("{accountNo}",securitiesUserInfo.getTradeAccount())
                        .replace("{accountName}",securitiesUserInfo.getClientName());
                if("".equals(stockOrderInfo.getStockQuantity())||null ==stockOrderInfo.getStockQuantity()){
                    context = context.replace("{stockQuantity}","未知");
                }else{
                    context = context.replace("{stockQuantity}",stockOrderInfo.getStockQuantity());
                }
                if("".equals(stockOrderInfo.getMinPrice())||null ==stockOrderInfo.getMinPrice()){
                    context = context.replace("{minPrice}","不限");
                }else{
                    context = context.replace("{minPrice}",stockOrderInfo.getMinPrice().toString());
                }
                if("".equals(stockOrderInfo.getMaxPrice())||null ==stockOrderInfo.getMaxPrice()){
                    context = context.replace("{maxPrice}","不限");
                }else{
                    context = context.replace("{maxPrice}",stockOrderInfo.getMaxPrice().toString());
                }
                params.setContext(context);
                StockUtils.sendStockNotice(params, "1");
                //发送邮件
                StockUtils.sendStockEmail(stockOrderInfo,"1",VelocityUtil.STOCK_ORDER_EMAIL_TEMPLATE);
                return Result.ok("发送成功");
            }else{
                return Result.error("股票下单发送失败");
            }
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("股票下单发送失败",e);
            return Result.error("股票下单发送失败");
        }
    }

    /**
     * 持仓情况
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/stockPositionInfo")
    public String stockPositionInfo(Model model,HttpServletRequest request){

        String fundAccount = SysConfigUtil.getSysConfigValue("DONATED_STK_FUND_ACCOUNT",null);
        model.addAttribute("fundAccount",fundAccount);
        GenericHsRequest<FundRequest> clientFareInfoProtoRequest = new GenericHsRequest<>();
        FundRequest fundProtocol = new FundRequest();
        fundProtocol.setFundAccount(fundAccount);
        clientFareInfoProtoRequest.setParams(fundProtocol);

        ResponseVO fundTotalResponseVo = HsFundManageService.getFundTotal(clientFareInfoProtoRequest);
        ResponseVO stockInfoResponseVo = HsStockManageService.getStockInfo(clientFareInfoProtoRequest);

        if(fundTotalResponseVo.getCode() == CrmCommonEnum.CodeType.OK.getCode()){
            HsFundEntity stockAsset = (HsFundEntity) new JSONObject(fundTotalResponseVo.getResult()).toBean( HsFundEntity.class);
            model.addAttribute("stockAsset",stockAsset);
        }else{
            model.addAttribute("fundTotalMsg",fundTotalResponseVo.getMessage());
        }
        if(stockInfoResponseVo.getCode() == CrmCommonEnum.CodeType.OK.getCode()){
            List<StockPositionEntity> stockPositionList = JsonUtil.getList(JsonUtil.getJsonByObj(stockInfoResponseVo.getResult()),StockPositionEntity.class);
            for(StockPositionEntity stockPosition : stockPositionList){
                BigDecimal totalCost = stockPosition.getCostPrice().multiply(stockPosition.getCurrentAmount());
                DecimalFormat format   =new  DecimalFormat("#.00");
                stockPosition.setTotalCost(format.format(totalCost));
        }
            model.addAttribute("stockPositionList",stockPositionList);
        }else{
            model.addAttribute("stockPositionMsg",stockInfoResponseVo.getMessage());
        }

        return "stock/stockPosition";
    }
}
