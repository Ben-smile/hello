import java.util.Scanner;

public class TestScores{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("��������һ���ɼ�");
		int score = input.nextInt();
		if(0<=score && score<60){
			System.out.println("������");
		}else if(60 <= score && score<= 70){
			System.out.println("����");
		}else if(70 <= score  && score<= 80){
			System.out.println("�е�");
		}else if(80 <= score  && score< 90){
			System.out.println("����");
		}else if(90 <= score  && score< 100){
			System.out.println("����");
		}else if(score==100){
			System.out.println("����");
		}else{
			System.out.println("���ݴ���");
		}
	}
}