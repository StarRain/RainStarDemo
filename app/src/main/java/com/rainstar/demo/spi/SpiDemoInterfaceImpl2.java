package com.rainstar.demo.spi;

import android.util.Log;

/**
 * Created by rainstar on 2023/7/11.
 */
public class SpiDemoInterfaceImpl2 implements SpiDemoInterface {
    private static final String TAG = "SpiDemo";

    @Override
    public void displayImage(String mode) {
        Log.d(TAG, String.format("%s-%s", mode, this.getClass().getSimpleName()));
    }

    @Override
    public String getDesc(String mode) {
        return String.format("%s-%s", mode, this.getClass().getSimpleName());
    }
}
