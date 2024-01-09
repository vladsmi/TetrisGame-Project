package com.jfxbase.oopjfxbase.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {
    private static final Properties properties = new Properties();

    static {
        try {
            Environment.properties.load(new FileInputStream(String.format("%s/%s", System.getProperty("user.dir"), ".properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String APP_TITLE = properties.getProperty("APP_TITLE");
    public static final Boolean IS_FULLSCREEN = Boolean.valueOf(properties.getProperty("IS_FULLSCREEN"));
}
