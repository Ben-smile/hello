import java.util.Scanner;
public class DiceGame{
	public static void main(String[] args){
		//1 ģ��ҡ���ӵ���Ϸ,����һ�������.(1-6֮�������)
		double result = Math.random();
		int number =(int) (result *6 + 1);
		// Math �������������ȡֵ��Χ��[0.0,1.0) ��������Ҫ������Χ��1-6֮��,�������ǿ��Ը����*6-->[0.0,6),ǿ��ת����int���ʹ�ʱ��ȡ����ֵΪ0-5 �ټ���1 -->1-6

		//2. ����Ҳ²���("��/С")
		
		System.out.println("Ѻ��ѺС ������");
		Scanner input = new Scanner(System.in);
		String choose = input.nextLine();
		//3. �Ѵ�����������������ҵĲ²������Ƚ�
		// �ַ���֮�䲻������ ==  ���Ƚ�  ������ "a".equals("b")  ���Ƚ�		
		if( (choose.equals("��") && number >= 4) || (choose.equals("С") && number <= 3)){
			System.out.println("�¶��� ����һ��ôô��");
			System.out.println("���ο����Ľ����:"+number); //   + ��ʾƴ��  ���ַ���������ƴ����һ��
		} else if (!choose.equals("��") && !choose.equals("С")){

			System.out.println("��������, ����������");
		}else {
			System.out.println("�´��� ����һ���������");
			System.out.println("���ο����Ľ����:"+number);
		}

	}
}