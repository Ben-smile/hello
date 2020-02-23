package dao;

import domain.Question;
import util.MySpring;
import util.QuestionFileReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class QuestionDao {

    private QuestionFileReader questionFileReader =(QuestionFileReader) MySpring.getBean("util.QuestionFileReader");
    //将set集合临时转换成list
    private ArrayList<Question> questionBank = new ArrayList<>(questionFileReader.getQuestionBox());


    public ArrayList<Question>  getPaper(int count){

        Random r = new Random();
        //临时用set集合是为了保证题目没有重复
        HashSet<Question> paper = new HashSet<>();
        while (paper.size() < count){
            int index = r.nextInt(10);
            paper.add(questionBank.get(index));
        }
        return new ArrayList<Question>(paper); //再次构建成list
    }

}
