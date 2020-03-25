package test;

import pool.ConnectionPool;
import pool.MyConnection;

public class TestThread extends Thread {

    public void run(){
        //模拟用户使用连接
        MyConnection mc = ConnectionPool.getInstance().getMyConnection();
        System.out.println(mc);
        //使用 mc.getConnection();   preparedStatement();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //释放
        mc.setUsed(false);//空闲状态
    }
}
