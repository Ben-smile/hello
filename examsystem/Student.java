package examsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String name;

    public Student (String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String[] doExam(ArrayList<Question> paper){
        Scanner input = new Scanner(System.in);
        String[] trueAnswer = new String[paper.size()];
        for (int i = 0; i<paper.size();i++){
            System.out.println((i+1)+"."+paper.get(i).getTitle());
            System.out.print("请输入正确答案:");
            trueAnswer[i] = input.nextLine();
        }
        return trueAnswer;
    }
}
