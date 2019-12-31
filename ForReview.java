import java.util.Scanner;

public class ForReview{
	public static void main(String[] args){
		for(int i=1;i<=4;i++){//控制四行
			//画占位符
			for(int j=1;j<=4-i;j++){
				System.out.print(" ");
			}
			//画星星
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			//换行
			System.out.println();
		}
		

		int count = 4;//每一行星星的个数随意
		for(int i=1;i<=4;i++){
			for(int j=1;j<=count;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		//复用性
		/*System.out.println("尊敬的客户,您到底要画几个?");
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		for(int i=1;i<=count;i++){
			System.out.print("*");
		}*/
	}
}

public class ForReview{
	public static void main(String[] args){
		//打印输出9*9乘法表
		//   j  + "*" +   i + "=" +     j*i
		//被乘数  *  乘数  =  乘积
		for(int i=1;i<=9;i++){//控制行数
			//画一个?
			for(int j=1;j<=i;j++){//控制每一行表达式的个数
				System.out.print(j+"*"+i+"="+(j*i)+"\t");
			}
			//换行
			System.out.println();
		}
	}
}