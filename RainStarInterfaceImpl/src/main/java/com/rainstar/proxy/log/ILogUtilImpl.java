package com.rainstar.proxy.log;

import android.util.Log;

/**
 * Created by rainstar on 2023/7/11.
 */
public class ILogUtilImpl implements ILog {
    private static ILogUtilImpl sInstance;

    public ILogUtilImpl getInstance() {
        if (sInstance == null) {
            synchronized (ILogUtilImpl.class) {
                if (sInstance == null) {
                    sInstance = new ILogUtilImpl();
                }
            }
        }
        return sInstance;
    }

    @Override
    public void logi(String tag, String message) {
        Log.i(tag, message);
    }

    @Override
    public void logd(String tag, String message) {
        Log.d(tag, message);
    }

    @Override
    public void lodw(String tag, String message) {
        Log.w(tag, message);
    }

    @Override
    public void loge(String tag, String message) {
        Log.e(tag, message);
    }

    @Override
    public void loge(String tag, Throwable throwable, String message) {
        Log.e(tag, message, throwable);
    }
}