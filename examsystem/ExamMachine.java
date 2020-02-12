package examsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class ExamMachine {
    //创建一个题库 因为不想让题目重复所以用Set集合来存储
    private HashSet<Question> questionBank = new HashSet<>();
    //创建一个块来初始化题库
    {
        questionBank.add(new Question("以下选项哪个是Java基本数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C"));
        questionBank.add(new Question("以下选项哪个不是Java基本数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.double","A"));
        questionBank.add(new Question("以下选项哪个是Java引用数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.char","A"));
        questionBank.add(new Question("以下选项哪个不是Java引用数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C"));
        questionBank.add(new Question("以下选项哪个是java.util包中的类?\n\tA.String\n\tB.Integer\n\tC.Scanner\n\tD.Math","C"));
        questionBank.add(new Question("以下选项哪个不是java.util包中的类?\n\tA.Date\n\tB.Integer\n\tC.Calendar\n\tD.Random","B"));
        questionBank.add(new Question("以下选项哪个不是String类中的方法?\n\tA.compareTo\n\tB.append\n\tC.substring\n\tD.concat","B"));
        questionBank.add(new Question("以下选项哪个是String类中方法?\n\tA.append\n\tB.delete\n\tC.insert\n\tD.concat","D"));
        questionBank.add(new Question("以下选项哪个不是接口中属性的修饰符?\n\tA.public\n\tB.static\n\tC.final\n\tD.abstract","D"));
        questionBank.add(new Question("以下选项哪个不是Set集合的方法?\n\tA.set\n\tB.add\n\tC.remove\n\tD.iterator","A"));
    }
    //再创建一个集合 存储学生的信息
    private HashMap<String,String> studentMessage = new HashMap<>();

    //判断学生信息
    public boolean judge (String name,String password){
        String realPassword = studentMessage.get(name);
        if (realPassword != null && password.equals(realPassword)){
            return true;
        }
        return false;
    }

    {
        studentMessage.put("张三","123");
        studentMessage.put("李四","666");
        studentMessage.put("王五","888");
    }
    public ArrayList<Question> getExamPaper (){
        System.out.println("考试机正在随机的生成试卷,请耐心等待。。。");
        try {
            Thread.sleep(5000);
        }catch(Exception e){
            e.printStackTrace();
        }
        ArrayList<Question> questions = new ArrayList<>(questionBank);
        HashSet<Question> paper = new HashSet<>();
        Random random = new Random();
        while(paper.size() < 5){
            int value = random.nextInt(questionBank.size());
            paper.add(questions.get(value));
        }
        return new ArrayList<>(paper);
    }
}
