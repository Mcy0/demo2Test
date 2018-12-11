package com.mcy.test1;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    /**
     * Jdk代理
     * @return 代理对象
     */
    public Object geJdkProxy() {
        final HelloWorldImpl helloWorld = new HelloWorldImpl();
        return Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(), helloWorld.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("进入代理方法");
                System.out.println("在调度真实对象之前的服务");
                Object object = method.invoke(helloWorld, args);
                System.out.println("在调度真是对象之后的服务");
                return object;
            }
        });
    }

    @Test
    public void testGetJdkProxy()
    {
        HelloWorld helloWorld = (HelloWorld) geJdkProxy();
        helloWorld.sayHelloWorld();
    }
    public Object getCglib()
    {
        ReflectServiceImpl reflectService = new ReflectServiceImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(reflectService.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("调用真是对象之前");
                Object object = methodProxy.invokeSuper(o,objects);
                System.out.println("调用真实对象之后");
                return object;
            }
        });
        return enhancer.create();
    }
    @Test
    public void testGetCglib()
    {
        ReflectServiceImpl reflectService  = (ReflectServiceImpl) getCglib();
        reflectService.sayHello("MCY");
    }
}
