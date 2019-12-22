import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    public static void main(String[] args) {
        Random random  = new Random();
        Scanner input = new Scanner(System.in);
        int num = random.nextInt(100);
        while (true){
            System.out.println("请输入你猜的数字");
            int num1 = input.nextInt();
            if (num1 < num){
                System.out.println("小了");
            }else if(num1 > num){
                System.out.println("大了");
            }else {
                System.out.println("猜对了");
                break;
            }
        }
    }
}