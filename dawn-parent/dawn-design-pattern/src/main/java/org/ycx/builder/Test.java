package org.ycx.builder;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    org.ycx.builder
 * @date :       2021/10/21 11:47
 * @copyright :  wpwl
 */
public class Test {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.getResult();
        product.show();

    }
}
