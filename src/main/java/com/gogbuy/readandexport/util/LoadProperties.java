package com.gogbuy.readandexport.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @author edith
 * @Description 使用单例模式获取配置  实现一次读取多次使用
 * @date 2020/1/3 16:57
 */
public class LoadProperties {
    private static LoadProperties loadProperties = null;
    /**
     * 配置信息
     */
    private HashMap<String, String> map = null;

    private LoadProperties() {
        map = new HashMap<String, String>();
        InputStream is = LoadProperties.class.getClassLoader().getResourceAsStream("dbconfig.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            Iterator<Map.Entry<Object, Object>> it = properties.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Object, Object> entry = it.next();
                String key = (String) entry.getKey();
                String val = (String) entry.getValue();
                map.put(key, val);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static LoadProperties getInstance() {
        if (loadProperties == null) {
            loadProperties = new LoadProperties();
        }
        return loadProperties;
    }

    public HashMap<String, String> getMap() {
        return map;
    }
}
