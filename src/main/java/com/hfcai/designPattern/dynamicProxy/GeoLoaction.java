package com.hfcai.designPattern.dynamicProxy;

/**
 * @date 17-2-13.
 * @className GeoLoaction
 * @serial 1.0.0
 * @author hfcai
 * 该类可通过扩展创建实现不同的方法实现
 */

public class GeoLoaction implements ILocation {


    @Override
    public void shareLocation(String location) {
        System.out.print("GeoLocation info:"+location+"\n");
    }


}
