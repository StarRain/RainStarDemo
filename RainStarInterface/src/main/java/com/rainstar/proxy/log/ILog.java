package com.rainstar.proxy.log;

/**
 * Created by rainstar on 2023/7/11.
 */
public interface ILog {
    void logi(String tag, String message);

    void logd(String tag, String message);

    void lodw(String tag, String message);

    void loge(String tag, String message);

    void loge(String tag, Throwable throwable, String message);
}
