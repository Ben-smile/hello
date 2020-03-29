package test;

import JDBCPool.ConnectionPool;
import JDBCPool.MyConnection;


public class TestThread extends Thread{



    public void run(){
        ConnectionPool cp =ConnectionPool.getInstance();
        MyConnection conn = cp.getConnection();
        try {
            System.out.println("连接对象"+conn);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conn.setState(false);
    }

}
