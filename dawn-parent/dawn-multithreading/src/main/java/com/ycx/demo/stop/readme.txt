【终止线程总结】

推荐使用的终止线程的两种方式
1、设置终止标识【线程阻塞不生效】
2、中断线程【线程阻塞时也能够生效】


不推荐(已废弃)的终止线程的方式
1、Thread.stop() //创建子线程的线程会抛出，Error(DeathError)、强行释放子线程拥有的锁，导致出现线程安全问题
2、Thread.suspend() Thread.resume()//顺序有明确要求必须先suspend()【使线程暂停、不会释放锁资源】再resume()【使线程恢复】
3、Runtime.runFinalizersOnExit() //方法本身就线程不安全
