/* ��������Ϸ
import java.util.Scanner;
import java.util.Random;

public class Review{
  	public static void main(String[] args){
		Random random = new Random();
		int num = random.nextInt(5) +1;
		Scanner input = new Scanner(System.in);
		System.out.println("�����С Ѻ������");
		String a = input.nextLine();
		if ((a.equals("��")&&num>=4)||(a.equals("С")&&num<=3)){
			System.out.println("�¶��� ����һ��ôô��");
		}else if (!a.equals("��") && !a.equals("С")){
			System.out.println("��úò��в�");
		}else {
			System.out.println("�´��� ����һ���������");
		}
		System.out.println("����ҡ�������"+num);
	}
}
*/
//����1!+2!+3!+4!+5!

public class Review{
	public static void main(String[] args){
		int value = 0;
		for (int a = 2;a<=5;a++){
			int num = 1;
			for (int b= 1;b<=a;b++ ){
				num*=b;
			}
			value += num ;
		}
		System.out.println("�����"+value);
	}
}