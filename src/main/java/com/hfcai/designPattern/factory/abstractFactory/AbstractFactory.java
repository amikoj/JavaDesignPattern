package com.hfcai.designPattern.factory.abstractFactory;

import com.hfcai.designPattern.factory.Product;

/**
 * @date 17-2-14.
 * @className AbstractFactory
 * @serial 1.0.0
 */

public abstract class AbstractFactory {

    public abstract Product createProduct();
    public abstract Human createHuman();
}
