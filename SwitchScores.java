import java.util.Scanner;

public class SwitchScores{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("��������һ���ɼ�");
		int score = input.nextInt();
		
		switch (score/10){
		case 1:
		case 3:
		case 4:
		case 5:
			System.out.println("������");
			break;
		case 6:
			System.out.println("����");
			break;
		case 7:
			System.out.println("�е�");
			break;
		case 8:
			System.out.println("����");
			break;
		case 9:
			System.out.println("����");
			break;
		case 10:
			if (score==100){
				System.out.println("����");
				break;
			}
			
		default :
			System.out.println("�������");	
		}

	}
}