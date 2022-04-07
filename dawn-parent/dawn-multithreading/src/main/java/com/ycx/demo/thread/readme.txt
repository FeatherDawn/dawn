【sleep】
1、sleep()方法的做用是让当前线程暂停指定的时间(毫秒)
2、sleep()方法只是暂时让出Cpu的执行权，并不释放锁
3、由于对象锁没有被释放,其它线程仍然无法访问这个对象
4、sleep()方法不需要再同步的代码块中执行，wait()必须要在同步的代码块中执行
5、sleep()可以通过interrupt()方法打线程的暂停状态
6、sleep()只是线程的操作，用于短时间暂停线程，不涉及线程间通信
7、sleep()是Thread类的方法【不是object类的】

【wait】
1、wait()/notify()方法通常成对出现
2、wait()/notify()方法需要获取对象锁方可调用
3、wait()/notify()方法要写在同步代码块或者同步方法内
4、一旦调用wait()方法，其它线程可以访问这个对象
5、当一个线程执行到wait()方法时，其他线程将可以访问这个对象
6、wait()可以通过interrupt()方法打断线程的暂停状态，从而使线程立刻抛出中断异常
7、重获对象锁：
    a)设置wait()方法的参数,如wait(1000)表名借出去1秒后自动收回锁
    b)让解锁的线程通知(notify)当前线程，借锁线程用完了当前线程马上就收回来
8、wait()/notify()是Object类的方法

【notify()/notifyAll()】
1、notify()唤醒在此对象监视器(对象锁)上等待的单个线程
2、当它被一个notify()方法唤醒时，等待池中的线程就被放到了锁池中
3、该线程将等待从锁池中获得锁，然后回到wait()前的中断现场
4、notifyAll()唤醒在此对象监视器(对象锁)上等待的所有线程
5、唤醒先成功的顺序-------LIFO(last in first out)【后进先出】
6、wait()/notify()/ notifyAll()涉及线程间的通信

【yield() 单词字面意思 : 放手、放弃、投降】
1、yield()方法的意思是告诉CPU执行其他的线程，当前线程让出CPU的执行权力
2、yield()方法不能保证使得当前正在运行的线程迅速转换到可运行的状态
3、yield()方法的作用就是将当前线程从执行状态转变到可执行状态
4、yield()方法不能保证其他线程一定能够执行,因为执行过yield()方法的线程当前依然是可执行状态，有可能被CPU再次执行
5、执行yield()方法的线程不会释放锁

【join】
1、join()方法可以使得一个线程在另一个线程结束后再执行
2、如果join()方法在一个线程实例上调用,当前运行着的线程将阻塞这道这个线程执行完成了
3、join()方法可以设定超时时间,使得join()方法的影响在超时后无效
4、join()重载的方法有: join(long millis),join(long millis,int nanos)
5、当join()超时后,主方法和任务线程申请运行的时候是平等的
6、join()可以抛出InterruptedException对中断做出回应

【sleep()/wait()/yield()/join()对比】
1、Thread.sleep(long) 和 Thread.yield()都是Thread类的静态方法,join()是由线程对象来调用
2、sleep()使线程从运行状态进入阻塞状态,超时后进入就绪状态,是否进入运行状态就要看操作系统的内部调用机制
3、如果Thread.sleep(long)/Thread.yield()使用在由synchronized锁定的代码块中,那么在调用他们的过程当中,并不会释放锁。wait()方法会释放锁。
4、join()方法可以使得一个线程在另一个线程结束后再执行
5、yield()方法是让当前线程由运行状态进入就绪状态，然后让操作系统重新调度一次,这次调度只会让处于就绪队列中比当前线程优先级高或者相等的线程运行,很
   可能某个线程在调用了yield方法后,又被操作系统调度运行
6、wait()和notify()、notifyAll()这三个方法用于协调多个线程对共享数据的存取,必须在synchronized语句块内使用这三个方法,否则可能会抛出
   (IllegalMonitorStateException)
