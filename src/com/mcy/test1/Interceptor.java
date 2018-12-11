package com.mcy.test1;

import java.lang.reflect.Method;

public interface Interceptor {
    /**
     * 调用真是对象之前调用，true反射真是对象，false调用around方法
     * @param proxy 代理对象
     * @param target 真是对象
     * @param method method方法
     * @param args 运行方法参数
     * @return boolean
     */
    public boolean before(Object proxy, Object target, Method method, Object[] args);
    public void around(Object proxy, Object target, Method method, Object[] args);
    public void after(Object proxy, Object target, Method method, Object[] args);
}
