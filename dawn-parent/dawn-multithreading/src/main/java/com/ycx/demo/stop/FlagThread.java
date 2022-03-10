package com.ycx.demo.stop;

/**
 * 设置退出标识
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.stop
 * @date :       2022/3/10 10:32
 * @copyright :  wpwl
 */
public class FlagThread extends Thread{

    /**
     * 设置退出标识
     **/
    public volatile boolean exit = false;

    @Override
    public void run() {
        while (!exit){};
        System.out.println("ThreadFlag线程退出");
    }

    public static void main(String[] args) throws Exception{
        //创建线程
        FlagThread flagThread = new FlagThread();
        //启动线程
        flagThread.start();
        //线程休眠3秒
        Thread.sleep(3000);
        // todo 终止线程thread
        flagThread.exit = true;
        //main线程放弃cpu使用权;
        //让threadFlag线程继续执行,直到threadFlag运行完
        flagThread.join();
        System.out.println("thread exit");
    }

}
