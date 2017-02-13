package com.hfcai.designPattern;

import com.hfcai.designPattern.dynamicProxy.GeoLoaction;
import com.hfcai.designPattern.dynamicProxy.ILocation;
import com.hfcai.designPattern.dynamicProxy.ILocationProxy;

public class MainClass {


    public static void main(String[] args) {
        //test dynamic proxy pattern
        testDynamicProxyPattern();


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
