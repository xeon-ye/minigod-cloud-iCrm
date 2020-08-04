package com.sunline.modules.common.utils;

import cn.hutool.core.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 高并发情况下生成订单流水号
 * @author: Larry Lai
 * @date: 2018/10/13 16:09
 * @version: v1.0
 */

public final class OrderUtil {

    private static final Logger logger = LoggerFactory.getLogger(OrderUtil.class);

    /**
     * 开户业务流水号后缀
     */
    private static final AtomicInteger OPEN_ACCOUNT_ATOMICINTEGER = new AtomicInteger(10000000);

    /**
     * 渠道佣金套餐业务流水号后缀
     */
    private static final AtomicInteger CHANNEL_FARE_ATOMICINTEGER = new AtomicInteger(20000000);

    /**
     * 赠股业务流水号后缀
     */
    private static final AtomicInteger DONATED_STOCK_ATOMICINTEGER = new AtomicInteger(30000000);

    /**
     * 出金业务流水号后缀
     */
    private static final AtomicInteger FUND_WITHDRAW_ATOMICINTEGER = new AtomicInteger(40000000);

    /**
     * 行情套餐购买流水号后缀
     */
    private static final AtomicInteger MARKET_PACKAGE_ATOMICINTEGER = new AtomicInteger(50000000);

    /**
     * 出金退款流水号后缀
     */
    private static final AtomicInteger FUND_WITHDRAW_REFUND_ATOMICINTEGER = new AtomicInteger(60000000);
    /**
     * 入金业务流水号后缀
     */
    private static final AtomicInteger FUND_DEPOSIT_ATOMICINTEGER = new AtomicInteger(70000000);
    /**
     * 专业投资者认定业务流水号后缀
     */
    private static final AtomicInteger PROFESSIONAL_INVESTOR_ATOMICINTEGER = new AtomicInteger(80000000);

    /**
     * 创建不连续的订单号
     *
     * @param centreNo 数据中心编号
     * @return 唯一的、不连续订单号
     */
    public static synchronized String getOrderNoByUUID(String centreNo) {
        Integer uuidHashCode = UUID.randomUUID().toString().hashCode();
        if (uuidHashCode < 0) {
            uuidHashCode = uuidHashCode * (-1);
        }
        String date = DateUtil.format(new Date(), "yyyyMMdd");
        return date + centreNo + uuidHashCode;
    }

    /**
     * 创建不连续的订单号
     *
     * @return 唯一的、不连续订单号
     */
    public static synchronized String getOrderNoByUUID() {
        Integer uuidHashCode = UUID.randomUUID().toString().hashCode();
        if (uuidHashCode < 0) {
            uuidHashCode = uuidHashCode * (-1);
        }
        String date = DateUtil.format(new Date(), "yyyyMMdd");
        return date + uuidHashCode;
    }

    /**
     * 获取同一秒钟，生成的订单号连续
     *
     * @param centreNo 数据中心编号
     * @return 同一秒内订单连续的编号
     */
    public static synchronized String getOrderNoByAtomic(String centreNo) {
        OPEN_ACCOUNT_ATOMICINTEGER.getAndIncrement();
        int i = OPEN_ACCOUNT_ATOMICINTEGER.get();
        String date = DateUtil.format(new Date(), "yyyyMMdd");
        return date + centreNo + i;
    }

    /**
     * 获取同一秒钟，生成的订单号连续
     *
     * @return 同一秒内订单连续的编号
     */
    public static synchronized String getOrderNoByAtomic() {
        OPEN_ACCOUNT_ATOMICINTEGER.getAndIncrement();
        int i = OPEN_ACCOUNT_ATOMICINTEGER.get();
        String date = DateUtil.format(new Date(), "yyyyMMdd");
        return date + i;
    }

    /**
     * 获取同一秒钟，生成的订单号连续
     *
     * @param type 业务类型
     * @return 同一秒内订单连续的编号
     */
    public static synchronized String getOrderNoByAtomic(Integer type) {

        int i = 0;

        switch (type) {
            case 1:
                OPEN_ACCOUNT_ATOMICINTEGER.getAndIncrement();
                i = OPEN_ACCOUNT_ATOMICINTEGER.get();
                break;
            case 2:
                CHANNEL_FARE_ATOMICINTEGER.getAndIncrement();
                i = CHANNEL_FARE_ATOMICINTEGER.get();
                break;
            case 3:
                DONATED_STOCK_ATOMICINTEGER.getAndIncrement();
                i = DONATED_STOCK_ATOMICINTEGER.get();
                break;
            case 4:
                FUND_WITHDRAW_ATOMICINTEGER.getAndIncrement();
                i = FUND_WITHDRAW_ATOMICINTEGER.get();
                break;
            case 5:
                MARKET_PACKAGE_ATOMICINTEGER.getAndIncrement();
                i = MARKET_PACKAGE_ATOMICINTEGER.get();
                break;
            case 6:
                FUND_WITHDRAW_REFUND_ATOMICINTEGER.getAndIncrement();
                i = FUND_WITHDRAW_REFUND_ATOMICINTEGER.get();
                break;
            case 7:
                FUND_DEPOSIT_ATOMICINTEGER.getAndIncrement();
                i=FUND_DEPOSIT_ATOMICINTEGER.get();
                break;
            case 8:
                PROFESSIONAL_INVESTOR_ATOMICINTEGER.getAndIncrement();
                i=PROFESSIONAL_INVESTOR_ATOMICINTEGER.get();
                break;
            default:
                break;
        }

        String date = DateUtil.format(new Date(), "yyyyMMdd");
        return date + i;
    }

    public static void main(String[] args) {
        System.out.println(getOrderNoByAtomic(5));
        System.out.println(getOrderNoByAtomic(6));
    }
}
