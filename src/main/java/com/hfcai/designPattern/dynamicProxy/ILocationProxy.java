package com.hfcai.designPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date 17-2-13.
 * @className ILocationProxy
 * @serial 1.0.0
 * @author hfcai
 * 动态代理类
 */

public class ILocationProxy implements InvocationHandler {


    private static ILocation iLocation;
    private static ILocationProxy iLocationProxy=null;


    private ILocationProxy(ILocation iLocation){
        ILocationProxy.iLocation=iLocation;
        //create proxy
    }

    /**
     * 动态代理绑定
     * @param iLocation
     * @return
     */

    public static Object  bind(ILocation iLocation){
        if (iLocationProxy==null){
            iLocationProxy=new ILocationProxy(iLocation);
        }
         Object object =Proxy.newProxyInstance(iLocation.getClass().getClassLoader(),iLocation.getClass().getInterfaces(),iLocationProxy);
        return object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //before operation
        System.out.print("invoke method before.\n");
        Object object=null;
        if (iLocation!=null)
        object= method.invoke(iLocation,args);
        System.out.print("invoke method after.\n");
        //after operation
        return object;
    }

}
