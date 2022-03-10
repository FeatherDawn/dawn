package com.ycx.demo.interruption;

/**
 * 重新中断
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.interruption
 * @date :       2022/3/9 17:06
 * @copyright :  wpwl
 */
public class ReInterrupt extends Thread{
    public static void main(String[] args) throws Exception{
        ReInterrupt reInterrupt = new ReInterrupt();
        System.out.println("Starting thread......");
        //启动子线程
        reInterrupt.start();
        //将主线程休眠3秒
        Thread.sleep(3000);
        System.out.println("Asking thread to stop...");
        //设置子线程中断
        reInterrupt.interrupt();
        //主线程休眠3秒
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }

    @Override
    public void run() {
        //for循环等待线程中断
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("child thread running...");
            try {
                System.out.println("running 1:"+this.isInterrupted());
                Thread.sleep(1000);
                System.out.println("running 2:"+this.isInterrupted());
                System.out.println("child thread not interrupted");
            } catch (InterruptedException e) {
                System.out.println("thread interrupted...");
                //false
                System.out.println(this.isInterrupted());
                //中不中断由自己决定，如果需要真的中断线程，则需要重新设置中断位
                //如果不需要，则不用调用)
                //如果不重新设置中断将会一直死循环
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("reInterrupt..."+this.isInterrupted());
        System.out.println("Thread exiting...");
    }
}
