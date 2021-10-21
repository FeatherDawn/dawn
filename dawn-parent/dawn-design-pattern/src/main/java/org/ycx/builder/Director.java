package org.ycx.builder;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    org.ycx.builder
 * @date :       2021/10/21 11:45
 * @copyright :  wpwl
 */


@Data
@AllArgsConstructor
public class Director {
    private Builder builder;

    public void construct(){
        builder.buildPartA();
        builder.buildPartB();
    }
}
