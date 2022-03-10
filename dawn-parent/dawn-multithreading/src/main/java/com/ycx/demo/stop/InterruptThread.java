package com.ycx.demo.stop;

/**
 * 中断线程
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.stop
 * @date :       2022/3/10 10:51
 * @copyright :  wpwl
 */
public class InterruptThread extends Thread{

    /**
     * 退出标识
     **/
    public volatile boolean exit = false;

    @Override
    public void run() {
        while (!exit) {
            System.out.println(getName()+ " is running");
            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                System.out.println("week up from block...");
                //在异常处修改共享变量的状态
                exit = true;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        InterruptThread interruptThread = new InterruptThread();
        System.out.println("starting thread...");
        interruptThread.start();
        Thread.sleep(3000);
        //设置退出标识为true
        interruptThread.exit = true;
        // todo 阻塞时用中断退出阻塞状态
        interruptThread.interrupt();
        //主线程休眠3秒以观察interruptThread的中断情况
        Thread.sleep(3000);
        System.out.println("stopping application...");
    }

}
