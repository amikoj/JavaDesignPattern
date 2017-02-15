package com.hfcai.designPattern.factory.simple;

import com.hfcai.designPattern.factory.House;
import com.hfcai.designPattern.factory.Insurance;
import com.hfcai.designPattern.factory.Product;

/**
 * @date 17-2-14.
 * @className ProductFactory
 * @serial 1.0.0
 */

public class ProductFactory {


    /**
     *
     * @param productName
     * @return
     * @throws IllegalProductException
     * 工厂创建类
     */
    public static Product createProduct(String productName) throws IllegalProductException {
        Product product=null;
        if (productName==null || productName.length()==0){
            throw new NullPointerException("product name not null.");
        }

        if (productName.equalsIgnoreCase("house")){
            //返回房子产品
            product=new House();
        }else if (productName.equalsIgnoreCase("insurance")){
            //返回保险产品
            product=new Insurance();
        }else {
            throw new IllegalProductException("product name not exits.");
        }
        return product;
    }


    public static Object create(String className){
        try {
          Object object= Class.forName(className).newInstance();
            return object;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 产品不存在异常
     */
 public    static class  IllegalProductException extends Exception {
//        static final long serialVersionUID = 10000000000000L;
        public IllegalProductException(){
            super();
        }
        public IllegalProductException(String str){
            super(str);
        }

  }
}
