/* 猜数字游戏
import java.util.Scanner;
import java.util.Random;

public class Review{
  	public static void main(String[] args){
		Random random = new Random();
		int num = random.nextInt(5) +1;
		Scanner input = new Scanner(System.in);
		System.out.println("买大买小 押定离手");
		String a = input.nextLine();
		if ((a.equals("大")&&num>=4)||(a.equals("小")&&num<=3)){
			System.out.println("猜对了 给你一个么么哒");
		}else if (!a.equals("大") && !a.equals("小")){
			System.out.println("你好好猜行不");
		}else {
			System.out.println("猜错了 给你一个大嘴巴子");
		}
		System.out.println("本次摇奖结果是"+num);
	}
}
*/
//计算1!+2!+3!+4!+5!

public class Review{
	public static void main(String[] args){
		int value = 0;
		for (int a = 2;a<=5;a++){
			int num = 1;
			for (int b= 1;b<=a;b++ ){
				num*=b;
			}
			value += num ;
		}
		System.out.println("结果是"+value);
	}
}