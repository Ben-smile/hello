public class Son extends Father{
    {
        System.out.println("我是子类的代码块");
    }
    public Son (){
        System.out.println("我是子类无参数的构造方法");
    }
    public Son (int a){
        this();
        System.out.println("我是子类int类型的构造方法");
    }
    public void eat (){
        System.out.println("儿子吃的口味重");
    }

}
