package view;

import util.BaseFrame;

import javax.swing.*;
import java.awt.*;

public class ExamFrame extends BaseFrame {

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

    private JTextField nowQuestionField = new JTextField("0");//展示
    private JTextField allQuestionField = new JTextField("0");
    private JTextField answerField = new JTextField("0");
    private JTextField unanswerField = new JTextField("0");
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
        nowQuestionField.setEnabled(false);
        nowQuestionField.setFont(new Font("黑体",Font.BOLD,20));
        allQuestionField.setBounds(190,370,90,30);
        allQuestionField.setHorizontalAlignment(0);
        allQuestionField.setEnabled(false);
        allQuestionField.setFont(new Font("黑体",Font.BOLD,20));
        answerField.setBounds(190,420,90,30);
        answerField.setHorizontalAlignment(0);
        answerField.setEnabled(false);
        answerField.setFont(new Font("黑体",Font.BOLD,20));
        unanswerField.setBounds(190,470,90,30);
        unanswerField.setHorizontalAlignment(0);
        unanswerField.setEnabled(false);
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
        nextButton.setBounds(470,100,100,50);
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
    }
}
