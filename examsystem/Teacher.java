package examsystem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Teacher {


    public int checkPaper (ArrayList<Question> paper, String[] trueAnswer){
        System.out.println("老师正在阅卷请稍等...");
        try {
            Thread.sleep(5000);
        }catch(Exception e){
            e.printStackTrace();
        }
        int soccer = 0;
        for (int i = 0; i<paper.size();i++){
            if (paper.get(i).getAnswer().equalsIgnoreCase(trueAnswer[i])){
                soccer += 100/paper.size();
            }
        }
        return soccer;
    }
}
