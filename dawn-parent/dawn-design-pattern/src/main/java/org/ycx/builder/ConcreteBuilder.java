package org.ycx.builder;

/**
 * 建造者模式 - Builder 实现类
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    org.ycx.builder
 * @date :       2021/10/21 11:41
 * @copyright :  wpwl
 */
public class ConcreteBuilder extends Builder{

    private Product product = new Product();


    @Override
    public void buildPartA() {
        product.add("构建产品的上半部分");
    }

    @Override
    public void buildPartB() {
        product.add("构建产品的下半部分");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
