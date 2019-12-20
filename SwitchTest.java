import java.util.Scanner;
public class SwitchTest{
	public static void main(String[] args){
		System.out.println("请输入你想知道的星期的数字");
		Scanner input = new Scanner(System.in);
		int day = input.nextInt();
		switch (day){
		case 1 :
			System.out.println("monday");
			break;//可有可无
		case 2 :
			System.out.println("tuesday");
			break;
		case 3 :
			System.out.println("wednesday");
			break;
		case 4:
			System.out.println("thursday");
			break;
		case 5 :
			System.out.println("friday");
			break;
		case 6 :
			System.out.println("staturday");
			break;
		case 7 :
			System.out.println("sunday");
			break;
		default:
			System.out.println("数据有误");
		}
	}
}