package CarAndWheel;

public class Car {
    public String brand;
    public String color;
    public String type;
    public Wheel wheel;
    public void showCar(){
        System.out.println("这是一辆"+brand+"牌的"+color+"颜色的"+type+"型号的汽车");
        System.out.println("车上搭载着"+wheel.brand+"型号的"+wheel.color+"颜色的"+wheel.type+"型号的轮子");
        wheel.turn();
    }
    public Car (){}
    public Car (String brand,String color,String type,Wheel wheel){
        this.brand = brand;
        this.color = color;
        this.type = type;
        this.wheel = wheel;
    }
}
