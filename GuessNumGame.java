import java.util.Random;

import java.util.Scanner;
public class GuessNumGame{
	public static void main(String[] args){
		int num = (int) (Math.random()*(5+1));
		System.out.println("�������/С");
		
		Scanner input = new Scanner(System.in);
		
		String result=input.nextLine();
		if ((result.equals("��") && num==4 || num ==5 || num == 6) || (result.equals("С") && num==1|| num ==2 || num == 3)){
				System.out.println("�¶���");
		}else{
			System.out.println("�´���");
		}
	
		System.out.println("����ҡ�������:"+num);
		
	}
}