package runningman;

public class Test {

    public static void main (String[] args){
        Person p = new Person("苟犇");
        Person p1 = new Person("董佳");
        Person p2 = new Person("张三");
        p.start();
        p1.start();
        p2.start();

    }
}
