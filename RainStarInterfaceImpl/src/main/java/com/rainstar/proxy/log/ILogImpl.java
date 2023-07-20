package com.rainstar.proxy.log;

import android.util.Log;

/**
 * Created by rainstar on 2023/7/11.
 */
public class ILogImpl implements ILog {
    private static volatile ILogImpl sInstance;

    public ILogImpl getInstance() {
        if (sInstance == null) {
            synchronized (ILogImpl.class) {
                if (sInstance == null) {
                    sInstance = new ILogImpl();
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
