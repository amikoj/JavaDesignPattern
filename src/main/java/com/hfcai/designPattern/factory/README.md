# Factory

工厂模式，主要分为三种类型的工厂模式:

- 简单工厂模式
- 工厂方法模式
- 抽象工厂模式


如上工厂模式的demo实现都是基于:
1) Product.java 产品接口

```java
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

```
2) House.java 实体实现类,真实产品

``` java
   public class House implements Product {

       @Override
       public void sale() {
           //horse sale method
           System.out.println("house sale method.");
       }

       @Override
       public void securityDetection() {
           System.out.println("house securityDetection method.");
       }
   }
```

3) Insurance.java 实体实现类,真实产品

``` java
public class Insurance implements Product {

    @Override
    public void sale() {
        System.out.println("Insurance sale method.");
    }

    @Override
    public void securityDetection() {
        System.out.println("Insurance securityDetection method.");
    }
}
```

并通过工厂类对其进行实现的。

## 简单工厂模式

原理图:

略
``` java
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
```

通过传入名称过滤新建对应的产品类。也可以如下直接通过反射获取。

``` java
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
```

## 工厂方法模式

原理图:

略
按照工厂的需求分设不同部门生产不同的产品，即本身的工厂类不参与生产，由各个分部门制定生产计划,具体代码如下：


1) 工厂类
``` java
public abstract class MethodFactory {
    public abstract  Product createProduct();
}
```


2) 部门生产类


``` java
public class InsuranceFactory extends MethodFactory {
    @Override
   public Product createProduct() {
        System.out.println("InsuranceFactory creator.");
        return new Insurance();
    }
}

```


``` java

public class HouseFactory extends MethodFactory {

    @Override
    public Product createProduct(){
        System.out.println("HouseFactory creator.");
        return new House();
    }
}
```

3) 调用过程

``` java
 MethodFactory methodFactory=new HouseFactory();
        product=methodFactory.createProduct();
        product.sale();

```


## 抽象工厂模式

抽象工厂模式好似一个组装的过程，一件产品可能有多个部分组成，而每个部分的零件可以通过代加工的外包给外部工厂完成,
而自己则完成零件的组装工作。


1) 代工厂1

``` java
public interface LED{
      void product1();
}

//lenovo led product
public class LenovoLED implements LED{
   public  void product1(){
    System.out.println("LenovoLED product1.");
   }
}



//samsung led product
public class SAMSUNGLED implements LED{
   public  void product1(){
    System.out.println("SAMSUNGLED product1.");
   }
}

```

2) 代工厂2


``` java
public interface Mouse{
      void product2();
}

//lenovo mouse product
public class LenovoMouse implements Mouse{
   public  void product2(){
    System.out.println("LenovoMouse product2.");
   }
}



//samsung Mouse product
public class SAMSUNGMouse implements Mouse{
   public  void product2(){
    System.out.println("SAMSUNGMouse product1.");
   }
}

```


3) 品牌组装


``` java
public abstract class AbstractFactory {

    public abstract Product createMouse();
    public abstract Human createLED();
}




//Lenovo factory
public class LenovoFactory extends AbstractFactory{

   public abstract Mouse createMouse(){
      System.out.println("LenovoMouse assembled Mouse.");

   }
    public abstract LED createLED(){
        System.out.println("LenovoMouse assembled LED.");
    }
}


//SAMSUNG factory
public class SAMSUNGFactory extends AbstractFactory{

   public abstract Mouse createMouse(){
      System.out.println("SAMSUNGMouse assembled Mouse.");

   }
    public abstract LED createLED(){
        System.out.println("SAMSUNGMouse assembled LED.");
    }
}

```


4) 调用过程

``` java

 AbstractFactory abstractFactory=new LenovoFactory();
        abstractFactory.createMouse();
        abstractFactory.createLED();
```


5) 使用场景

对于背景皮肤的设定，类似接入多种sdk广告的整合，可以按照广告的展示类型使用抽象工厂模式进行扩展.

