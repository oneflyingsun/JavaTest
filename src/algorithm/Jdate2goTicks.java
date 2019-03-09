package com.jayce;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Jdate2goTicks {

    private static final long TICKS_AT_EPOCH        = 6213559680000000000L;

    private static final long TICKS_PER_MILLISECOND = 10000;

    private static final SimpleDateFormat sdf       = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    private static TimeZone timeZone = TimeZone.getDefault();

    public static void main(String args[]) {
        System.out.println(getgoTicks(new Date()));
        System.out.println(fromDnetTicksToJdate(getgoTicks(new Date())).toString());
    }

    /**
     * 将go的ticks值转换成Java的Date对象
     * @param ticks
     * @return
     */
    public static Date fromDnetTicksToJdate(long ticks){
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis((ticks - TICKS_AT_EPOCH) / TICKS_PER_MILLISECOND);
        calendar.setTimeInMillis(calendar.getTimeInMillis() - calendar.getTimeZone().getRawOffset());
        return calendar.getTime();
    }

    /**
     * 将日期的字符串值转换成go的ticks值
     * @param time
     * @return
     */
    public static long getgoTicks(String time){
        long result = -1;
        Date date = null;
        try {
            date = sdf.parse(time);
            Calendar calendar = Calendar.getInstance(timeZone);
            calendar.setTime(date);
            return (calendar.getTimeInMillis() + calendar.getTimeZone().getRawOffset()) * TICKS_PER_MILLISECOND + TICKS_AT_EPOCH;
        } catch (Exception e) {

        }
        return result;
    }

    /**
     * 将Java日期对象转换成go的ticks值
     * @param jDate
     * @return
     */
    public static long getgoTicks(Date jDate){
        long result = -1;
        try {
            Calendar calendar = Calendar.getInstance(timeZone);
            calendar.setTime(jDate);
            return (calendar.getTimeInMillis() + calendar.getTimeZone().getRawOffset()) * TICKS_PER_MILLISECOND + TICKS_AT_EPOCH;
        } catch (Exception e) {

        }
        return result;

    }

    public static void test(Date jDate) {
        long result;
        Date date=null;
        try{
            Calendar calendar=Calendar.getInstance(timeZone);
            calendar.setTime(jDate);
        }catch (Exception e){

        }

    }
}
