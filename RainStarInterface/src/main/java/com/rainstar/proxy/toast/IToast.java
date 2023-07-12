package com.rainstar.proxy.toast;

/**
 * Created by rainstar on 2023/7/12.
 */
public interface IToast {
    void showToast(String message);

    void showToast(String message, int duration);
}
