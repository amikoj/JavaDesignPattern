package com.hfcai.designPattern.factory.abstractFactory;

import com.hfcai.designPattern.factory.Insurance;
import com.hfcai.designPattern.factory.Product;

/**
 * @date 17-2-14.
 * @className DefaultWomanFactory
 * @serial 1.0.0
 */

public class DefaultWomanFactory  extends AbstractFactory{
    @Override
    public Product createProduct() {
        System.out.println("DefaultWomanFactory createProduct method.");
        return new Insurance();
    }

    @Override
    public Human createHuman() {
        System.out.println("DefaultWomanFactory createHuman method.");
        return new Woman();
    }
}
