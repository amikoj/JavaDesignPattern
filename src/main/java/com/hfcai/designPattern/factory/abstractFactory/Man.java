package com.hfcai.designPattern.factory.abstractFactory;

/**
 * @date 17-2-14.
 * @className Man
 * @serial 1.0.0
 */

public class Man implements Human {
    @Override
    public void operation() {
        System.out.println("Man operation method.");
    }
}
