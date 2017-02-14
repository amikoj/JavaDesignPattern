package com.hfcai.designPattern;

import com.hfcai.designPattern.dynamicProxy.GeoLoaction;
import com.hfcai.designPattern.dynamicProxy.ILocation;
import com.hfcai.designPattern.dynamicProxy.ILocationProxy;
import com.hfcai.designPattern.singleton.Singleton;
import com.hfcai.designPattern.singleton.SingletonEnum;

/**
 * @author hfcai
 * test class.
 */
public class MainClass {


    public static void main(String[] args) {
        //test dynamic proxy pattern
        testDynamicProxyPattern();

        //单例模式
        Object object=SingletonEnum.INSTANCE.getObject();

    }


    /**
     * proxy pattern
     */
    private static void testDynamicProxyPattern(){
            ILocation iLocation=new GeoLoaction();
            //绑定代理类
            iLocation= (ILocation) ILocationProxy.bind(iLocation);
            iLocation.shareLocation("test");

    }
}
