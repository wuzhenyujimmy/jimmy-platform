package com.jimmy.base.util;

public class LogUtils {

    public static String logExceptionMessage(Exception e) {
        StringBuilder sb = new StringBuilder();

        sb.append("Exception: ").append(e.getClass().getSimpleName()).append(" - ").append(e.getMessage()).append("\r")
                        .append("    at ").append(e.getStackTrace()[0]);

        return sb.toString();
    }

}
