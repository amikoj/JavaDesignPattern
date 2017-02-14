package com.hfcai.designPattern.factory.abstractFactory;

import com.hfcai.designPattern.factory.House;
import com.hfcai.designPattern.factory.Product;

/**
 * @date 17-2-14.
 * @className DefaultFactory
 * @serial 1.0.0
 */

public class DefaultFactory extends AbstractFactory {
    @Override
    public Product createProduct() {
        System.out.println("DefaultFactory createProduct method.");
        return new House();
    }

    @Override
    public Human createHuman() {
        System.out.println("DefaultFactory createHuman method.");
        return new Man();
    }
}
