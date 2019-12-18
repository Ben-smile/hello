import java.util.Scanner;

public class TestScores{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请您输入一个成绩");
		int score = input.nextInt();
		if(0<=score && score<60){
			System.out.println("不及格");
		}else if(60 <= score && score<= 70){
			System.out.println("及格");
		}else if(70 <= score  && score<= 80){
			System.out.println("中等");
		}else if(80 <= score  && score< 90){
			System.out.println("良好");
		}else if(90 <= score  && score< 100){
			System.out.println("优秀");
		}else if(score==100){
			System.out.println("满分");
		}else{
			System.out.println("数据错误");
		}
	}
}