package view;

import util.BaseFrame;

import javax.swing.*;
import java.awt.*;

public class AtmFrame extends BaseFrame {


    public AtmFrame(String title){
        super(title);
        this.init();
    }

    //添加窗体上的组件
    private JPanel mainPanel = new JPanel();
    private JLabel logoLabel = new JLabel();//logo
    private JLabel titleLabel = new JLabel("保护伞银行");
    private JLabel balanceLabelCN = new JLabel("账户余额:￥"+100000000);
    private JLabel balanceLabelEN = new JLabel("Account Balance:￥"+100000000);
    private JLabel selectServerLabelCN = new JLabel("您好!请选择所需服务");
    private JLabel selectServerLabelEN = new JLabel("Please Select Service");
    private JButton messageButton = new JButton("个人信息");
    private JButton exitButton = new JButton("退出");
    private JButton inquireButton = new JButton("存款");
    private JButton withdrawalButton = new JButton("取款");
    private JButton transferButton = new JButton("转账");

    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);
        logoLabel.setBounds(20,20,100,80);
        logoLabel.setIcon(this.getIcon("src//img//2.jpg",80,80));
        titleLabel.setBounds(120,30,160,60);
        titleLabel.setFont(new Font("微软雅黑",Font.ITALIC,32));

        balanceLabelCN.setBounds(250,200,300,40);
        balanceLabelCN.setFont(new Font("微软雅黑",Font.BOLD,24));
        balanceLabelCN.setHorizontalAlignment(JTextField.CENTER);
        balanceLabelEN.setBounds(200,240,400,40);
        balanceLabelEN.setFont(new Font("微软雅黑",Font.BOLD,24));
        balanceLabelEN.setHorizontalAlignment(JTextField.CENTER);

        selectServerLabelCN.setBounds(250,370,300,40);
        selectServerLabelCN.setFont(new Font("微软雅黑",Font.BOLD,16));
        selectServerLabelCN.setHorizontalAlignment(JTextField.CENTER);
        selectServerLabelEN.setBounds(250,400,300,40);
        selectServerLabelEN.setFont(new Font("微软雅黑",Font.BOLD,16));
        selectServerLabelEN.setHorizontalAlignment(JTextField.CENTER);

        messageButton.setBounds(10,150,120,40);
        messageButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        messageButton.setBackground(Color.lightGray);
        messageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        exitButton.setBounds(10,390,120,40);
        exitButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        exitButton.setBackground(Color.lightGray);
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        inquireButton.setBounds(660,150,120,40);
        inquireButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        inquireButton.setBackground(Color.lightGray);
        inquireButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        withdrawalButton.setBounds(660,270,120,40);
        withdrawalButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        withdrawalButton.setBackground(Color.lightGray);
        withdrawalButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        transferButton.setBounds(660,390,120,40);
        transferButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        transferButton.setBackground(Color.lightGray);
        transferButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    protected void addElements() {
        mainPanel.add(logoLabel);
        mainPanel.add(titleLabel);
        mainPanel.add(balanceLabelCN);
        mainPanel.add(balanceLabelEN);
        mainPanel.add(selectServerLabelCN);
        mainPanel.add(selectServerLabelEN);
        mainPanel.add(messageButton);
        mainPanel.add(exitButton);
        mainPanel.add(inquireButton);
        mainPanel.add(withdrawalButton);
        mainPanel.add(transferButton);
        this.add(mainPanel);
    }
    protected void addListener() {

    }
    protected void setFrameSelf() {
        this.setBounds(300,200,800,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}
