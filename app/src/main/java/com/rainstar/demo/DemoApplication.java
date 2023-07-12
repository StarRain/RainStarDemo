package com.rainstar.demo;

import android.app.Application;

import com.rainstar.proxy.RainStarProxyInvoker;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RainStarProxyInvoker.init(this);
    }
}
