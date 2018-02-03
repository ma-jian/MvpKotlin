package com.example.majian.mvpkotlin.utils;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Created by M
 */
public class LogUtil {
    private static final String TAG = "Debug";
    private static boolean isDebug = true;
   static {
       FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder().tag(TAG).build();
       Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
           @Override
           public boolean isLoggable(int priority, String tag) {
               return isDebug;
           }
       });
   }


    public static void e(String tag, Object o) {
            Logger.e(tag, o);
    }

    public static void e(Object o) {
        LogUtil.e(TAG, o);
    }

    public static void w(String tag, Object o) {
            Logger.w(tag, o);
    }

    public static void w(Object o) {
        LogUtil.w(TAG, o);
    }

    public static void d(String msg) {
            Logger.d(msg);
    }

    public static void i(String msg) {
        Logger.i(msg);
    }

    public static void json(String teg, String msg) {
            Logger.d(teg);
            Logger.json(msg);
    }

    public static void url(String tag, String message) {
            Logger.d(tag);
            Logger.i(message);
    }
}
