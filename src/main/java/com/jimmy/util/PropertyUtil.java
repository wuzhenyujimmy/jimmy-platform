package com.jimmy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    // 获得property文件中的属性值
    public static String getProperty(String propertyPath, String key) {
        Properties properties = new Properties();

        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyPath);
        String value = null;
        try {
            properties.load(in);
            value = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

}
