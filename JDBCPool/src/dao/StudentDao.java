package dao;

import orm.SQLSession;


public class StudentDao {
    /**
     *  为了解决dao层 jdbc代码的冗余 进行封装
     *  增删改 方法
     *  问题 1. 参数传的类型
     *  问题 2. sql问号的赋值
     */

    private SQLSession session = new SQLSession();



    public void insert(Object obj){
        String sql = "insert into student values(#{sid},#{sname},#{ssex},#{sage})";
        session.insert(sql,obj);
    }

    public void delete(Object obj){
        String sql = "delete from student where sid = #{sid}";
        session.delete(sql,obj);
    }
    public void delete(){
        String sql = "delete from student";
        session.delete(sql,null);
    }

    public void update(Object obj){
        String sql = "update student set sname = #{sname},ssex =#{ssex},sage = #{sage} where sid = #{sid}";
        session.Update(sql,obj);
    }









//    //设计一个方法用来新增一条记录
//    public void insert(Student student){
//        String sql = "insert into student values(?,?,?,?)";
//
//        try {
//            //1.导包
//            //2.配置文件
//            ConnectionPool pool = ConnectionPool.getInstance();
//            //3.获取连接
//            Connection conn = pool.getConnection();
//            //4.获取状态参数
//            PreparedStatement pstat = conn.prepareStatement(sql);
//            pstat.setInt(1,student.getSid());
//            pstat.setString(2,student.getSname());
//            pstat.setString(3,student.getSsex());
//            pstat.setInt(4,student.getSage());
//            //5.执行sql
//            pstat.executeUpdate();
//            //6.关闭连接
//            pstat.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void update(Student student){
//        String sql = "update student set sname = ?,ssex = ?,sage = ? where sid = ?";
//
//        try {
//            //1.导包
//            //2.配置文件
//            ConnectionPool pool = ConnectionPool.getInstance();
//            //3.获取连接
//            Connection conn = pool.getConnection();
//            //4.获取状态参数
//            PreparedStatement pstat = conn.prepareStatement(sql);
//
//            pstat.setString(1,student.getSname());
//            pstat.setString(2,student.getSsex());
//            pstat.setInt(3,student.getSage());
//            pstat.setInt(4,student.getSid());
//            //5.执行sql
//            pstat.executeUpdate();
//            //6.关闭连接
//            pstat.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public void delete(Integer sid){
//        String sql = "delete from student where sid = ?";
//
//        try {
//            //1.导包
//            //2.配置文件
//            ConnectionPool pool = ConnectionPool.getInstance();
//            //3.获取连接
//            Connection conn = pool.getConnection();
//            //4.获取状态参数
//            PreparedStatement pstat = conn.prepareStatement(sql);
//            pstat.setInt(1,sid);
//
//            //5.执行sql
//            pstat.executeUpdate();
//            //6.关闭连接
//            pstat.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }



}
