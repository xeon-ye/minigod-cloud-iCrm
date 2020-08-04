package com.sunline.modules.common.utils;

import com.sunline.modules.api.service.impl.SecuritiesUserInfoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 客户数统计
 *
 * @author lcs
 * @email
 * @date 2018-05-9 14:56:39
 */
public class SumDateUtil {

    private static final SimpleDateFormat DATE_FROMAT  = new SimpleDateFormat("yyyy-MM-dd");
    private static final Logger logger = LoggerFactory.getLogger(SecuritiesUserInfoServiceImpl.class);

    /**
     * 获取 指定日期的 00:00:00
     * @param calendar
     * @return
     */
    public static Date todayFirstDate(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    /**
     * 获取 指定日期的 23:59:59
     * @param calendar
     * @return
     */
    public static Date todayLastDate(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获取上个月第一天
     * @return
     */
    public static Calendar getFirstDayOfMonth(){
        //获取前一个月第一天
        Calendar lastMonthFirstDay = Calendar.getInstance();
        lastMonthFirstDay.add(Calendar.MONTH, -1);
        lastMonthFirstDay.set(Calendar.DAY_OF_MONTH,1);
       return lastMonthFirstDay;
    }
    /**
     * 获取上个月最后一天
     * @return
     */
    public static Calendar getLastDayOfMonth(){
        //获取前一个月最后一天
        Calendar lastMonthLastDay = Calendar.getInstance();
        lastMonthLastDay.set(Calendar.DAY_OF_MONTH, 0);
       return lastMonthLastDay;
    }


    /**
     *  获取上周一
     * @return
     */
    public static Calendar getLastMondy(){

        Calendar lastMondy = Calendar.getInstance();
        int dayOfWeek=lastMondy.get(Calendar.DAY_OF_WEEK)-1;
        int offset = 1-dayOfWeek;
        lastMondy.add(Calendar.DATE, offset-7);
        return lastMondy;
    }

    /**
     *  获取上周末
     * @return
     */
    public static Calendar getLastSundy(){
        //获取上周一和上周日的时间
        Calendar lastSunday = Calendar.getInstance();
        int dayOfWeek=lastSunday.get(Calendar.DAY_OF_WEEK)-1;
        int offset = 7-dayOfWeek;
        lastSunday.add(Calendar.DATE, offset-7);
        return lastSunday;
    }

    /**
     * 得到本周周一
     *
     * @return yyyy-MM-dd
     */
    public static String getMondayOfThisWeek(String date) {
        Calendar monday = Calendar.getInstance();
        try {
            monday.setTime(DATE_FROMAT.parse(date));
        }catch (Exception e){
            logger.error("输入日期格式有误！");
        }
        int day_of_week = monday.get(Calendar.DAY_OF_WEEK) - 1;
        if(day_of_week == 0){
            day_of_week = 7;
        }
        monday.add(Calendar.DATE, -day_of_week + 1);
        return DATE_FROMAT.format(monday.getTime());
    }

    /**
     * 得到本周周日
     *
     * @return yyyy-MM-dd
     */
    public static String getSundayOfThisWeek(String date) {
        Calendar sunday = Calendar.getInstance();
        try {
            sunday.setTime(DATE_FROMAT.parse(date));
        }catch (Exception e){
            logger.error("输入日期格式有误！");
        }
        int day_of_week = sunday.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0){
            day_of_week = 7;
        }
        sunday.add(Calendar.DATE, -day_of_week + 7);
        return DATE_FROMAT.format(sunday.getTime());
    }

    /**
     * 获取本年第一天
     * @return
     */
    public static String getFirstDayThisYear(String date){
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_FROMAT.parse(date));
        }catch (Exception e){
            logger.error("输入日期格式有误！");
        }
        calendar.add(Calendar.YEAR, 0);
        //设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.DAY_OF_YEAR,1);
        return DATE_FROMAT.format(calendar.getTime());
    }

    /**
     * 获取本年最后一天
     * @return
     */
    public static String getLastDayThisYear(String date){
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_FROMAT.parse(date));
        }catch (Exception e){
            logger.error("输入日期格式有误！");
        }
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        return DATE_FROMAT.format(calendar.getTime());
    }

    /**
     * 获取本月第一天
     * @return
     */
    public static String getFirstDayThisMonth(String date){
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_FROMAT.parse(date));
        }catch (Exception e){
            logger.error("输入日期格式有误！");
        }
        calendar.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return DATE_FROMAT.format(calendar.getTime());
    }

    /**
     * 获取本月最后一天
     * @return
     */
    public static String getLastDayThisMonth(String date){
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_FROMAT.parse(date));
        }catch (Exception e){
            logger.error("输入日期格式有误！");
        }
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return DATE_FROMAT.format(calendar.getTime());
    }

    /**
     * 下一天
     * @return
     */
    public static String nextDay(String date){

        //获取日历实例
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_FROMAT.parse(date));
        }catch (Exception e){
            logger.error("输入日期格式有误！");
        }
        //设置为后一天
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        //获得后一天
        String nextDay= DATE_FROMAT.format(calendar.getTime());
        return  nextDay;
    }

    /**
     * 下一天
     * @return
     */
    public static String lastDay(String date){
        //获取日历实例
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_FROMAT.parse(date));
        }catch (Exception e){
            logger.error("输入日期格式有误！");
        }
        //设置为前一天
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        //获得前一天
        String lastDay= DATE_FROMAT.format(calendar.getTime());
        return  lastDay;
    }

    /**
     * 去年的今天
     * @return
     */
    public static String lastYear(String date){
        //获取日历实例
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_FROMAT.parse(date));
        }catch (Exception e){
            logger.error("输入日期格式有误！");
        }
        //设置为一年前
        calendar.add(Calendar.YEAR, -1);
        String lastYear= DATE_FROMAT.format(calendar.getTime());
        return  lastYear;
    }

}
