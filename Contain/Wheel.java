package CarAndWheel;

public class Wheel {
    public String brand;
    public String type;
    public String color;
    public Wheel (){

    }
    public Wheel(String brand,String type,String color){
        this.brand = brand;
        this.type = type;
        this.color = color;
    }
    public void turn (){
        System.out.println("轮子转起来了");
    }
}
