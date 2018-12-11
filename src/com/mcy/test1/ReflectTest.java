package com.mcy.test1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public ReflectServiceImpl getInstance()
    {
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.mcy.test1.ReflectServiceImpl").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return object;
    }
    @Test
    public void testGetInstance()
    {
        ReflectServiceImpl reflectService = getInstance();
        reflectService.sayHello("MCY");
    }
    public ReflectServiceImpl2 getInstance2()
    {
        ReflectServiceImpl2 object = null;
        try {
            object = (ReflectServiceImpl2) Class.forName("com.mcy.test1.ReflectServiceImpl2").getConstructor(String.class).newInstance("MCY");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }
    @Test
    public void testGetInstance2()
    {
        ReflectServiceImpl2 reflectService = getInstance2();
        reflectService.sayHello();
    }
    public Object reflectMethod()
    {
        Object object = null;
        ReflectServiceImpl reflectService = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            object = method.invoke(reflectService,"MCY");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }
    @Test
    public void testReflectMethod()
    {
        Object object = reflectMethod();
    }
}
