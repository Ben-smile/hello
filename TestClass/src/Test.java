public class Test {
    public static void main(String[] args){
        Son s = new Son(4);
        //创建子类的对象之前会默认调用父类的构造方法 调用父类的构造方法之前会执行 父类的代码块
        //再调用子类的构造方法  而调用子类的构造方法之前会 先执行子类的代码块 再执行子类的构造方法
        //所以顺序为 父类的代码块 父类的构造方法 子类的代码块 子类的构造方法
        String a = s.name;
        int b = s.age;
        String c = s.sex;
        System.out.println(s.name + s. age +s.sex);
        s.sleep();
    }
}
