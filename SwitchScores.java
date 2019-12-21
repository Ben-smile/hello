import java.util.Scanner;

public class SwitchScores{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请您输入一个成绩");
		int score = input.nextInt();
		
		switch (score/10){
		case 1:
		case 3:
		case 4:
		case 5:
			System.out.println("不及格");
			break;
		case 6:
			System.out.println("及格");
			break;
		case 7:
			System.out.println("中等");
			break;
		case 8:
			System.out.println("良好");
			break;
		case 9:
			System.out.println("优秀");
			break;
		case 10:
			if (score==100){
				System.out.println("满分");
				break;
			}
			
		default :
			System.out.println("输入错误");	
		}

	}
}