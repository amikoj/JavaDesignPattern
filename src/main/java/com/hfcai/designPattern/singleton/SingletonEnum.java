package com.hfcai.designPattern.singleton;

/**
 * @date 17-2-14.
 * @className SingletonEnum
 * @serial 1.0.0
 * jdk 1.5引入的单例实现，较为简单高效
 */

public enum SingletonEnum {

    INSTANCE;
    private Object object;


    SingletonEnum(){
        //Initialization
        object=new Object();
        //handle
    }

    public Object getObject(){
        return object;
    }
}
