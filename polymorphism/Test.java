package polymorphism;

public class Test {
    public static void main(String[] args){
        Object o = new Teacher();
        Teacher t = (Teacher)o;
        String a = t.name;
        System.out.println(a);
        t.eat();
        t.sleep();
        t.hashCode();


    }
}
