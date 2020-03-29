package test;


import domian.Student;
import service.StudentService;

public class TestMain {

    public static void main(String[] args){
        StudentService service = new StudentService();
        Student student = new Student(6,"雅曼","女",22);
        service.insert(student);
    }
}
