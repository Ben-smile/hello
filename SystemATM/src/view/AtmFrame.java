package view;

import service.AtmService;
import util.BaseFrame;
import util.MySpring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtmFrame extends BaseFrame {


    private AtmFrame(String name){
        super("保护伞银行");
        this.name = name;
        this.init();
    }
    private static AtmFrame af ;  //窗口单例
    public static AtmFrame getInstance(String name){
        if(af == null) {
            af = new AtmFrame(name);
        }
        return af;
    }
    private AtmService as = MySpring.getBean("service.AtmService");
    private String name;
    //添加窗体上的组件
    private JPanel mainPanel = new JPanel();
    private JLabel logoLabel = new JLabel();//logo
    private JLabel titleLabel = new JLabel("保护伞银行");
    private JLabel balanceLabelCN = new JLabel();
    private JLabel balanceLabelEN = new JLabel();
    private JLabel selectServerLabelCN = new JLabel("您好!请选择所需服务");
    private JLabel selectServerLabelEN = new JLabel("Please Select Service");
    private JButton deleteButton = new JButton("销户");
    private JButton exitButton = new JButton("退出");
    private JButton depositButton = new JButton("存款");
    private JButton withdrawalButton = new JButton("取款");
    private JButton transferButton = new JButton("转账");

    protected void setFontAndSoOn() {
        mainPanel.setLayout(null);
        logoLabel.setBounds(20,20,100,80);
        logoLabel.setIcon(this.getIcon("src//img//2.jpg",80,80));
        titleLabel.setBounds(120,30,200,60);
        titleLabel.setFont(new Font("微软雅黑",Font.ITALIC,32));

        balanceLabelCN.setBounds(250,200,300,40);
        balanceLabelCN.setFont(new Font("微软雅黑",Font.BOLD,24));
        balanceLabelCN.setHorizontalAlignment(JTextField.CENTER);
        balanceLabelCN.setText("账户余额:￥"+as.inquire(name));
        balanceLabelEN.setBounds(200,240,400,40);
        balanceLabelEN.setFont(new Font("微软雅黑",Font.BOLD,24));
        balanceLabelEN.setHorizontalAlignment(JTextField.CENTER);
        balanceLabelEN.setText("Account Balance:￥"+as.inquire(name));

        selectServerLabelCN.setBounds(250,370,300,40);
        selectServerLabelCN.setFont(new Font("微软雅黑",Font.BOLD,16));
        selectServerLabelCN.setHorizontalAlignment(JTextField.CENTER);
        selectServerLabelEN.setBounds(250,400,300,40);
        selectServerLabelEN.setFont(new Font("微软雅黑",Font.BOLD,16));
        selectServerLabelEN.setHorizontalAlignment(JTextField.CENTER);

        deleteButton.setBounds(10,150,120,40);
        deleteButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        deleteButton.setBackground(Color.lightGray);
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        exitButton.setBounds(10,390,120,40);
        exitButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        exitButton.setBackground(Color.lightGray);
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        depositButton.setBounds(660,150,120,40);
        depositButton.setFont(new Font("微软雅黑",Font.BOLD,14));
        depositButton.setBackground(Color.lightGray);
        depositButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

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
        mainPanel.add(deleteButton);
        mainPanel.add(exitButton);
        mainPanel.add(depositButton);
        mainPanel.add(withdrawalButton);
        mainPanel.add(transferButton);
        this.add(mainPanel);
    }
    protected void addListener() {
        //添加存款 按钮
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = JOptionPane.showInputDialog(AtmFrame.this,"请输入存款金额");

                if(value != null && !"".equals(value)){ //说名读取到了东西
                    try {
                        Float depositMoney = Float.parseFloat(value);  //如果转换没问题 说明是个数字
                        if(depositMoney <= 0){ //如果金额 <= 0 抛出异常 直接进去catch里面
                            throw new NumberFormatException();
                        }

                        //如果到这里没问题 说明输入是个正常数字
                        int count = as.deposit(name,depositMoney);
                        //再做进一步判断  若count==1 说明成功
                        if (count == 1){
                            JOptionPane.showMessageDialog(AtmFrame.this,"存款成功");
                            //此时更新 面板的余额
                            balanceLabelCN.setText("账户余额:￥"+as.inquire(name));
                            balanceLabelEN.setText("账户余额:￥"+as.inquire(name));
                        }else{ //若不是1  则说明出现其他问题
                            JOptionPane.showMessageDialog(AtmFrame.this,"存款失败");
                        }

                    }catch(NumberFormatException nfe){
                        //若捕获到NumberFormatException异常 则说明输入金额有误
                        JOptionPane.showMessageDialog(AtmFrame.this,"输入金额有误");

                    }
                }
            }
        });

        //添加取款 按钮
        withdrawalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = JOptionPane.showInputDialog(AtmFrame.this,"请输入取款金额");

                if(value != null && !"".equals(value)){ //说名读取到了东西
                    try {
                        Float withdrawalMoney = Float.parseFloat(value);  //如果转换没问题 说明是个数字
                        if(withdrawalMoney <= 0){ //如果金额 <= 0 抛出异常 直接进去catch里面
                            throw new NumberFormatException();
                        }

                        //如果到这里没问题 说明输入是个正常数字
                        int count = as.withdrawal(name,withdrawalMoney);
                        //再做进一步判断  若count==1 说明成功
                        if (count == 1){
                            JOptionPane.showMessageDialog(AtmFrame.this,"取款成功");
                            //此时更新 面板的余额
                            balanceLabelCN.setText("账户余额:￥"+as.inquire(name));
                            balanceLabelEN.setText("账户余额:￥"+as.inquire(name));
                        }else if(count == -1){  //-1 说明余额不足
                            JOptionPane.showMessageDialog(AtmFrame.this,"账户余额不足");
                        } else{ //若都不是  则说明出现其他问题
                            JOptionPane.showMessageDialog(AtmFrame.this,"存款失败");
                        }

                    }catch(NumberFormatException nfe){
                        //若捕获到NumberFormatException异常 则说明输入金额有误
                        JOptionPane.showMessageDialog(AtmFrame.this,"输入金额有误");

                    }
                }
            }
        });

        //添加 转账按钮
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String forAccount = JOptionPane.showInputDialog(AtmFrame.this,"请输入转账用户");
                if (forAccount != null && !"".equals(forAccount)){ //说明读到东西
                    if (as.isExist(forAccount)){ //说明数据库有这个人
                        String money = JOptionPane.showInputDialog(AtmFrame.this,"请输入转账金额");
                        try {
                            Float outMoney = Float.parseFloat(money);
                            if (outMoney <= 0){
                                throw new NumberFormatException();
                            }

                            //到这里 说明人名存在 并且 转账金额 合法

                            int count = as.transfer(name,forAccount,outMoney);
                            //因为此时 执行了两条操作 所以 count == 2 说明成功
                            if (count == 2){
                                JOptionPane.showMessageDialog(AtmFrame.this,"转账成功");
                                //更新 主面板余额
                                balanceLabelCN.setText("账户余额:￥"+as.inquire(name));
                                balanceLabelEN.setText("账户余额:￥"+as.inquire(name));
                            }else if (count == -1){ //余额不足
                                JOptionPane.showMessageDialog(AtmFrame.this,"账户余额不足");
                            }else{ //出现其他问题
                                JOptionPane.showMessageDialog(AtmFrame.this,"转账失败");
                            }
                        }catch (NumberFormatException nfe){
                            JOptionPane.showMessageDialog(AtmFrame.this,"输入金额有误");
                        }
                    }else{
                        JOptionPane.showMessageDialog(AtmFrame.this,"用户名不存在");
                    }

                }else{
                    JOptionPane.showMessageDialog(AtmFrame.this,"用户名不存在");
                }
            }
        });

        //添加 退出按钮
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //添加 销户 按钮
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = JOptionPane.showConfirmDialog(AtmFrame.this,"是否注销当前账户所有信息");
                if(value == 0){
                    int count = as.closeAccount(name);
                    if (count == 1){
                        JOptionPane.showMessageDialog(AtmFrame.this,"销户成功");
                        System.exit(0);
                    }else{
                        JOptionPane.showMessageDialog(AtmFrame.this,"销户失败");
                    }
                }
            }
        });

    }
    protected void setFrameSelf() {
        this.setBounds(300,200,800,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}
