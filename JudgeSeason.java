import java.util.Scanner;
public class JudgeSeason{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("������һ���·�");
		int month = input.nextInt();
		if(month==3){
			System.out.println("����");		
		}else if(month==4){
			System.out.println("����");
		}else if(month==5){
			System.out.println("����");
		}else if(month==6){
			System.out.println("�ļ�");
		}else if(month==7){
			System.out.println("�ļ�");		
		}else if(month==8){
			System.out.println("�ļ�");
		}else if(month==9){
			System.out.println("�＾");
		}else if(month==10){
			System.out.println("�＾");
		}else if(month==11){
			System.out.println("�＾");		
		}else if(month==12){
			System.out.println("����");
		}else if(month==1){
			System.out.println("����");
		}else if(month==2){
			System.out.println("����");
		}else{
			System.out.println("û������·�Ŷ");
		}
	}
}