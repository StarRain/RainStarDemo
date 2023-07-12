package com.rainstar.proxy.log;

/**
 * Created by rainstar on 2023/7/12.
 *
 * 兜底实现
 */
public class ILogVirtual implements ILog {
    @Override
    public void logi(String tag, String message) {

    }

    @Override
    public void logd(String tag, String message) {

    }

    @Override
    public void lodw(String tag, String message) {

    }

    @Override
    public void loge(String tag, String message) {

    }

    @Override
    public void loge(String tag, Throwable throwable, String message) {

    }
}
