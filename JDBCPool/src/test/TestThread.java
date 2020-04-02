package test;

import pool.ConnectionPool;
import pool.MyConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestThread extends Thread {

    public void run(){
        //模拟用户使用连接
        Connection mc = ConnectionPool.getInstance().getConnection();
        System.out.println(mc);
        //使用 mc.getConnection();   preparedStatement();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //释放
        //mc.setUsed(false);//空闲状态
        try {
            mc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
