package com.jimmy.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class UrlPositionUtil {
    private static Map<String, String> urlMap = new HashMap<String, String>();

    static {
        urlMap.put("dictionary", "dictionary");

        urlMap.put("view", "view");
        urlMap.put("toView", "view");
        urlMap.put("toUpdate", "update");
        urlMap.put("update", "update");
        urlMap.put("add", "add");
        urlMap.put("toAdd", "add");

    }

    public static String getUrlPosition(HttpServletRequest request) {
        // context url
        String path = request.getContextPath();
        // request url
        String url = request.getRequestURI();
        // the url to decide url position
        String myUrl = url.substring(path.length() + 1, url.length());

        String[] urlItems = myUrl.split("/");

        return urlMap.get(urlItems[0]) + " > " + urlMap.get(urlItems[1]);
    }
}
