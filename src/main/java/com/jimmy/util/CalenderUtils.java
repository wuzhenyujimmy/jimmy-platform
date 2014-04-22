package com.jimmy.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderUtils {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String getNowString() {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
        return sdf.format(getNowDate());
    }
    
    public static Date getNowDate() {
        return Calendar.getInstance().getTime();
    }

}
