package com.mcy.test1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("发射方法前逻辑");
        return true;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("取代被代理对象方法");
    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法后逻辑");
    }
    //代理模式
    @Test
    public void test()
    {
        HelloWorld helloWorld = (HelloWorld)InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "com.mcy.test1.MyInterceptor");
        helloWorld.sayHelloWorld();
    }
    //测试责任链模式
    @Test
    public void test1()
    {
        HelloWorld proxy1 = (HelloWorld)InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "com.mcy.test1.MyInterceptor1");
        HelloWorld proxy2 = (HelloWorld)InterceptorJdkProxy.bind(proxy1,
                "com.mcy.test1.MyInterceptor2");
        proxy2.sayHelloWorld();
    }
}
