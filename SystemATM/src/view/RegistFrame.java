package view;

import service.AtmService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistFrame extends BaseFrame {

    //注册界面
    private RegistFrame(){
        super("注册窗口");
        this.init();
    }

    private static RegistFrame rs ;  //窗口单例
    public static RegistFrame getInstance(){
        if(rs == null) {
            rs = new RegistFrame();
        }
        return rs;
    }


    //添加一些组件的属性
    private JPanel mainPanel = new JPanel();
    private JLabel logoLabel = new JLabel();//logo
    private JLabel titleLabel = new JLabel("请 您 填 写 信 息");//title
    private JLabel accountLabel = new JLabel("请输入账号：");
    private JTextField accountField = new JTextField();//输入账号
    private JLabel passwordLabel = new JLabel("请输入密码：");
    private JTextField passwordField = new JTextField();
    private JLabel balanceLabel = new JLabel("请输入金额：");
    private JTextField balanceField = new JTextField();
    private JButton registButton = new JButton("注 册");
    private JButton resetButton = new JButton("重 置");
    private JButton backButton = new JButton("返 回");

    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);
        logoLabel.setBounds(135,40,40,40);
        logoLabel.setIcon(this.getIcon("src//img//duyi.jpg",40,40));
        titleLabel.setBounds(185,40,200,40);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD,24));
        accountLabel.setBounds(40,100,140,40);
        accountLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        accountField.setBounds(170,105,260,32);
        accountField.setFont(new Font("微软雅黑",Font.BOLD,20));
        passwordLabel.setBounds(40,150,140,40);
        passwordLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        passwordField.setBounds(170,155,260,32);
        passwordField.setFont(new Font("微软雅黑",Font.BOLD,20));
        balanceLabel.setBounds(40,200,140,40);
        balanceLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        balanceField.setBounds(170,205,260,32);
        balanceField.setFont(new Font("微软雅黑",Font.BOLD,20));
        registButton.setBounds(60,260,100,32);
        registButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        registButton.setBackground(Color.LIGHT_GRAY);
        resetButton.setBounds(190,260,100,32);
        resetButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        resetButton.setBackground(Color.LIGHT_GRAY);
        backButton.setBounds(320,260,100,32);
        backButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        backButton.setBackground(Color.LIGHT_GRAY);
    }
    protected void addElements() {
        mainPanel.add(logoLabel);
        mainPanel.add(titleLabel);
        mainPanel.add(accountLabel);
        mainPanel.add(accountField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(balanceLabel);
        mainPanel.add(balanceField);
        mainPanel.add(registButton);
        mainPanel.add(resetButton);
        mainPanel.add(backButton);
        this.add(mainPanel);
    }
//---------------------------------
    private AtmService as = MySpring.getBean("service.AtmService");

    //设计一个方法 用来清空 注册窗口信息
     void clean(){
        accountField.setText("");
        passwordField.setText("");
        balanceField.setText("");
    }
    private LoginFrame lf = null;//一个登陆窗口 当属性
    protected void addListener() {
        registButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = accountField.getText();
                String password = passwordField.getText();
                String balance = balanceField.getText();
                //做一个新增的方法
                if(as.isExist(account)){
                    JOptionPane.showMessageDialog(RegistFrame.this,"用户名已存在");
                    RegistFrame.this.clean();
                }else{
                    try {
                        as.regist(account, password, Float.parseFloat(balance));
                        JOptionPane.showMessageDialog(RegistFrame.this, "注册成功");
                        //打开登录窗口
                        if (lf == null) {
                            lf = LoginFrame.getInstance();
                        }
                        lf.setVisible(true);
                        //隐藏注册窗口
                        RegistFrame.this.setVisible(false);
                        //清除登录窗口的信息
                        lf.clean();
                    }catch (NumberFormatException n){
                        JOptionPane.showMessageDialog(RegistFrame.this, "输入金额有误");
                        RegistFrame.this.clean();
                    }
                }

            }
        });


        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistFrame.this.clean();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //判断登录窗口是否为空
                if(lf == null){
                    lf = LoginFrame.getInstance();
                }
                //打开登录窗口
                lf.setVisible(true);
                //隐藏注册窗口
                RegistFrame.this.setVisible(false);
                //清除登录窗口的信息
                lf.clean();
            }
        });


    }
    protected void setFrameSelf() {
        this.setBounds(430,200,500,360);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }



}
