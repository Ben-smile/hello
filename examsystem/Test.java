package examsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        System.out.println("开始考试 请登录考试系统");
        System.out.println("----------------------");
        Student student = new Student("张三");
        ExamMachine e = new ExamMachine();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = input.nextLine();
        System.out.println("请输入密码:");
        String password = input.nextLine();
        if (e.judge(name,password)){
            System.out.println("登录成功 开始考试");
            ArrayList<Question> paper =e.getExamPaper();
            String[] realAnswer = student.doExam(paper);
            Teacher t = new Teacher();
            int soccer = t.checkPaper(paper,realAnswer);
            System.out.println("您的最后成绩为"+soccer);
        }else {
            System.out.println("用户名或密码错误");
        }
    }
}
