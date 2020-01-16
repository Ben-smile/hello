package classandclassrelationship;

public class PoliceCar {
    //警车属性 速度
    private int speed;
    //创建构造方法
    public PoliceCar (int speed){
        this.speed = speed;
    }
    public PoliceCar (){}

    public void chaseCar(Car car){
        int carSpeed = car.getSpeed();
        if (carSpeed<speed){
            System.out.println("小样 跑了你了");
            int time = 100/(speed-carSpeed);
            System.out.println("花了"+time+"秒追上了");
        }else{
            System.out.println("算你跑得快 下次别让我逮到你");
        }
    }
}
