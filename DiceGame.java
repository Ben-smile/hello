import java.util.Scanner;
public class DiceGame{
	public static void main(String[] args){
		//1 模拟摇骰子的游戏,创建一个随机数.(1-6之间的整数)
		double result = Math.random();
		int number =(int) (result *6 + 1);
		// Math 创建的随机数的取值范围是[0.0,1.0) 而我们需要的数范围是1-6之间,所以我们可以给结果*6-->[0.0,6),强制转换成int类型此时能取到的值为0-5 再加上1 -->1-6

		//2. 让玩家猜测结果("大/小")
		
		System.out.println("押大押小 买定离手");
		Scanner input = new Scanner(System.in);
		String choose = input.nextLine();
		//3. 把创建的随机数结果和玩家的猜测结果作比较
		// 字符串之间不可以用 ==  来比较  可以用 "a".equals("b")  来比较		
		if( (choose.equals("大") && number >= 4) || (choose.equals("小") && number <= 3)){
			System.out.println("猜对了 给你一个么么哒");
			System.out.println("本次开奖的结果是:"+number); //   + 表示拼接  将字符串和数字拼接在一起
		} else if (!choose.equals("大") && !choose.equals("小")){

			System.out.println("输入有误, 请重新输入");
		}else {
			System.out.println("猜错了 给你一个大嘴巴子");
			System.out.println("本次开奖的结果是:"+number);
		}

	}
}