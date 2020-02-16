package testthread;

public class TestThread {
    /*
     以前学过的很多东西   都有线程的问题
     例如 StringBuilder    StringBuffer(线程安全)

          ArrayList        Vector(线程安全)
          HashMap            HashTable(线程安全)


    程序
           可以理解为是一组静态的代码
    进程
           静态的代码运行起来   是正在运行的程序
    线程
           正在执行程序的小单元


      主线程 :  系统线程(JVM)
      用户线程:  main方法
      守护(精灵)线程 : GC

      线程-------操作系统级别  我们不能控制它的执行

        new     start()    cpu分配 run()     wait()     exception   over
      创建线程---就绪状态----执行状态----等待/挂起-----异常/消亡
                    |_______________________|
                             可以转化


      实现线程的过程  第一种
        1.自己描述一个类
        2.继承 Thread
        3.重写run() 方法
        4.new 一个线程的对象   调用start() 方法 让线程进入就绪状态

      实现线程的过程  第二种
           如果这个类已经继承了其他的类  因为java中是单继承  所以我们可以通过实现一个接口
        1.自己描述一个类
        2.实现一个Runnable接口
        3.重写run() 方法
        4.因为接口里面没有 具体的方法  所以没有start()  等这些方法
          所以我们可以先new 一个线程对象 创建一个Thread对象 将自己的对象包起来 然后调用start()

     */
}
