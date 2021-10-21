package org.ycx.builder;

/**
 * 建造者模式 -  抽象Builder类
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    org.ycx.builder
 * @date :       2021/10/21 11:38
 * @copyright :  wpwl
 */
public abstract class Builder {
    /**
     * 产品上半部分
     * @author : guowc
     * @date   : 2021/10/21 11:40
     * @param
     * @return : void
     **/
    public abstract void buildPartA();

    /**
     * 产品下半部分
     * @author : guowc
     * @date   : 2021/10/21 11:40
     * @param
     * @return : void
     **/
    public abstract void buildPartB();

    /**
     * 获得产品
     * @author : guowc
     * @date   : 2021/10/21 11:40
     * @param
     * @return : Product
     **/
    public abstract Product getResult();
}
