package service;


import newdao.StudentDao;
import domain.Student;
import orm.SqlSession;

import java.util.List;

public class StudentService {

    //只有service获取dao时改变了
    // 原来dao是new出来的                     是个StudentDao对象
    // 现在dao是通过getMapper方法获取出来的     是StudentDao对象的代理对象
    private StudentDao dao = new SqlSession().getMapper(StudentDao.class);

    public void insert(Student student){
        dao.insert(student);
    }
    public Student selectOne(Integer sid){
        return dao.selectOne(sid);
    }

    public List<Student> studentList(){
        return dao.selectList();
    }



    //==========================================================

    //业务层
    //这个类中的方法都是业务逻辑
    //比较 判断 计算 等等

//    private StudentDao dao = new StudentDao();

    //业务方法 新增 修改 删除
//    public void insert(Student student){
//        dao.insert(student);
//    }
//    public void insert(Map map){
//        dao.insert(map);
//    }
//    public void delete(Integer sid){
//        dao.delete(sid);
//    }
//    public void update(Student student){
//        dao.update(student);
//    }
    //-----------------------------------------------------
    //业务方法 查询单条 查询多条
//    public Student selectOne(Integer sid){
//        return dao.selectOne(sid);
//    }
//    public String selectOne(Integer sid){
//        return dao.selectOne(sid);
//    }


//    public List<Student> selectList(){
//
//    }
}
