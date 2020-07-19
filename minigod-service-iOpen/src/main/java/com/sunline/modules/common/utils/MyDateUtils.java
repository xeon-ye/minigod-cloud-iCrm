package com.sunline.modules.common.utils;

import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiYangFeng
 * @createDate 2017/7/25
 * @description 
 * @since 
 * @version 
 * @email justbelyf@gmail.com
 */
public class MyDateUtils {
    public static final String LONG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String UNSIGNED_DATE_FORMAT = "yyyyMMddHHmmss";
    public static final SimpleDateFormat longDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat shortDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat unsignedDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    public static final String[] longDateFormatArray = new String[]{"yyyy-MM-dd HH:mm:ss"};
    public static final String[] shortDateFormatArray = new String[]{"yyyy-MM-dd"};
    public static final String[] unsignedDateFormatArray = new String[]{"yyyyMMddHHmmss"};
    public static final String[] dateFormatArray = new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyyMMddHHmmss"};

    public MyDateUtils() {
    }

    public static long getCurrentMilliseconds() {
        return System.currentTimeMillis();
    }

    public static Date convertMillisecondToDate(Long millisecond) {
        return new Date(millisecond);
    }

    public static String convertMillisecondToLongDateString(Long millisecond) {
        if (null == millisecond || 0==millisecond) {
            return "";
        }
        return longDateFormat.format(convertMillisecondToDate(millisecond));
    }

    public static String convertMillisecondToShortDateString(Long millisecond) {
        if (null == millisecond || 0==millisecond) {
            return "";
        }
        return shortDateFormat.format(convertMillisecondToDate(millisecond));
    }

    public static String convertMillisecondToUnsignedDateString(Long millisecond) {
        return unsignedDateFormat.format(convertMillisecondToDate(millisecond));
    }

    public static long convertDateStringToMillisecond(String dateString) {
        long ret = 0L;
        if(!StringUtils.isBlank(dateString)) {
            try {
                Date date = org.apache.commons.lang.time.DateUtils.parseDate(dateString, dateFormatArray);
                ret = date.getTime();
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }
        }

        return ret;
    }

    public static long convertLongDateStringToMillisecond(String dateString) {
        long ret = 0L;
        if(!StringUtils.isBlank(dateString)) {
            try {
                Date date = org.apache.commons.lang.time.DateUtils.parseDate(dateString, longDateFormatArray);
                ret = date.getTime();
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }
        }

        return ret;
    }

    public static long convertShortDateStringToMillisecond(String dateString) {
        long ret = 0L;
        if(!StringUtils.isBlank(dateString)) {
            try {
                Date date = org.apache.commons.lang.time.DateUtils.parseDate(dateString, shortDateFormatArray);
                ret = date.getTime();
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }
        }

        return ret;
    }

    public static long convertUnsignedDateStringToMillisecond(String dateString) {
        long ret = 0L;
        if(!StringUtils.isBlank(dateString)) {
            try {
                Date date = org.apache.commons.lang.time.DateUtils.parseDate(dateString, unsignedDateFormatArray);
                ret = date.getTime();
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }
        }

        return ret;
    }

    public static String getCurrentShortDateString() {
        return convertMillisecondToShortDateString(getCurrentMilliseconds());
    }

    public static String getCurrentLongDateString() {
        return convertMillisecondToLongDateString(getCurrentMilliseconds());
    }

    public static String getCurrentUnsignedDateString() {
        return convertMillisecondToUnsignedDateString(getCurrentMilliseconds());
    }

    public static long getMillisecondsForOneDay() {
        return 86400000L;
    }

    public static long getMillisecondForShortDayStart(String dateString) {
        return convertShortDateStringToMillisecond(dateString);
    }

    public static long getMillisecondForShortDayEnd(String dateString) {
        long ret = getMillisecondForShortDayStart(dateString);
        ret += getMillisecondsForOneDay() - 1L;
        return ret;
    }



    public static boolean isAtTimeRange(Long startTime, Long endTime) {
        if(null == startTime) {
            startTime = Long.valueOf(-9223372036854775808L);
        }

        if(null == endTime) {
            endTime = Long.valueOf(9223372036854775807L);
        }

        Long nowTime = Long.valueOf(getCurrentMilliseconds());
        return nowTime.longValue() >= startTime.longValue() && nowTime.longValue() < endTime.longValue();
    }



    public static boolean validateLongDateFormat(String dateString) {
        return validateDateFormat(dateString, longDateFormat);
    }

    public static boolean validateShortDateFormat(String dateString) {
        return validateDateFormat(dateString, shortDateFormat);
    }

    public static boolean validateUnsignedDateFormat(String dateString) {
        return validateDateFormat(dateString, unsignedDateFormat);
    }

    public static boolean validateDateFormat(String dateString, String dateFormatString) {
        return validateDateFormat(dateString, new SimpleDateFormat(dateFormatString));
    }

    public static boolean validateDateFormat(String dateString, SimpleDateFormat dateFormat) {
        if(dateString == null) {
            return false;
        } else {
            try {
                dateFormat.setLenient(false);
                dateFormat.parse(dateString);
                return true;
            } catch (Exception var3) {
                return false;
            }
        }
    }

    public static long getMillisecondsForMonthBegin(int offset) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.add(2, offset);
        calendar.set(5, 1);
        return convertShortDateStringToMillisecond(convertMillisecondToShortDateString(calendar.getTimeInMillis()));
    }

    //获取当天的开始时间
    public static Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    //获取当天的结束时间
    public static Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }
    //获取昨天的开始时间
    public static Date getBeginDayOfYesterday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }
    //获取昨天的结束时间
    public static Date getEndDayOfYesterDay() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }
    //获取明天的开始时间
    public static Date getBeginDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, 1);

        return cal.getTime();
    }
    //获取明天的结束时间
    public static Date getEndDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }
    //获取本周的开始时间
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }
    //获取本周的结束时间
    public static Date getEndDayOfWeek(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }
    //获取本月的开始时间
    public static Date getBeginDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        return getDayStartTime(calendar.getTime());
    }
    //获取本月的结束时间
    public static Date getEndDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth() - 1, day);
        return getDayEndTime(calendar.getTime());
    }
    //获取本年的开始时间
    public static Date getBeginDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        // cal.set
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE, 1);

        return getDayStartTime(cal.getTime());
    }
    //获取本年的结束时间
    public static Date getEndDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 31);
        return getDayEndTime(cal.getTime());
    }
    //获取某个日期的开始时间
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if(null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),    calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }
    //获取某个日期的结束时间
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if(null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),    calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }
    //获取今年是哪一年
    public static Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }
    //获取本月是哪一月
    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }
    //两个日期相减得到的天数
    public static int getDiffDays(Date beginDate, Date endDate) {

        if (beginDate == null || endDate == null) {
            throw new IllegalArgumentException("getDiffDays param is null!");
        }

        long diff = (endDate.getTime() - beginDate.getTime())
                / (1000 * 60 * 60 * 24);

        int days = new Long(diff).intValue();

        return days;
    }
    //两个日期相减得到的毫秒数
    public static long dateDiff(Date beginDate, Date endDate) {
        long date1ms = beginDate.getTime();
        long date2ms = endDate.getTime();
        return date2ms - date1ms;
    }
    //获取两个日期中的最大日期
    public static Date max(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {
            return beginDate;
        }
        return endDate;
    }
    //获取两个日期中的最小日期
    public static Date min(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {
            return endDate;
        }
        return beginDate;
    }
    //返回某月该季度的第一个月
    public static Date getFirstSeasonDate(Date date) {
        final int[] SEASON = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4 };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int sean = SEASON[cal.get(Calendar.MONTH)];
        cal.set(Calendar.MONTH, sean * 3 - 3);
        return cal.getTime();
    }
    //返回某个日期下几天的日期
    public static Date getNextDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + i);
        return cal.getTime();
    }
    //返回某个日期前几天的日期
    public static Date getFrontDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - i);
        return cal.getTime();
    }
    //获取某年某月到某年某月按天的切片日期集合（间隔天数的日期集合）
    public static List getTimeList(int beginYear, int beginMonth, int endYear,
                                   int endMonth, int k) {
        List list = new ArrayList();
        if (beginYear == endYear) {
            for (int j = beginMonth; j <= endMonth; j++) {
                list.add(getTimeList(beginYear, j, k));

            }
        } else {
            {
                for (int j = beginMonth; j < 12; j++) {
                    list.add(getTimeList(beginYear, j, k));
                }

                for (int i = beginYear + 1; i < endYear; i++) {
                    for (int j = 0; j < 12; j++) {
                        list.add(getTimeList(i, j, k));
                    }
                }
                for (int j = 0; j <= endMonth; j++) {
                    list.add(getTimeList(endYear, j, k));
                }
            }
        }
        return list;
    }
    //获取某年某月按天切片日期集合（某个月间隔多少天的日期集合）
    public static List getTimeList(int beginYear, int beginMonth, int k) {
        List list = new ArrayList();
        Calendar begincal = new GregorianCalendar(beginYear, beginMonth, 1);
        int max = begincal.getActualMaximum(Calendar.DATE);
        for (int i = 1; i < max; i = i + k) {
            list.add(begincal.getTime());
            begincal.add(Calendar.DATE, k);
        }
        begincal = new GregorianCalendar(beginYear, beginMonth, max);
        list.add(begincal.getTime());
        return list;
    }

    public static long convertDateStringToMillisecondMM(String dateString) {
        long ret = 0L;
        if(!StringUtils.isBlank(dateString)) {
            try {
                dateString = dateString + " 24:00:00";
                Date date = org.apache.commons.lang.time.DateUtils.parseDate(dateString, dateFormatArray);
                ret = date.getTime();
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }
        }

        return ret;
    }

    public static void main(String[] args) throws Exception {
        /*System.out.println(getBeginDayOfWeek().getTime());
        System.out.println(getEndDayOfWeek().getTime());

        String datastring = "2017-07-31";
        System.out.println(convertDateStringToMillisecond(datastring));
        System.out.println(convertMillisecondToLongDateString(convertDateStringToMillisecond(datastring)));*/

//        System.out.println(DateUtils.getCurrentMilliseconds());
//        String targetDate = "{\"locationProvince\":\"广东\",\"locationCity\":\"深圳\",\"locationCounty\":\"福田\"}";
//        JSONObject jsonObject = JSONObject.parseObject(targetDate);
//        String province = jsonObject.get("locationProvince").toString();
//        System.out.println(province);

//        System.out.println(DateUtils.getCurrentMilliseconds());
//
//        String userIds = "10051,111";
//
//        System.out.println(userIds.split(",")[1]);

//        System.out.println(DateUtils.getCurrentShortDateString());
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//        System.out.println( DateUtils.convertDateStringToMillisecondMM("2017-08-10"));
//
//        Date date = new Date();
//        Long time = 1502380800000l;
//        System.out.println(time);
//
//        Date d = new Date(time);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(d));

    }

}
