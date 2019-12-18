import java.util.Scanner;
public class JudgeSeason{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("ÇëÊäÈëÒ»¸öÔÂ·İ");
		int month = input.nextInt();
		if(month==3){
			System.out.println("´º¼¾");		
		}else if(month==4){
			System.out.println("´º¼¾");
		}else if(month==5){
			System.out.println("´º¼¾");
		}else if(month==6){
			System.out.println("ÏÄ¼¾");
		}else if(month==7){
			System.out.println("ÏÄ¼¾");		
		}else if(month==8){
			System.out.println("ÏÄ¼¾");
		}else if(month==9){
			System.out.println("Çï¼¾");
		}else if(month==10){
			System.out.println("Çï¼¾");
		}else if(month==11){
			System.out.println("Çï¼¾");		
		}else if(month==12){
			System.out.println("¶¬¼¾");
		}else if(month==1){
			System.out.println("¶¬¼¾");
		}else if(month==2){
			System.out.println("¶¬¼¾");
		}else{
			System.out.println("Ã»ÓĞÕâ¸öÔÂ·İÅ¶");
		}
	}
}