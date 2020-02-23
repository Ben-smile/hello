package service;

import dao.QuestionDao;
import domain.Question;
import util.MySpring;

import java.util.ArrayList;

public class QuestionService {

    QuestionDao dao = (QuestionDao) MySpring.getBean("dao.QuestionDao");
    public ArrayList<Question> getPaper(int count){
        return dao.getPaper(count);
    }
}
