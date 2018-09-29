package cn.ssic.tianfangcatering.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @package: cn.ssic.truckdriver.utils
 * @author：JHQ
 * @date： 2018/8/13  11:17
 */
public class TimeUtil {
    public static final String FORMAT_DATE_EN = "yyyy-MM-dd";
    public static final String FORMAT_DATE_EN_PRECISION = "yyyy-MM-dd HH:mm";
    private static final SimpleDateFormat SDF = new SimpleDateFormat(FORMAT_DATE_EN, Locale.CHINA);

    /**
     * string型时间转换
     *
     * @param timestamp 时间
     * @return 刚刚  x分钟  小时前  ...
     */

    public static String convertTime(long timestamp) {
        if (timestamp == 0) {
            return "";
        }
        try {
            Date date = new Date();
            date.setTime(timestamp);
            return format(FORMAT_DATE_EN, date);
        } catch (IllegalArgumentException e) {
            return "";
        }
    }

    public static String convertTime(String timestamp) {
        if (null == timestamp || "".equals(timestamp)) {
            return "";
        }
        try {
            Date date = new Date();
            date.setTime(Long.valueOf(timestamp));
            return format(FORMAT_DATE_EN, date);
        } catch (IllegalArgumentException e) {
            return "";
        }
    }

    public static String convertTimePrecision(String timestamp) {
        if (null == timestamp || "".equals(timestamp)) {
            return "";
        }
        try {
            Date date = new Date();
            date.setTime(Long.valueOf(timestamp));
            return format(FORMAT_DATE_EN_PRECISION, date);
        } catch (IllegalArgumentException e) {
            return "";
        }
    }


    public static long stringToLong(String dateStr) {
        if (null != dateStr) {
            try {
                Date date = SDF.parse(dateStr);
                return date.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private static String format(String timeFormat, Date date) {
        SDF.setTimeZone(TimeZone.getDefault());
        SDF.applyPattern(timeFormat);

        return SDF.format(date);
    }

}
