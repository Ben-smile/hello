package ClassTestTwo;

public class Computer {
    private boolean state = false; //电脑状态 true开机 false 关机
    private int num ; //电脑编号
    public Computer (){}
    public Computer (int num){
        this.num = num; //构造方法 给电脑编号赋值
    }

    public boolean isClose (){
        return this.state;
    }

    public void beOff (){
        this.state = false;
        System.out.println(num+"电脑被关机了");
    }
    public void beOpen (){
        this.state = true;
        System.out.println(num+"电脑被开机了");
    }
    public void beUsed (){
        System.out.println(num+"电脑正在被使用");
    }
}
