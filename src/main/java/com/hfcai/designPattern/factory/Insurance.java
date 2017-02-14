package com.hfcai.designPattern.factory;

/**
 * @date 17-2-14.
 * @className Insurance
 * @serial 1.0.0
 */

public class Insurance implements Product {

    @Override
    public void sale() {
        System.out.println("Insurance sale method.");
    }

    @Override
    public void securityDetection() {
        System.out.println("Insurance securityDetection method.");
    }
}
