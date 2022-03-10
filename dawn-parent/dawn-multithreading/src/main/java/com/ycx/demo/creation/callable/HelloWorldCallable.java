package com.ycx.demo.creation.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.thread.callable
 * @date :       2022/3/9 11:25
 * @copyright :  wpwl
 */
public class HelloWorldCallable {

    public static void main(String[] args) {
        //FutureTask对象
        //Lambda表达式
        FutureTask task = new FutureTask(()->{
            int count = 0;
            for (int i = 0; i <= 100; i++) {
                count += i;
            }
            return count;
        });

        //创建线程
        Thread thread = new Thread(task);
        //启动线程
        thread.start();
        try {
            System.out.println("1 + 2 + 3 + ..... + 100 ="+task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
