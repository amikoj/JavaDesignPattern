package com.hfcai.designPattern;

import com.hfcai.designPattern.dynamicProxy.GeoLoaction;
import com.hfcai.designPattern.dynamicProxy.ILocation;
import com.hfcai.designPattern.dynamicProxy.ILocationProxy;
import com.hfcai.designPattern.factory.House;
import com.hfcai.designPattern.factory.Insurance;
import com.hfcai.designPattern.factory.Product;
import com.hfcai.designPattern.factory.abstractFactory.AbstractFactory;
import com.hfcai.designPattern.factory.abstractFactory.DefaultFactory;
import com.hfcai.designPattern.factory.abstractFactory.DefaultWomanFactory;
import com.hfcai.designPattern.factory.abstractFactory.Human;
import com.hfcai.designPattern.factory.abstractFactory.Man;
import com.hfcai.designPattern.factory.abstractFactory.Woman;
import com.hfcai.designPattern.factory.method.HouseFactory;
import com.hfcai.designPattern.factory.method.MethodFactory;
import com.hfcai.designPattern.factory.simple.ProductFactory;
import com.hfcai.designPattern.singleton.Singleton;
import com.hfcai.designPattern.singleton.SingletonEnum;

/**
 * @author hfcai
 * test class.
 */
public class MainClass {


    public static void main(String[] args) throws ProductFactory.IllegalProductException {
        //test dynamic proxy pattern
        testDynamicProxyPattern();

        //单例模式
        Object object=SingletonEnum.INSTANCE.getObject();

        //工厂模式
        testFactoryPattern();

    }


    /**
     * proxy pattern
     */
    private static void testDynamicProxyPattern(){
            ILocation iLocation=new GeoLoaction();
            //绑定代理类
            iLocation= (ILocation) ILocationProxy.bind(iLocation);
            iLocation.shareLocation("test");

    }



    private static void testFactoryPattern() throws ProductFactory.IllegalProductException {
         Product product;
        //简单工厂模式
         product= ProductFactory.createProduct("house");
         product.sale();


        //工厂方法模式
        MethodFactory methodFactory=new HouseFactory();
        product=methodFactory.createProduct();
        product.sale();

        //抽象工厂模式

        AbstractFactory abstractFactory=new DefaultFactory();
        abstractFactory.createHuman();
        abstractFactory.createProduct();

        abstractFactory=new DefaultWomanFactory();
        abstractFactory.createHuman();
        abstractFactory.createProduct();

    }
}
