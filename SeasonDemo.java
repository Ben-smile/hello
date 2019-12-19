import java.util.Scanner;
public class SeasonDemo{
		public static void main(String[] args){
			System.out.println("请输入您想知道的季节的月份:");
			Scanner input = new Scanner(System.in);
			int month = input.nextInt();
			if (month == 3 || month == 4|| month ==5){
				System.out.println("春季");
			}else if(month == 6 || month == 7|| month ==8){
				System.out.println("夏季");
			}else if(month == 9 || month == 10|| month ==11){
				System.out.println("秋季");
			}else if(month == 12 || month == 1|| month ==2){
				System.out.println("冬季");
			}else {
				System.out.println("你是外星人吧");
			}
		}
}