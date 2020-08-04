package com.sunline.modules.common.utils;

import com.google.common.collect.Maps;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.Map;

/**
 * @description: Velocity模板渲染工具
 * @author: Larry Lai
 * @date: 2018/10/10 15:17
 * @version: v1.0
 */

public class VelocityUtil {
    public final static String ACCOUNT_OPEN_SUCCEED_EMAIL_TEMPLATE = "template/account/online/account_open_succeed_email.vm";
    public final static String ACCOUNT_OPEN_SUCCEED_HK_EMAIL_TEMPLATE = "template/account/online/account_open_succeed_hk_email.vm";
    public final static String STOCK_ORDER_EMAIL_TEMPLATE = "template/stock/stock_order_email.vm";
    public final static String POSITION_INSUFFICIENT_80 = "template/stock/position_insufficient_80.vm";
    public final static String POSITION_INSUFFICIENT_90 = "template/stock/position_insufficient_90.vm";
    public final static String DONATED_STOCK_SUCCEED_EMAIL_TEMPLATE = "template/stock/donated_stock_succeed_email.vm";
    public final static String DONATED_STOCK_REFUSED_EMAIL_TEMPLATE = "template/stock/donated_stock_refused_email.vm";
    public final static String TOTAL_INC_AMOUNT_ABNORMAL_EMAIL_TEMPLATE = "template/customer/total_inc_amount_abnormal_email.vm";
    public final static String ACCOUNT_CANCEL_SUCCEED_EMAIL_TEMPLATE = "template/account/online/account_cancel_succeed_email.vm";
    public final static String OFFLINE_ACCOUNT_OPEN_SUCCEED_EMAIL_TEMPLATE = "template/account/offline/account_open_succeed_email.vm";
//    //专业投资者模板
//    public final static String PROFESSIONAL_INVERSTO_SUCCEED_EMAIL_TEMPLATE = "template/account/professional/";
//    public final static String PROFESSIONAL_INVERSTO_CANCEL_EMAIL_TEMPLATE = "template/account/professional/";

    public static String fillTemplate(Map<String,String> model) {
        return fillTemplate(ACCOUNT_OPEN_SUCCEED_EMAIL_TEMPLATE, model);
    }

    public static String fillTemplate(String templatePath,Map<String,String> model) {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        Template t = ve.getTemplate(templatePath, "utf-8");
        VelocityContext ctx = new VelocityContext();

        for (String key : model.keySet()) {
            ctx.put(key, model.get(key));
        }

        StringWriter sw = new StringWriter();
        t.merge(ctx, sw);
        return sw.toString();
    }

    public static void main(String[] args) {
        Map<String, String> model = Maps.newHashMap();
        model.put("stockName", "腾讯控股");
        model.put("stockQuantity", "1000");
        model.put("budgetMoney", "1000000.00");
        //code random
//        model.put("tradeAccountPassword", "123456");
        System.out.println(fillTemplate(STOCK_ORDER_EMAIL_TEMPLATE, model));
    }

}
