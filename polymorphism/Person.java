package polymorphism;

public class Person extends Animal{
    public String name = "人类的名字";

    public void eat (){
        System.out.println("人类吃饭的方法");
    }

    public void sleep (){
        System.out.println("人类睡觉的方法");
    }
}
