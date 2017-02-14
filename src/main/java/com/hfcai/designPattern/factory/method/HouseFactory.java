package com.hfcai.designPattern.factory.method;

import com.hfcai.designPattern.factory.House;
import com.hfcai.designPattern.factory.Product;
import com.hfcai.designPattern.factory.simple.ProductFactory;

/**
 * @date 17-2-14.
 * @className HouseFactory
 * @serial 1.0.0
 */

public class HouseFactory extends MethodFactory {

    @Override
    public Product createProduct(){
        System.out.println("HouseFactory creator.");
        return new House();
    }
}
