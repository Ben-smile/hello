
public class WhileTest{
	public static void main(String[] args){
		int h = 1;
		while (h<=4){   //��������
			int a = 1;   
			while (a<=4-h){   //��һ���ֿո�
      1
    12    1			System.out.print(" ");
  123    21			a++;
1234    321	 	}
  			int b = 1;            //�ڶ���������
			while (b<=h){
				System.out.print(b);
				b++;
			}
			int c = h-1;
			while (c>=1){    //������������
				System.out.print(c);
				c--;
}
			h++;
			System.out.println();  //����
}




/*   ��"*"��һ��������
		int h = 1;
		while (h<=4){   //��������
			int a = 1;   // ���ո�
			while (a<=4-h){
				System.out.print(" ");
				a++;
			}
			int b = 1;    // ������
			while (b<=2*h-1){
				System.out.print("*");
				b++;
			}
			h++;
			System.out.println();  //����
}
*/
 //һ��1020���� ÿ������һ���ٶ�����  �������������

/*		int num = 1020;
		int day = 0;
		while (num>0){
			num /= 2;    //ÿ����Ŀ����
			num -=2;     // ����
			day++;
			System.out.println("һ���ȥ����"+num+"������");	
}
		System.out.println("��Ҫ"+day+"��ſ�������");
*/
/*    ����������Ӧ��
		int hour = 0;
		int distance = 1000;
		while (distance > 0){
			distance -=7;
			distance -=18;
			hour++;
			System.out.println("һСʱ����"+distance+"km");
		}

		System.out.println("����"+hour+"Сʱ����������");

*/
	

/*
		int sum = 120;
		int hour = 0;
		for (;sum>0;hour++){
			sum += 18;
			sum -= 30;
			System.out.println("һ��Сʱ��ȥ����"+sum);
		}
		System.out.println("һ������"+hour+"Сʱ");


*/		


//ˮ��  �Ѿ�ʢ����  120  ������ˮ
//��һ�� ��ˮ��   ÿСʱ��18 ������ˮ   һ����ˮ��  ÿСʱ�� 30 ������ˮ
//  ����ˮ�� һ��  ��������Сʱ ˮ���Ÿɾ�



		/*
		int  sum = 125;
		int hour = 0;
		while (sum>0){
			sum +=18;
			sum -= 30;			
			hour++;
			System.out.println("��"+hour+"Сʱ��,����"+sum+"����ˮ");
		}
		System.out.println("��Ҫ"+hour+"Сʱ���ܷ���");
		*/
	}
}




