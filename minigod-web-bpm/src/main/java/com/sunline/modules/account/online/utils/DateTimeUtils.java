package com.sunline.modules.account.online.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Tim on 2018/8/4.
 */

public class DateTimeUtils {
    private static final int MINUTE = 60000;
    private static final int HOUR = 60 * MINUTE;
    private static final int DAY = 24 * HOUR;

    public static final Locale DEFAULT_LOCALE = Locale.CHINA;
    public static final SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm", DEFAULT_LOCALE);

    public static final SimpleDateFormat formatImOnlyTime = new SimpleDateFormat("HH:mm", DEFAULT_LOCALE);
    public static final SimpleDateFormat formatImWithoutYear = new SimpleDateFormat("M-d HH:mm", DEFAULT_LOCALE);
    public static final SimpleDateFormat formatImFull = new SimpleDateFormat("yyyy-M-d HH:mm", DEFAULT_LOCALE);

    public static final SimpleDateFormat formatTimeWithSecond = new SimpleDateFormat("HH:mm:ss", DEFAULT_LOCALE);
    public static final SimpleDateFormat formatWithoutYearWithSecond = new SimpleDateFormat("MM-dd HH:mm:ss", DEFAULT_LOCALE);
    public static final SimpleDateFormat formatFullWithSecond = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", DEFAULT_LOCALE);
    public static final SimpleDateFormat formatFullWithNotSecond = new SimpleDateFormat("yyyy-MM-dd HH:mm", DEFAULT_LOCALE);
    public static final SimpleDateFormat formatSimpleFullDate = new SimpleDateFormat("yyyy-MM-dd", DEFAULT_LOCALE);
    public static final SimpleDateFormat formatSimpleFullDateTrade = new SimpleDateFormat("yyyyMMdd", DEFAULT_LOCALE);

    public static final SimpleDateFormat formatSimpleFullDate2 = new SimpleDateFormat("yyyy/MM/dd", DEFAULT_LOCALE);
    public static final SimpleDateFormat formatSimpleFullDate3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", DEFAULT_LOCALE);
    public static final SimpleDateFormat formatSimpleMoonDay = new SimpleDateFormat("MM-dd", DEFAULT_LOCALE);

    private DateTimeUtils() {

    }

    /**
     * 时间戳 转换成年月日的long型
     *
     * @param timeStamp 时间戳
     * @return
     */
    public static long dateFormatToLong(long timeStamp) {
        long res = 99999999;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            Date date = new Date(timeStamp);
            String timeStr = simpleDateFormat.format(date);
            res = Long.valueOf(timeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 时间字符串 转换成年月日的long型
     *
     * @param dateStr   时间字符串
     * @param formatStr 当前format
     * @return
     */
    public static long dateFormatToLong(String dateStr, String formatStr) {
        long res = 0;
        if (StringUtils.isNotBlank(dateStr)) {
            return res;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
            Date date = simpleDateFormat.parse(dateStr);
            SimpleDateFormat desSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String timeStr = desSimpleDateFormat.format(date);
            res = Long.valueOf(timeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 时间格式转换
     *
     * @param dateStr      时间字符串
     * @param formatStr    当前format
     * @param desFormatStr 目标format
     * @return
     */
    public static String dateToFormat(String dateStr, String formatStr, String desFormatStr) {
        String res = "--";
        if (StringUtils.isNotBlank(dateStr)) {
            return res;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
            Date date = simpleDateFormat.parse(dateStr);
            SimpleDateFormat desSimpleDateFormat = new SimpleDateFormat(desFormatStr);
            res = desSimpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 对日期进行特殊处理 201901转2019/01
     *
     * @param date
     */
    public static String formatterDate(String date) {
        if (StringUtils.isNotBlank(date)) {
            return "";
        }

        try {
            String y = date.substring(0, 4);
            String m = date.substring(4, date.length());
            return y + "/" + m;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String dateToDate(String date, String sFormat, String tFormat) {
        Date newDate;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(sFormat);
            newDate = formatter.parse(date);
            formatter = new SimpleDateFormat(tFormat);
            return formatter.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }

    }

    public static String dateToString(long date, String format, Locale locale) {
        if (date < 1) {
            return "";
        }

        if (StringUtils.isNotBlank(format)) {
            format = "yyyy-MM-dd";
        }

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, locale);
            String dateStr = simpleDateFormat.format(date);
            return dateStr;
        } catch (Exception e) {
            return "";
        }
    }

    public static String dateToString(long date, String format) {
        if (date < 1) {
            return "";
        }

        if (StringUtils.isNotBlank(format)) {
            format = "yyyy-MM-dd";
        }

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, DEFAULT_LOCALE);
            String dateStr = simpleDateFormat.format(date);
            return dateStr;
        } catch (Exception e) {
            return "";
        }
    }

    public static String dateToString(String date, String format) {
        if (StringUtils.isNotBlank(date)) {
            return "";
        }

        if (StringUtils.isNotBlank(format)) {
            format = "yyyy-MM-dd";
        }

        try {
            return dateToString(Long.valueOf(date), format);
        } catch (Exception e) {
            return "";
        }
    }

    public static String dateToString(Date date, String format) {
        if (date == null) {
            return "";
        }

        if (StringUtils.isNotBlank(format)) {
            format = "yyyy-MM-dd";
        }

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, DEFAULT_LOCALE);
            String dateStr = simpleDateFormat.format(date);
            return dateStr;
        } catch (Exception e) {
            return "";
        }
    }

    // long类型转换为String类型
    // currentTime要转换的long类型的时间
    // formatType要转换的string类型的时间格式
    public static String longToString(long currentTime, String formatType)
            throws ParseException {
        Date date = longToDate(currentTime, formatType); // long类型转成Date类型
        String strTime = dateToString(date, formatType); // date类型转成String
        return strTime;
    }

    // string类型转换为date类型
    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public static Date stringToDate(String strTime, String formatType) {
        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(formatType);
            date = formatter.parse(strTime);
        }catch (Exception e){
        }
        return date;
    }

    // long转换为Date类型
    // currentTime要转换的long类型的时间
    // formatType要转换的时间格式yyyy/MM/dd
    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }

    /**
     * 判断当前日期是星期几
     *
     * @param pTime 设置的需要判断的时间  //格式如2012-09-08
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */

    /**
     * timesnamp转换为data 格式为format
     *
     * @param time timesnamp转换为data
     * @return 指定格式的时间字符串
     */
    public static String convertToDate(long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        return sdf.format(time);
    }

    /**
     * 时间格式转换
     * <p>
     * 20190101 转 2019-01-01
     */
    public static String dateFormatTimeStr(String dateStr) {
        String timeStr = "";
        if (StringUtils.isNotBlank(dateStr)) {
            return timeStr;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            Date date = simpleDateFormat.parse(dateStr);
            SimpleDateFormat desSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            timeStr = desSimpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return timeStr;
    }

    /**
     * 传入时分秒数据不要秒
     * 别问为什么这么做，问了就炸了
     *
     * @param time 元数据
     * @return
     */
    public static String getTimeNotSecond(String time) {
        if (StringUtils.isNotBlank(time)) {
            return "";
        }
        String[] times = time.split(":");
        if (time.length() < 2) {
            return time;
        }
        return times[0] + ":" + times[1];
    }

    /**
     * 传入时分秒数据不要秒
     * 别问为什么这么做，问了就炸了
     *
     * @param dateTime 元数据
     * @return
     */
    public static String getDateNotSecond(String dateTime) {
        if (StringUtils.isNotBlank(dateTime)) {
            return "";
        }
        try {
            Date date = formatFullWithSecond.parse(dateTime);
            return formatFullWithNotSecond.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
