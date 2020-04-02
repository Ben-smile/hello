package dao;

import domain.Student;
import orm.RowMapper;
import orm.SqlSession;
import orm.annotation.Delete;
import orm.annotation.Insert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class StudentDao {

    private SqlSession sqlSession = new SqlSession();

    //DAO变的非常强大了
    //DAO参数不是自己的  参数是前面Service层次传递过来的
    //只写了一条SQL----->自定义注解  反射解析注解
    //找别人干活-------->动态代理
    //DAO的方法里面也不干活了  方法都交给别人SqlSession来干

    //使用方式二
    @Insert("insert into student values(#{sid},#{sname},#{ssex},#{sage})")
//    public void insert(Student student){
//        String sql = "insert into student values(#{sid},#{sname},#{ssex},#{sage})";
//        sqlSession.insert(sql,student);
//    }
//    public void insert(Map map){
//        String sql = "insert into student values(#{sid},#{sname},#{ssex},#{sage})";
//        sqlSession.insert(sql,map);
//    }
    @Delete("delete from student where sid = #{sid}")
//    public void delete(Integer sid){
//        String sql = "delete from student where sid = #{sid}";
//        sqlSession.delete(sql,sid);
//    }
//    public void delete(){
//        String sql = "delete from student";
//        sqlSession.delete(sql);
//    }
//    public void update(Student student){
//        String sql = "update student set sname=#{sname},ssex=#{ssex},sage=#{sage} where sid=#{sid}";
//        sqlSession.update(sql,student);
//    }

//    public Student selectOne(int sid){
//        String sql = "select * from student where sid = #{sid}";
//        return sqlSession.selectOne(sql,sid,Student.class);
//    }
    public String selectOne(int sid){
        String sql = "select sname from student where sid = #{sid}";
        return sqlSession.selectOne(sql,sid,String.class);
    }





//===============================================================================================





    //一个新增的方法
//    public void insert(Student student){
//        String sql = "insert into student values(?,?,?,?)";
//        this.myUpdate(sql,student.getSid(),student.getSname(),student.getSsex(),student.getSage());
//    }
//    一个删除的方法
//    public void delete(Integer sid){
//        String sql = "delete from student where sid = ?";
//        this.myUpdate(sql,sid);
//    }
//    //一个修改的方法
//    public void update(Student student){
//        String sql = "update student set sname = ? , ssex = ? , sage = ? where sid = ?";
//        this.myUpdate(sql,student.getSname(),student.getSsex(),student.getSage(),student.getSid());
//    }

    //学生的单条查询
//    public Student selectOne(String sid){
//        //1.提供一条sql 2.提供sql语句上的问号信息 3.查询的结果按照什么策略组装成什么对象
//        String sql = "select * from student where sid = ?";
//        RowMapper rm = new RowMapper(){
//            public Object mapperRow(ResultSet rs) throws SQLException {
//                Student student = new Student();
//                student.setSid(rs.getInt("sid"));
//                student.setSname(rs.getString("sname"));
//                student.setSsex(rs.getString("ssex"));
//                student.setSage(rs.getInt("sage"));
//                return student;
//            }
//        };
//        //调用sqlSession对象里面的方法帮我们查询
//        Student student = sqlSession.selectOne(sql,rm,sid);
//        return student;
//    }
//    public List<Student> selectList(){
//        //1.提供一条sql 2.提供sql语句上的问号信息 3.查询的结果按照什么策略组装成什么对象
//        String sql = "select * from student";
//        RowMapper rm = new RowMapper(){
//            public Object mapperRow(ResultSet rs) throws SQLException {
//                Student student = new Student();
//                student.setSid(rs.getInt("sid"));
//                student.setSname(rs.getString("sname"));
//                student.setSsex(rs.getString("ssex"));
//                student.setSage(rs.getInt("sage"));
//                return student;
//            }
//        };
//        //调用sqlSession对象里面的方法帮我们查询
//        return sqlSession.selectOne(sql,rm);
//    }


}
