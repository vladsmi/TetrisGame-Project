package com.jfxbase.oopjfxbase.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Logger {
    private final static DateFormat errorDateFormat = new SimpleDateFormat("HH:mm:ss");

    public static void info(String infoMessage){
        System.out.printf("-- INFO -- [%s][%s]: %s%n\n",  errorDateFormat.format(new Date()), Thread.currentThread().getStackTrace()[2].getMethodName(), infoMessage);
    }

    public static void error(String errorMessage){
        System.err.printf("-- ERROR -- [%s][%s]: %s%n\n", errorDateFormat.format(new Date()), Thread.currentThread().getStackTrace()[2].getMethodName(), errorMessage);
    }
}
