package com.hfcai.designPattern.factory;

/**
 * @date 17-2-14.
 * @className Hourse
 * @serial 1.0.0
 */

public class House implements Product {

    @Override
    public void sale() {
        //horse sale method
        System.out.println("house sale method.");
    }

    @Override
    public void securityDetection() {
        System.out.println("house securityDetection method.");
    }
}
