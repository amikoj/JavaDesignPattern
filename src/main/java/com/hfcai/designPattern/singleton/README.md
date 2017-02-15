# Singleton
单例模式，单例模式demo主要描述了四种单例的实现方式

## 饱汉模式
``` java


 private static  Singleton singleton=null; //饱汉模式
    //线程不安全
    private static Singleton newInstance(){
        if (singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }

    private Singleton(){
        //设置new权限
    }


    //线程安全
    private synchronized static Singleton newInstance(){
        if (singleton==null){
            singleton=new Singleton();
        }

        return singleton;
    }

```

## 饿汉模式

``` java
     private static final Singleton singleton=new Singleton(); //线程安全,饿汉模式

     private Singleton(){
        //设置new权限
     }

     public static Singleton newInstance(){
        return singleton;
     }

```

## 懒汉模式

``` java

      /**
        * volatile 线程安全,具有可见性，但不具有原子性(synchronized 具有可见性和原子性)
        */
        private static volatile Singleton singleton=null;

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
```



## Enum模式

``` java
    public enum Test{
           INSTANCE;
           public void test(){
                 ......
              //method body
                 ......
           }
    }
```


注意如上几种实现均实现了线程安全。