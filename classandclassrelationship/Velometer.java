package classandclassrelationship;

public class Velometer {
    private int standardTime = 5;

    public void isOverSpeed (Car car){
        int carTime = 100/car.getSpeed();
        if (standardTime>carTime){
            System.out.println("超速了 警车追!!");
            PoliceCar pc = new PoliceCar(30);
            pc.chaseCar(car);
        }else{
            System.out.println("速度正常 一路顺风");
        }
    }
}
