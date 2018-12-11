package com.mcy.test1;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("发射方法前逻辑");
        return false;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("取代被代理对象方法");
    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法后逻辑");
    }
}
