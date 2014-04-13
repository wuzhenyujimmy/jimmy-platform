package com.jimmy.util;

public class HqlUtil {
    public static String buildHql(String... hqls) {
        String queryString = "";
        
        for (String hql : hqls) {
            queryString += hql;
        }
        
        String whereSql = "";
        if (queryString.length() > 0) {
            whereSql = queryString;
            whereSql = whereSql.substring(0, whereSql.length() - " and ".length());
        } else {
            whereSql = "";
        }

        return whereSql;
    }
}
