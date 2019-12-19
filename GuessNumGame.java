import java.util.Random;

import java.util.Scanner;
public class GuessNumGame{
	public static void main(String[] args){
		int num = (int) (Math.random()*(5+1));
		System.out.println("请输入大/小");
		
		Scanner input = new Scanner(System.in);
		
		String result=input.nextLine();
		if ((result.equals("大") && num==4 || num ==5 || num == 6) || (result.equals("小") && num==1|| num ==2 || num == 3)){
				System.out.println("猜对啦");
		}else{
			System.out.println("猜错啦");
		}
	
		System.out.println("本次摇奖结果是:"+num);
		
	}
}