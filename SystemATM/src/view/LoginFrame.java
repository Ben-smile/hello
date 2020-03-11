package view;

import service.AtmService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends BaseFrame {

    public LoginFrame() {
        super("请登录");
        this.init();
    }
    private static LoginFrame lf ;  //窗口单例
    public static LoginFrame getInstance(){
        if(lf == null) {
            lf = new LoginFrame();
        }
        return lf;
    }

    private JPanel mainPanel = new JPanel();
    private JLabel logoLabel = new JLabel();//logo
    private JLabel titleLabel = new JLabel("欢迎进入保护伞系统");//title
    private JLabel accountLabel = new JLabel("请输入账号:");
    private JTextField accountField = new JTextField();//用来输入账号的文本框
    private JLabel passwordLabel = new JLabel("请输入密码:");
    private JPasswordField passwordField = new JPasswordField();//用来输入密码的密码框
    private JButton loginButton = new JButton("登 录");
    private JButton registButton = new JButton("注 册");

    //添加一个控制注册窗口的属性
    //private RegistFrame registFrame = null;

    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);//设置panel布局为自定义
        logoLabel.setBounds(110,40,40,40);
        logoLabel.setIcon(this.getIcon("src//img//2.jpg",40,40));
        titleLabel.setBounds(160,40,250,40);
        titleLabel.setFont(new Font("微软雅黑",Font.BOLD,24));
        accountLabel.setBounds(40,100,140,40);
        accountLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        accountField.setBounds(170,105,260,32);
        accountField.setFont(new Font("微软雅黑",Font.BOLD,20));
        passwordLabel.setBounds(40,150,140,40);
        passwordLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
        passwordField.setBounds(170,155,260,32);
        passwordField.setFont(new Font("微软雅黑",Font.BOLD,20));
        loginButton.setBounds(120,210,100,32);
        loginButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        loginButton.setBackground(Color.LIGHT_GRAY);
        registButton.setBounds(260,210,100,32);
        registButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        registButton.setBackground(Color.LIGHT_GRAY);
    }
    protected void addElements() {
        mainPanel.add(logoLabel);
        mainPanel.add(titleLabel);
        mainPanel.add(accountLabel);
        mainPanel.add(accountField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(registButton);
        this.add(mainPanel);
    }


    private RegistFrame rs = null;//一个注册窗口当属性
    protected void addListener() {
        //注册按钮
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (rs == null) {
                        rs = RegistFrame.getInstance();
                    }
                    //显示注册窗口
                    rs.setVisible(true);
                    //让登陆窗口隐藏
                    LoginFrame.this.setVisible(false);
                    //清除 注册窗口内的信息
                    rs.clean();
            }
        };
        registButton.addActionListener(listener);


        //登录按钮添加 事件监听器
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = accountField.getText();
                String password = new String(passwordField.getPassword());
                AtmService as = MySpring.getBean("service.AtmService");
                String result = as.login(account,password);
                if(result.equals("登录成功")) {
                    //显示 Atm窗口
                    AtmFrame.getInstance(account);//将用户名传入
                    //让登陆窗口隐藏
                    LoginFrame.this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(LoginFrame.this,result);
                    LoginFrame.this.clean();
                }
            }
        });
    }
    protected void setFrameSelf() {
        this.setBounds(400,200,500,320);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

//清除文本框中的信息 使用默认修饰权限 让 RegistFrame也可以调用
    void clean(){
        accountField.setText("");
        passwordField.setText("");

    }
}
