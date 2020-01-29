package adapter;

public class Test extends Adapter{
    //现在子类可以自行挑选接口进行实现 不用实现所有的接口
    public  int remove (){
        return 1;
    };
    public  boolean add(){
        return true;
    };
    public  int size (){
        return 1;
    };


}
