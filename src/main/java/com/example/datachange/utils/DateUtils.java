package com.example.datachange.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author zhouhao
 * @since  2021/9/30 10:44
 */
public class DateUtils {

    public static String format(Date date, String format, String timezone) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if(StringUtils.isNotEmpty(timezone)){
            sdf.setTimeZone(TimeZone.getTimeZone(timezone));
        }
        return sdf.format(date);
    }

    public static String format(Date date, String format) {
        return format(date, format, null);
    }

    public static Date valueOf(String s, String format) {
        return parse(s, format);
    }

    public static Date parse(String s, String format) {
        if (s == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static Date parse(String s) {
        if (s == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(s);
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
