
public class WhileTest{
	public static void main(String[] args){
		int h = 1;
		while (h<=4){   //控制行数
			int a = 1;   
			while (a<=4-h){   //第一部分空格
      1
    12    1			System.out.print(" ");
  123    21			a++;
1234    321	 	}
  			int b = 1;            //第二部分数字
			while (b<=h){
				System.out.print(b);
				b++;
			}
			int c = h-1;
			while (c>=1){    //第三部分数字
				System.out.print(c);
				c--;
}
			h++;
			System.out.println();  //换行
}




/*   用"*"画一个金字塔
		int h = 1;
		while (h<=4){   //控制行数
			int a = 1;   // 画空格
			while (a<=4-h){
				System.out.print(" ");
				a++;
			}
			int b = 1;    // 画星星
			while (b<=2*h-1){
				System.out.print("*");
				b++;
			}
			h++;
			System.out.println();  //换行
}
*/
 //一共1020西瓜 每天卖掉一半再多两个  多少天可以卖完

/*		int num = 1020;
		int day = 0;
		while (num>0){
			num /= 2;    //每天数目除二
			num -=2;     // 减二
			day++;
			System.out.println("一天过去还有"+num+"个西瓜");	
}
		System.out.println("需要"+day+"天才可以卖完");
*/
/*    两人相遇的应用
		int hour = 0;
		int distance = 1000;
		while (distance > 0){
			distance -=7;
			distance -=18;
			hour++;
			System.out.println("一小时后还有"+distance+"km");
		}

		System.out.println("经过"+hour+"小时后两人相遇");

*/
	

/*
		int sum = 120;
		int hour = 0;
		for (;sum>0;hour++){
			sum += 18;
			sum -= 30;
			System.out.println("一个小时过去还有"+sum);
		}
		System.out.println("一共用了"+hour+"小时");


*/		


//水池  已经盛满了  120  立方的水
//有一个 进水管   每小时进18 立方的水   一个出水管  每小时出 30 立方的水
//  两个水管 一起开  经过多少小时 水会排干净



		/*
		int  sum = 125;
		int hour = 0;
		while (sum>0){
			sum +=18;
			sum -= 30;			
			hour++;
			System.out.println("第"+hour+"小时后,还有"+sum+"立方水");
		}
		System.out.println("需要"+hour+"小时才能放完");
		*/
	}
}




