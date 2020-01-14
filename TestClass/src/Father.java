public class Father {
    public String name = "爸爸";
    public int age = 40;
    public String sex = "男";
    {
        System.out.println("我是父类的代码块");
    }
    public Father (){
        System.out.println("我是父类无参数的 构造方法");
    }
    public void eat () {
        System.out.println("爸爸吃清淡的东西");
    }
    public void sleep (){
        this.eat();//this 代表 当前执行过程时方法被调用时的那个对象 此时的对象为s. 所以执行的是子类重写的eat方法
        System.out.println("爸爸睡觉比较早");
    }
}
