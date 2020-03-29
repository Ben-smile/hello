package service;

import dao.StudentDao;
import domian.Student;

public class StudentService {

    private StudentDao dao = new StudentDao();


    //设计一个方法 用来 新增一条记录

    public void insert (Student student){

        dao.insert(student);
    }

    public void update (Student student){

    }

    public void delete (Integer sid){

    }




}
