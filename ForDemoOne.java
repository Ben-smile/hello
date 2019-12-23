//操场上有一百多人 让他们排队 
//三个人一组多一个 四个人一组多两个 五个人一组多两个
//求 操场上 一共有多少人
public class ForDemoOne{
    public static void main(String[] args){
        for (int num = 100;num < 200;num++){
            if (num % 3 == 1&&num % 4 == 2&&num %5 ==2){
                System.out.println("操场上一共有:"+num+"人");
            }
        }
    }
}