package com.hfcai.designPattern.factory.method;

import com.hfcai.designPattern.factory.Insurance;
import com.hfcai.designPattern.factory.Product;

/**
 * @date 17-2-14.
 * @className InsuranceFactory
 * @serial 1.0.0
 */

public class InsuranceFactory extends MethodFactory {
    @Override
   public Product createProduct() {
        System.out.println("InsuranceFactory creator.");
        return new Insurance();
    }
}
