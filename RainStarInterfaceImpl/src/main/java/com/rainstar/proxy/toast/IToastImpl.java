package com.rainstar.proxy.toast;

import android.widget.Toast;

import com.rainstar.proxy.RainStarProxyInvoker;

/**
 * Created by rainstar on 2023/7/12.
 */
public class IToastImpl implements IToast {
    @Override
    public void showToast(String message) {
        Toast.makeText(RainStarProxyInvoker.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(String message, int duration) {
        Toast.makeText(RainStarProxyInvoker.getApplicationContext(), message, duration).show();
    }
}
