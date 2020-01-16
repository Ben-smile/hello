package ClassTestTwo;

public class Student {
    private String name;
    //创建一个人品的属性 利用随机数0-4表示人品差 5-9表示人品好
    private int RP = (int)(Math.random()*10);

    public Student (){}
    public Student (String name){
        this.name = name;

    }
    //创建一个 获得学生名字的方法
    public String getName (){
        return this.name;
    }
    //学生和电脑是依赖关系 学生使用电脑 电脑被使用
    public void useComputer (Computer computer){
        computer.beOpen(); //谁的方法谁来调用
        computer.beUsed();
        if (RP<5) {
            System.out.println("人品有问题 不关电脑 辣鸡");
        }else{
            computer.beOff();
        }
    }
}
