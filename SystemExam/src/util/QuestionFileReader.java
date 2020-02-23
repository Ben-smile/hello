package util;

import domain.Question;


import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class QuestionFileReader {

    //用set集合 是为了在读取文件的时候题目不产生重复
    private HashSet<Question> questionBox = new HashSet<>();
    //块用来初始化
    {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src//datafile//Question.txt"));
            String value = br.readLine();
            while(value!=null){
                String[] values = value.split("#");
                if (values.length == 2) {
                    questionBox.add(new Question(values[0], values[1]));

                }else if(values.length == 3){
                    questionBox.add(new Question(values[0], values[1],values[2]));
                }
                value = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    public HashSet<Question> getQuestionBox(){
        return questionBox;
    }
}
