package com.hfcai.designPattern.factory;

/**
 * @date 17-2-14.
 * @className product
 * @serial 1.0.0
 */

public interface Product {

    String TAG=Product.class.getSimpleName();
    /**
     * 产品销售方法
     */
    void sale();

    /**
     * 安全检测方法
     */
    void securityDetection();
}
