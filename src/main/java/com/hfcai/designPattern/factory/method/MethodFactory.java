package com.hfcai.designPattern.factory.method;

import com.hfcai.designPattern.factory.Product;
import com.hfcai.designPattern.factory.simple.ProductFactory;
import com.hfcai.designPattern.factory.simple.ProductFactory.IllegalProductException;

/**
 * @date 17-2-14.
 * @className MethodFactory
 * @serial 1.0.0
 */

public abstract class MethodFactory {
    public abstract  Product createProduct();
}
