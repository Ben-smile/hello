package ClassTestTwo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.addressing.WsaTubeHelper;

public class ComputerRoom {
    //机房和电脑是包含关系  电脑这个对象是机房的属性
    //创建电脑的数组
    private Computer[] computers = new Computer[5];

    //创建程序块 给五台电脑初始化
    {
        for (int i = 0;i< computers.length;i++){
            computers[i] = new Computer(i+1);//循环每次都新建一个电脑对象赋上编号
        }
    }

    //机房和学生是依赖关系  方法里用到学生这个对象
    public void welcomeStudent (Student student){
        String name = student.getName();
        System.out.println("欢迎"+name+"同学进入机房");
        for(int i =0;i<computers.length;i++) {  //每次找到一个关闭的电脑就开始使用
            if (!computers[i].isClose()){
                student.useComputer(computers[i]);
                break;
            }
        }
    }
}
