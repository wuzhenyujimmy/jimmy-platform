package com.jimmy.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public final class GsonUtil {
    private static Logger logger = LoggerFactory.getLogger(GsonUtil.class);

    public static void writeObjectJson(Object o, HttpServletResponse response) {

        Gson gson = new Gson();
        String jsonString = gson.toJson(o);

        response.setContentType("application/json; charset=utf-8");
        response.setHeader("cache-control", "no-cache");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(jsonString);
            out.close();
        } catch (IOException e) {
            logger.error("");
        }
    }

    public static void writePlainString(String str, HttpServletResponse response) {

        response.setContentType("text/plain; charset=utf-8");
        response.setHeader("cache-control", "no-cache");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(str);
            out.close();
        } catch (IOException e) {
            logger.error("");
        }
    }

    public static String parser(Object o) {
        return new Gson().toJson(o);
    }
}
