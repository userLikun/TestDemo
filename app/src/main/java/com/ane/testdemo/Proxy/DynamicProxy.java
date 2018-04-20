package com.ane.testdemo.Proxy;

import com.ane.testdemo.base.utils.TLog;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object proxyObject;

    public DynamicProxy(Object proxyObject){
        this.proxyObject = proxyObject;
    }


    public Object newProxyInstance(Object proxyObject) {
        this.proxyObject = proxyObject;
//        return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(),
//                proxyObject.getClass().getInterfaces(),this);
        return null;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TLog.d("DynamicProxy","invoke");
        Object result = null;
        // 通过Java反射机制调用目标对象方法
        result = method.invoke(proxyObject, args);
        return result;
    }
}
