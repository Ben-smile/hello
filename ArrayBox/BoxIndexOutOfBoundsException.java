public class BoxIndexOutOfBoundsException extends RuntimeException{
    //想要描述一个类是异常  继承extends    泛化
    public BoxIndexOutOfBoundsException(){

    }
    public BoxIndexOutOfBoundsException (String msg){
        super (msg);  //msg 提供给父类
    }
}
