package org.ycx.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式 - 产品类
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    org.ycx.builder
 * @date :       2021/10/21 11:33
 * @copyright :  wpwl
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    /**
     * 部分产品列表
     **/
    List<String> parts = new ArrayList<>();

    public void add(String part){
        parts.add(part);
    }

    public void show(){
        System.out.println(parts);
    }
}
