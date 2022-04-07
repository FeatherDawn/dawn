package com.ycx.demo.thread.sleep;

/**
 * 验证sleep()方法不会释放锁，wait方法会释放锁
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.thread.sleep
 * @date :       2022/4/1 15:10
 * @copyright :  wpwl
 */
public class SleepTest {

    /**
     * sleep()方法不会释放锁,因此线程是按照先后顺序来的
     **/
    public synchronized void sleepMethod(){
        System.out.println("Sleep start : " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sleep end : " + Thread.currentThread().getName());
    }

    /**
     * wait()方法会释放锁,因此一旦调用wait()方法就会造成其它线程运行
     **/
    public synchronized void waitMethod(){
        System.out.println("Wait start : " + Thread.currentThread().getName());
        synchronized (this){
            try {
                //wait()必须要在同步代码块中执行
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Wait end : " + Thread.currentThread().getName());
    }

    /**
     * 测试main方法
     * @author : guowc
     * @date   : 2022/4/1 15:44
     * @param    args
     * @return : void
     **/
    public static void main(String[] args) {
        final SleepTest test1= new SleepTest();
        for (int i = 0; i < 5; i++) {
            new Thread(()->test1.sleepMethod()).start();
        }

        //暂停十秒，等待上面程序执行完成
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------分割线-----");

        final SleepTest test2 = new SleepTest();
        for (int i = 0; i < 5; i++) {
            new Thread(()-> test2.waitMethod()).start();
        }
    }
}
