package com.hxgfk.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {
    //根据key读取value
    public static String readValue(String filePath,String key) {
        Properties props = new Properties();
        try {
            InputStream in = new BufferedInputStream (Files.newInputStream(Paths.get(filePath)));
            props.load(in);
            return props.getProperty (key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 写入properties信息
    public static void writeProperties(String filePath,String parameterName,String parameterValue) {
        Properties prop = new Properties();
        try {
            Path path = Paths.get(filePath);
            InputStream fis = Files.newInputStream(path);
            // 从输入流中读取属性列表（键和元素对）
            prop.load(fis);
            OutputStream fos = Files.newOutputStream(path);
            prop.setProperty(parameterName, parameterValue);
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            prop.store(fos, "Update '" + parameterName + "' value");
        } catch (IOException e) {
            System.err.println("Visit "+filePath+" for updating "+parameterName+" value error");
        }
    }
}
