package util;

import javax.swing.*;
import java.awt.*;


public abstract class BaseFrame extends JFrame { //继承JFrame 从而使这个类成为窗体

    //模板模式  用来规范画窗口的流程

    //this不是 表示当前类的对象 而是表示 调用这个方法时的对象
    protected void init(){   //设计一个具体的方法 用来控制 方法执行顺序
        this.setFontAndSoOn(); //先设置字体等
        this.addElements(); //添加组件到面板
        this.addListener();//添加事件监听器
        this.setFrameSelf(); //设置窗体本身(大小 是否可改变大小 点×关闭程序  展示窗体)
    }

    public BaseFrame() {

    }
    public BaseFrame(String title) {
        super(title);

    }


    //设计一个方法用来 处理图片 返回Icon对象
    protected ImageIcon getIcon(String path,int width,int height){
        //通过path  来创建imageIcon 对象 此时对象里面为空
        ImageIcon imageIcon = new ImageIcon(path);
        //设置icon对象内的image对象信息
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT));
        //将icon对象返回
        return imageIcon;
    }

    //1. 设置字体及颜色等
    protected abstract void setFontAndSoOn();


    //2.添加组件
    protected abstract void addElements();

    //3.添加事件监听器

    protected abstract void addListener();


    //4.设置窗体本身

    protected abstract void setFrameSelf();
}
