# Proxy
代理模式通过Proxy提供的Proxy.newProxyInstance(...)可以实现动态代理注入,接下来按照以下几个方面来简单介绍代理模式.

- 代理模式类图
- 静态代理模式
- 动态代理模式
- 代理模式使用场景


## 代理模式类图

略


## 静态代理模式

简单代理模式和动态代理模式的结构类似，首先需要先定义个公用的代理接口,如下:

``` java
public interface ILocation {
    /**
     *
     * @param location
     */
    void shareLocation(String location);
}

```

代理接口的定义其实也就是定义该代理需要作的事是什么,具体的代理接口实现需要根据业务或者需求的不同进行定义实现,实现类如下:

``` java
public class GeoLoaction implements ILocation {
    @Override
    public void shareLocation(String location) {
         //具体实现代码
        System.out.print("GeoLocation info:"+location+"\n");
    }
}

```

该部分代码主要是用于代理接口功能具体实现的方法(代码),需要依据具体的技术或者提供的协议差别实现,我们还需要通过一个代理类实现对代理类和代理实现的一个桥接作用,如下所示:

``` java
public class ILocationProxy implements ILocation {

 private ILocation iLocation;


 private ILocationProxy(ILocation iLocation){
     //代理实现的设置操作
     this.iLocation=iLocation;
     .....
 }

  public void shareLocation(String location) {

          ...
          //具体实现前的操作
         System.out.print("ILocationProxy shareLocation.");
         iLocation.shareLocation(location);
         //具体实现后的操作
         ...
     }

}


```

使用方法比较简单,代码如下：

``` java

ILocationProxy proxy=new ILocationProxy(new GeoLoaction());
proxy.shareLocation("share location.");

```


## 动态代理模式


