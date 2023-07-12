package com.rainstar.proxy;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by rainstar on 2023/7/11.
 */
public class RainStarProxyService {
    /**
     * 缓存实现类
     */
    private static Map<String, Object> sImplements;

    /**
     * 是否是debug模式
     *
     * @return
     */
    private static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    /**
     * 获取缓存的实现类
     *
     * @return
     */
    private static Map<String, Object> getImplements() {
        if (sImplements == null) {
            synchronized (RainStarProxyService.class) {
                if (sImplements == null) {
                    sImplements = new ConcurrentHashMap<>();
                }
            }
        }
        return sImplements;
    }

    /**
     * 通过Object.class注册实现类
     *
     * @param clazz    接口类
     * @param instance 实现类的实例
     * @param <T>
     */
    public static <T> void registerService(Class<T> clazz, T instance) {
        if (null == clazz || null == instance) {
            return;
        }
        registerService(clazz.getName(), instance);
    }

    /**
     * 通过Object.class.getName()注册实现类
     *
     * @param clazzName 接口类全路径
     * @param instance  实现类的实例
     * @param <T>
     */
    public static <T> void registerService(String clazzName, T instance) {
        if (TextUtils.isEmpty(clazzName) || null == instance) {
            return;
        }
        getImplements().put(clazzName, instance);
    }

    /**
     * 获取实现类
     *
     * @param clazz 接口类
     * @param <T>
     * @return 实现类
     */
    public static <T> T getService(@NonNull Class<T> clazz) {
        // 获取接口的全路径
        String interfaceFullName = clazz.getName();

        // 先去查看缓存中是否存在目标实例，存在则返回
        Object object = getImplements().get(interfaceFullName);
        if (null != object) {
            return (T) object;
        }

        // 若缓存中不存在，则通过反射查找目标类
        // 接口全路径拼接Impl就是目标实现类全路径
        String implFullName = String.format("%sImpl", interfaceFullName);
        Class<?> clz = null;
        try {
            clz = Class.forName(implFullName);
        } catch (Exception e) {
            if (isDebug()) {
                e.printStackTrace();
            }
            // 如果没找到实现类，则使用兜底实现类，防止出现空指针异常
            String virtualFullName = String.format("%sVirtual", interfaceFullName);
            try {
                clz = Class.forName(virtualFullName);
                return (T) clz.newInstance();
            } catch (Exception ex) {
                if (isDebug()) {
                    e.printStackTrace();
                }
                // 如果没写用兜底实现类，则返回null
                return null;
            }
        }

        try {
            // 查找实现类中有没有getInstance方法
            Method getInstance = clz.getDeclaredMethod("getInstance");
            // 调用getInstance方法获取实例
            object = getInstance.invoke(null);
            // 加入实现类缓存中
            registerService(interfaceFullName, object);
        } catch (Exception e) {
            if (isDebug()) {
                e.printStackTrace();
            }
            try {
                // 没有找到getInstance方法，则使用空构造创建实例
                object = clz.newInstance();
                // 加入实现类缓存中
                registerService(interfaceFullName, object);
            } catch (Exception ex) {
                if (isDebug()) {
                    ex.printStackTrace();
                }
            }
        }
        return (T) object;
    }
}