package adapter;

public abstract class Adapter implements Box{
    //缺省适配器模式
    //有了box可以做统一的规则约束
    //每一个子类都实现同一个规则   用户使用起来很容易
    //如果按照上述的方式来实现   规则添加了新的方法   则所有的子类都跟着添加新的方法
    //所以创建一个抽象类 实现一部分暂时不用的接口
    public abstract int remove ();
    public abstract boolean add();
    public abstract int size ();
    public int get (){  //具体化
        throw new YiChang();//若子类想直接使用方法必须重写否则抛出自定义异常
    };
}
