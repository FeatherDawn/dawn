package com.ycx.demo.priority.systematicness;

import java.util.Random;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.priority.systematicness
 * @date :       2022/3/31 15:09
 * @copyright :  wpwl
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        System.out.println("------1------ thread 1 start running");
        long count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50000; j++) {
                Random random = new Random();
                int number = random.nextInt();
                count = count + number;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("------1------ thread 1 use time =" + (end - start));
    }
}
