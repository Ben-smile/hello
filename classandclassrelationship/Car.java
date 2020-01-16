package classandclassrelationship;

public class Car {
      //小汽车的属性 速度
    private int speed;
     //创建构造方法
    public Car (int speed){
        this.speed = speed;
    }
    public Car (){}
    //创建方法 获取小汽车速度
    public int getSpeed (){
        return this.speed;
    }
}
