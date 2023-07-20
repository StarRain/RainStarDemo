package com.rainstar.proxy.log;

import android.util.Log;

/**
 * Created by rainstar on 2023/7/11.
 */
public class ILogImpl implements ILog {
    /**
     * 为了防止出现 DCL(双重检锁)失效问题，加上 volatile 关键字
     */
    private static volatile ILogImpl sInstance;

    public ILogImpl getInstance() {
        if (sInstance == null) {
            // 同步锁，保证同一时刻只有一个线程进入该代码块。
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
