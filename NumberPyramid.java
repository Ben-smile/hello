import java.util.Scanner;

public class NumberPyramid{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你想要的行数:");
		int num = input.nextInt();
		for (int h = 1; h<=num ; h++){ //控制行数
			for(int a = 1; a<=num-h; a++){    //控制第一部分空格
				System.out.print(" ");
			}
			for (int a = 1; a<=h; a++){
				System.out.print(a);  //控制第二部分的数字
			}
			for(int a = h-1; a>=1 ;a--){
				System.out.print(a);   //控制第三部分的数字
			}
			System.out.println();                //换行
		}
	}
}
