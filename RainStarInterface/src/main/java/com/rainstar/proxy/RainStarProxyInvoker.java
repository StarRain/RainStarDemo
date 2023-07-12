package com.rainstar.proxy;

import android.app.Application;
import android.content.Context;

/**
 * Created by rainstar on 2023/7/12.
 */
public class RainStarProxyInvoker {
    private static Application sApplication;

    public static void init(Application application) {
        sApplication = application;
    }

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getApplicationContext() {
        return sApplication.getApplicationContext();
    }
}
