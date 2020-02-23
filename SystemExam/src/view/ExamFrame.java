package view;

import domain.Question;
import service.QuestionService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExamFrame extends BaseFrame {

    //获取QuestionService对象
    private QuestionService service = (QuestionService)MySpring.getBean("service.QuestionService");
    //得到的试卷
    private ArrayList<Question> paper = service.getPaper(10);
    //创建一个数组 用来储存 用户回答的答案
    private String[] answers = new String[paper.size()];

    //---------------------------------
    private TimeThread timeThread = new TimeThread();
    //创建一个时间的属性
    private int time = 90; //代表90分钟
    //创建一个用来处理倒计时的线程
    public class TimeThread extends Thread{  //创建一个内部类
        private boolean flag = true;  //创建一个标记
        public void stopTimeThread(boolean flag){
            this.flag = flag;  //调用此方法 会中断 while 循环从而中断 线程
        }
        public void run(){
            //首先处理时间  将90分钟---> 01:30:00
            int hour = time/60;
            int minute = time%60;
            int second = 0;
            //循环 每一秒 减少1
            while(flag){
                StringBuilder time = new StringBuilder();
                if (second == 0){
                    if(minute == 0){
                        if (hour == 0){
                            realTimeLabel.setForeground(Color.red);
                            ExamFrame.this.closeButton();
                            pervButton.setEnabled(false);
                            break;
                        }else {
                            hour--;
                            minute=59;
                            second=59;
                        }
                    }else{
                        minute--;
                        second=59;
                    }
                }else{
                    second--;
                }
                //判断 此时的时分秒是否是 个位数 如果是 拼一个0
                if(hour >=0 && hour<10){
                    time.append(0);
                    time.append(hour);
                }else{
                    time.append(hour);
                }
                time.append(":");
                if(minute >=0 && minute<10){
                    time.append(0);
                    time.append(minute);
                }else{
                    time.append(minute);
                }
                time.append(":");
                if(second >=0 && second<10){
                    time.append(0);
                    time.append(second);
                }else{
                    time.append(second);
                }

                realTimeLabel.setText(time.toString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //-----------------------
    private int nowNum = 0;
    private int allQuestionNum = paper.size();
    private int answerNum = 0;
    private int unanswerNum = allQuestionNum;
    //-------------------------------------------------------

    //添加面板
    private JPanel mainPanel = new JPanel();//主面板
    private JPanel messagePanel = new JPanel();//信息面板
    private JPanel buttonPanel = new JPanel();//按钮面板
    //添加题目文本框
    private JTextArea examArea = new JTextArea();
    private JScrollPane examScroll = new JScrollPane(examArea);//添加滚动条
    //添加信息面板的内容
    private JLabel pictureLabel = new JLabel();//添加图片
    private JLabel nowQuestionLabel = new JLabel("当前题号:");//当前题号
    private JLabel allQuestionLabel = new JLabel("总共题数:");//总共题目
    private JLabel answerLabel = new JLabel("已答题数:");
    private JLabel unanswerLabel = new JLabel("未答题数:");

    private JTextField nowQuestionField = new JTextField();//展示
    private JTextField allQuestionField = new JTextField();
    private JTextField answerField = new JTextField();
    private JTextField unanswerField = new JTextField();
    private JLabel timeLabel = new JLabel("剩余答题时间: ");//时间
    private JLabel realTimeLabel = new JLabel("01:00:00");
    //给按钮面板添加组件
    private JButton aButton = new JButton("A");
    private JButton bButton = new JButton("B");
    private JButton cButton = new JButton("C");
    private JButton dButton = new JButton("D");
    private JButton pervButton = new JButton("上一题");
    private JButton sureButton = new JButton("提交");
    private JButton nextButton = new JButton("下一题");


    public ExamFrame (){
        this.init();
    }

    public ExamFrame(String title){
        super(title);
        this.init();
    }

    //组件设置
    @Override
    protected void setFontAndSoOn() {
        //面板初始化
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.lightGray);
        messagePanel.setLayout(null);
        messagePanel.setBounds(630,15,370,605);
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(15,450,605,170);
        //主面板
        examScroll.setBounds(15,15,605,425);
        examArea.setFont(new Font("黑体",Font.BOLD,30));
        examArea.setEnabled(false);
        this.showQuestion();
        //信息面板组件
        pictureLabel.setBounds(15,13,340,300);
        pictureLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray));

        nowQuestionLabel.setBounds(65,330,150,30);
        nowQuestionLabel.setFont(new Font("黑体",Font.BOLD,20));

        allQuestionLabel.setBounds(65,370,150,30);
        allQuestionLabel.setFont(new Font("黑体",Font.BOLD,20));
        answerLabel.setBounds(65,420,150,30);
        answerLabel.setFont(new Font("黑体",Font.BOLD,20));
        unanswerLabel.setBounds(65,470,150,30);
        unanswerLabel.setFont(new Font("黑体",Font.BOLD,20));
        timeLabel.setBounds(110,520,150,30);
        timeLabel.setFont(new Font("黑体",Font.BOLD,20));

        timeLabel.setForeground(Color.BLUE);

        nowQuestionField.setBounds(190,330,90,30);
        nowQuestionField.setHorizontalAlignment(0);
        nowQuestionField.setText(nowNum+1+"");
        nowQuestionField.setEnabled(false);
        nowQuestionField.setFont(new Font("黑体",Font.BOLD,20));
        allQuestionField.setBounds(190,370,90,30);
        allQuestionField.setHorizontalAlignment(0);
        allQuestionField.setEnabled(false);
        allQuestionField.setText(allQuestionNum+"");
        allQuestionField.setFont(new Font("黑体",Font.BOLD,20));
        answerField.setBounds(190,420,90,30);
        answerField.setHorizontalAlignment(0);
        answerField.setEnabled(false);
        answerField.setText(answerNum+"");
        answerField.setFont(new Font("黑体",Font.BOLD,20));
        unanswerField.setBounds(190,470,90,30);
        unanswerField.setHorizontalAlignment(0);
        unanswerField.setEnabled(false);
        unanswerField.setText(unanswerNum+"");
        unanswerField.setFont(new Font("黑体",Font.BOLD,20));
        realTimeLabel.setBounds(130,550,180,30);

        realTimeLabel.setForeground(Color.BLUE);
        realTimeLabel.setFont(new Font("黑体",Font.BOLD,20));
        //按钮面板
        aButton.setBounds(30,30,100,50);
        bButton.setBounds(170,30,100,50);
        cButton.setBounds(320,30,100,50);
        dButton.setBounds(470,30,100,50);
        pervButton.setBounds(30,100,100,50);
        sureButton.setBounds(250,100,100,50);
        sureButton.setForeground(Color.red);
        nextButton.setBounds(470,100,100,50);
        //给按钮绑定 一个课变化的 小手
        aButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pervButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sureButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void addElement() {
        //主面板

        mainPanel.add(examScroll);
        mainPanel.add(messagePanel);
        mainPanel.add(buttonPanel);
        //信息面板
        messagePanel.add(pictureLabel);
        messagePanel.add(nowQuestionLabel);
        messagePanel.add(allQuestionLabel);
        messagePanel.add(answerLabel);
        messagePanel.add(unanswerLabel);
        messagePanel.add(timeLabel);

        messagePanel.add(nowQuestionField);
        messagePanel.add(allQuestionField);
        messagePanel.add(answerField);
        messagePanel.add(unanswerField);
        messagePanel.add(realTimeLabel);
        //按钮面板
        buttonPanel.add(aButton);
        buttonPanel.add(bButton);
        buttonPanel.add(cButton);
        buttonPanel.add(dButton);
        buttonPanel.add(pervButton);
        buttonPanel.add(sureButton);
        buttonPanel.add(nextButton);
    }

    @Override
    protected void addListener() {

        //添加一个 选项按钮的 监听器
        ActionListener listenerButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //首先让四个按钮 全部清空颜色  设计一个方法
                ExamFrame.this.clearButtonColor();

                JButton jb = (JButton) e.getSource();//获取 被点击 按钮的对象

                jb.setBackground(Color.ORANGE); //给被点击的按钮添加一个颜色

                String answer = jb.getText();//获取 按钮的文字
                answers[nowNum] = answer;  //将答案存入数组中

            }
        };
        aButton.addActionListener(listenerButton); //将四个 选项按钮全部添加到监听器
        bButton.addActionListener(listenerButton);
        cButton.addActionListener(listenerButton);
        dButton.addActionListener(listenerButton);

        //再创建一个 监听器 用来绑定 下一题按钮
        ActionListener nextListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExamFrame.this.clearButtonColor();
                ExamFrame.this.pervButton.setEnabled(true);

                //设置右边 信息的值
                nowNum++;
                //ExamFrame.this.restoreColor();
                if(nowNum != allQuestionNum){ //说明还不是最后一道题
                    ExamFrame.this.showQuestion();
                    nowQuestionField.setText(nowNum+1 +"");
                }else{  //是最后一道题 让按钮失效 不能在点
                    examArea.setText("您已经做完了所有题目,请再检查过后,点击红色的提交按钮.");
                    //让按钮失效 设计一个方法
                    ExamFrame.this.closeButton();
                }
                answerField.setText(nowNum+"");
                unanswerField.setText(allQuestionNum-nowNum +"");
            }
        };
        nextButton.addActionListener(nextListener); //绑定下一题按钮

        //创建一个 上一题 按钮的监听器
        ActionListener pervListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExamFrame.this.setButton();
                ExamFrame.this.clearButtonColor();
                nowQuestionField.setText(nowNum+"");
                nowNum--;
                if(nowNum == 0){ //是第一题
                    ExamFrame.this.pervButton.setEnabled(false);
                }
                ExamFrame.this.showQuestion();
                ExamFrame.this.restoreColor();
                answerField.setText(nowNum +"");
                unanswerField.setText(allQuestionNum-nowNum +"");
            }
        };
        pervButton.addActionListener(pervListener);


        //添加一个 提交的监听器
        ActionListener returnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //2.弹出小窗口询问
                int value = JOptionPane.showConfirmDialog(ExamFrame.this,"请确认是否提交");
                if (value == 0) {  //0代表是 1 代表否 2代表取消
                    //1.倒计时停止
                    timeThread.stopTimeThread(false);
                    //2.按钮不可用
                    ExamFrame.this.closeButton();
                    pervButton.setEnabled(false);
                    //3.文本域展示 分数
                    ExamFrame.this.getResult();
                }

            }
        };
        sureButton.addActionListener(returnListener);


    }

    @Override
    protected void setFrameSelf() {
        this.setBounds(100,200,1020,670);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体大小不可拖拽
        this.setResizable(false);
        //设置窗体显示状态
        this.setVisible(true);
        this.add(mainPanel);

        timeThread.start();
    }


    //-----------------------------------------------------------
    //设计一个方法 用来展示一道题目
    private void showQuestion(){
        //从paper中获取当前的一道题目
        Question question = paper.get(nowNum);//三个属性 题干 答案 图片路径(有可能是null)
        //获取当前qustion中的图片路径
        String picture = question.getPath();//图片路径
        if(picture!=null){//有图片路径信息
            pictureLabel.setIcon(this.drawImage("src//picture//"+picture));
        }else{//没有图片信息
            pictureLabel.setIcon(null);
        }
        //处理一个题目中的标记 <br>表示换行
        examArea.setText((nowNum+1)+"."+question.getTitle().replace("<br>","\n   "));
    }

    //设计一个方法 清空选项按钮的颜色
    private void clearButtonColor (){
        aButton.setBackground(null);
        bButton.setBackground(null);
        cButton.setBackground(null);
        dButton.setBackground(null);
    }

    //设计一个方法  让选项按钮失效
    private void closeButton(){
        aButton.setEnabled(false);
        bButton.setEnabled(false);
        cButton.setEnabled(false);
        dButton.setEnabled(false);
        nextButton.setEnabled(false);
    }
    //设计一个方法  让选项按钮回复
    private void setButton(){
        aButton.setEnabled(true);
        bButton.setEnabled(true);
        cButton.setEnabled(true);
        dButton.setEnabled(true);
        nextButton.setEnabled(true);
    }
    //设计一个方法 用来处理图片展示
    private ImageIcon drawImage(String path){
        //通过给定的路径创建一个icon对象
        ImageIcon imageIcon = new ImageIcon(path);
        //设置imageIcon对象内的image属性
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(340,300,Image.SCALE_DEFAULT));
        //将设置好的imageIcon对象返回
        return imageIcon;
    }

    //设计一个方法 将选项的颜色恢复
    public void restoreColor(){
        String answer = answers[nowNum];
        if(answer ==null){
            return ;
        }
        switch (answer){
            case "A":
                aButton.setBackground(Color.ORANGE);
                break;
            case "B":
                bButton.setBackground(Color.ORANGE);
                break;
            case "C":
                cButton.setBackground(Color.ORANGE);
                break;
            case "D":
                dButton.setBackground(Color.ORANGE);
                break;
        }
    }
    //设计一个方法 用来处理成绩
    public void getResult(){
        Float result = 100.0f;
        int value = paper.size();
        for (int i = 0 ;i<value;i++) {
            String answer = paper.get(i).getAnswer();
            if (!answer.equals(answers[i])){
                result -= 100/value;
            }

        }
        examArea.setText("您的考试成绩为:\n\n\n\t\t"+result+"分");
    }

}
