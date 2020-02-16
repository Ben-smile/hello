package systemtickets;

public class Test {
    public static void main(String[] args){
        Window w1 = new Window("一号");
        Window w2 = new Window("二号");
        Window w3 = new Window("三号");
        Window w4 = new Window("四号");
        Window w5 = new Window("五号");

        w1.start();
        w3.start();
        w4.start();
        w5.start();
        w2.start();
    }
}
