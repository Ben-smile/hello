import java.util.Scanner;
public class EnglishStudy1{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个数字");
		int day = input.nextInt();
		if (day==1){
			System.out.println("monday");
		}else if  (day==2){
			System.out.println("tuesday");
		}else if (day==3){
			System.out.println("wednesday");
		}else if(day==4){
			System.out.println("thursday");
		}else if(day==5){
			System.out.println("friday");
		}else if (day==6){
			System.out.println("statrday");	
		}else if(day==7){
			System.out.println("sunday");
			}else{
				System.out.println("Fuck you!!");
		} 
	}
}