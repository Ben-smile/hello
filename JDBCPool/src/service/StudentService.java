package service;

import dao.StudentDao;
import domian.Student;

public class StudentService {

    private StudentDao dao = new StudentDao();


    //方法1

//    public void insert (Student student){
//        String sql = "insert into student values(?,?,?,?)";
//        dao.insert(sql,student.getSid(),student.getSname(),student.getSsex(),student.getSage());
//    }
//
//    public void update (Student student){
//        String sql = "update student set sname = ?,ssex = ?,sage = ? where sid = ?";
//        dao.update(sql,student.getSname(),student.getSsex(),student.getSage(),student.getSid());
//    }
//
//    public void delete (Integer sid){
//        String sql = "delete from student where sid = ?";
//        dao.delete(sql,sid);
//    }
    //------------------------------------------------------------

    //方法二
    public void insert (Student student){

        dao.insert(student);
    }

    public void update (Student student){

        dao.update(student);
    }

    public void delete (Integer sid){

        dao.delete(sid);
    }

    public void delete (){
        dao.delete();
    }


}
