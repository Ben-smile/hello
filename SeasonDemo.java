import java.util.Scanner;
public class SeasonDemo{
		public static void main(String[] args){
			System.out.println("����������֪���ļ��ڵ��·�:");
			Scanner input = new Scanner(System.in);
			int month = input.nextInt();
			if (month == 3 || month == 4|| month ==5){
				System.out.println("����");
			}else if(month == 6 || month == 7|| month ==8){
				System.out.println("�ļ�");
			}else if(month == 9 || month == 10|| month ==11){
				System.out.println("�＾");
			}else if(month == 12 || month == 1|| month ==2){
				System.out.println("����");
			}else {
				System.out.println("���������˰�");
			}
		}
}