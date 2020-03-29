package dao;

import JDBCPool.ConnectionPool;
import domian.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class StudentDao {

    //设计一个方法用来新增一条记录
    public void insert(Student student){
        String sql = "insert into student values(?,?,?,?)";

        try {
            //1.导包
            //2.配置文件
            ConnectionPool pool = ConnectionPool.getInstance();
            //3.获取连接
            Connection conn = pool.getConnection();
            //4.获取状态参数
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1,student.getSid());
            pstat.setString(2,student.getSname());
            pstat.setString(3,student.getSsex());
            pstat.setInt(4,student.getSage());
            //5.执行sql
            pstat.executeUpdate();
            //6.关闭连接
            pstat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student){
        String sql = "update student set student.get";

        try {
            //1.导包
            //2.配置文件
            ConnectionPool pool = ConnectionPool.getInstance();
            //3.获取连接
            Connection conn = pool.getConnection();
            //4.获取状态参数
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1,student.getSid());
            pstat.setString(2,student.getSname());
            pstat.setString(3,student.getSsex());
            pstat.setInt(4,student.getSage());
            //5.执行sql
            pstat.executeUpdate();
            //6.关闭连接
            pstat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(Integer sid){
        String sql = "delete from student where sid = ?";

        try {
            //1.导包
            //2.配置文件
            ConnectionPool pool = ConnectionPool.getInstance();
            //3.获取连接
            Connection conn = pool.getConnection();
            //4.获取状态参数
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1,sid);

            //5.执行sql
            pstat.executeUpdate();
            //6.关闭连接
            pstat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
