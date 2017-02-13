package com.hfcai.designPattern.singleton;

import java.lang.annotation.Documented;

/**
 * @date 17-2-13.
 * @className Singleton
 * @serial 1.0.0
 * @author hfcai
 * 单例设计涉及到一个线程安全和线程不安全的问题，简单介绍下线程安全性的问题:
 * java内存访问模型:
 * Thread  <---------->工作内存<---------->读 <---------->
 *                                        写             主
 * Thread  <---------->工作内存<---------->操 <---------->内
 *                                        作             存
 * Thread  <---------->工作内存<---------->   <---------->
 *
 *
 *多线程的读写操作会先将主存的变量拷贝到线程自有的工作内存中进行读写操作，这样会导致变量的更新不同步问题。
 *三个关键字:
 * final：线程安全(可见性,引用不可改变())
 * synchronized：线程安全，同步锁(可见性，操作原子性)
 * volatile:变量线程安全(可见性，操作非原子性，和final的差异是可作用不可变变量或者可变变量)
 *
 *两个特性:
 * 可见性:多线程操作主内村变量被线程拷贝到工作内存进行更新操作,其余线程访问该变量时总能拷贝到内存更新的最新的变量值
 * 原子性:同一个时刻只能允许一个线程对其进行操作(操作本身并非一定具有原子性)
 *
 */


public class Singleton {
    /**
     * volatile 线程安全,具有可见性，但不具有原子性(synchronized 具有可见性和原子性)
     */
    private static volatile Singleton singleton=null;

    /**
    private static  Singleton singleton=null; //饱汉模式

    //线程不安全
    private static Singleton newInstance(){
        if (singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }


    //线程安全
    private synchronized static Singleton newInstance(){
        if (singleton==null){
            singleton=new Singleton();
        }

        return singleton;
    }

     **/


    /**
     *

    private static final Singleton singleton=new Singleton(); //线程安全,饿汉模式
     public static Singleton newInstance(){
        return singleton;
     }

     **/

    private Singleton(){
        //设置new权限
    }


    /**
     * 单例获取
     * @return
     * 线程安全
     */
    public /**synchronized **/static Singleton newInstance(){
        if (singleton==null){
            //线程不安全
//            singleton=new Singleton();  //非原子操作，包括多个数据域的赋值
            synchronized (Singleton.class){
                singleton=new Singleton();
            }
        }
        return singleton;
    }



}
