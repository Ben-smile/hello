package classandclassrelationship;

public class Test {
    public static void main(String[] args){
        Car car = new Car(21);
        Velometer v = new Velometer();
        v.isOverSpeed(car);
    }
}
