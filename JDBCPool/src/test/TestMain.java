package test;


import pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SuppressWarnings("all")
public class TestMain {

    //MySQL
    //JDBC
    public static void main(String[] args) throws Exception {
        //1.导包
        //2.配置文件(加载驱动类driver 连接数据库url username password 配置初始个数minCount 配置等待时间waitTime)
        //3.连接池对象----代替是原来的DriverManager
        ConnectionPool pool = ConnectionPool.getInstance();
        //4.获取连接
        Connection connection = pool.getConnection();//MyConnection--实现Connection接口
        //5.状态参数
        PreparedStatement pstat = connection.prepareStatement("select * from student");
        //6.执行操作
        ResultSet rs = pstat.executeQuery();
        //7.遍历
        while(rs.next()){
            System.out.println(rs.getString("sname"));
        }
        //8.关闭
        rs.close();
        pstat.close();
        connection.close();
        //以上设计的本质   静态代理了模式









//        TestThread t1 = new TestThread();
//        TestThread t2 = new TestThread();
//        TestThread t3 = new TestThread();
//        TestThread t4 = new TestThread();
//        TestThread t5 = new TestThread();
//        TestThread t6 = new TestThread();
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();






//        //1.导包
//        //2.创建一个连接池对象
//        long t1 = System.currentTimeMillis();
//        ConnectionPool pool = ConnectionPool.getInstance();
//        //3.调用连接池提供的方法获取一个可用连接
//        MyConnection mc = pool.getMC();
//        long t2 = System.currentTimeMillis();
//        //4.将mc中的真实连接获取出来
//        Connection connection = mc.getConnection();
//        //5.状态参数
//        PreparedStatement pstat = connection.prepareStatement("select * from student");
//        //6.执行操作
//        ResultSet rs = pstat.executeQuery();
//        while(rs.next()){
//            System.out.println(rs.getString("sname"));
//        }
//        long t3 = System.currentTimeMillis();
//        System.out.println(t2-t1);
//        System.out.println(t3-t2);
//        //7.关闭
//        rs.close();
//        pstat.close();
//        mc.setUsed(false);//释放连接(将状态切换回空闲状态)
//
//        System.out.println("=================================");
//
//        long t4 = System.currentTimeMillis();
//        //3.调用连接池提供的方法获取一个可用连接
//        MyConnection mc1 = pool.getMC();
//        long t5 = System.currentTimeMillis();
//        //4.将mc中的真实连接获取出来
//        Connection connection1 = mc1.getConnection();
//        //5.状态参数
//        PreparedStatement pstat1 = connection1.prepareStatement("select * from student");
//        //6.执行操作
//        ResultSet rs1 = pstat1.executeQuery();
//        while(rs1.next()){
//            System.out.println(rs1.getString("sname"));
//        }
//        long t6 = System.currentTimeMillis();
//        System.out.println(t5-t4);
//        System.out.println(t6-t5);











//        //1.导包
//        //2.加载驱动
//        Class.forName("com.mysql.jdbc.Driver");
//        //3.获取连接
//        long t1 = System.currentTimeMillis();
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newtest?useSSL=false","root","123456");
//        long t2 = System.currentTimeMillis();
//        //4.创建状态参数(预处理)
//        PreparedStatement pstat = connection.prepareStatement("select * from student");
//        //5.执行操作    增删改     查询
//        ResultSet rs = pstat.executeQuery();
//        while(rs.next()){
//            System.out.println(rs.getInt("sid")+"--"+rs.getString("sname"));
//        }
//        long t3 = System.currentTimeMillis();
//        System.out.println(t2-t1);
//        System.out.println(t3-t2);
//        //6.关闭
//        rs.close();
//        pstat.close();
////        connection.close();
    }
}
