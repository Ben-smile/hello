//���0-100֮�������
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int[] array = new int[50];
		for (int index = 0;index<50;index++){
			array[index] = 2*index+1;
		}
		for (int value:array){
			System.out.println(value);
		}
	}
}
*/
//������������a{1,2,3,4} b{5,6,7,8} ���������ڵ�Ԫ�ض�Ӧλ�û���
/*public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,4};
		int[] b = new int[]{5,6,7,8};
		int[] c = new int[4];
		c = b; 
		b = a;
		a = c;
		for (int value : a){
			System.out.println(value);
		}
		System.out.println("----------����һ�������ķָ��--------");
		for (int num : b){
			System.out.println(num);
		}
	}
}
*/
//����һ������a{1,2,3,4,5,6}  ������������Ԫ�ص�ƽ��ֵ
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,4,5,6};   //��������
		int sum = 0;   //����һ���͵ı���21
		int index=0;   //
		for (;index<6;index++){   
			int value = a[index];       //�ҵ������е�ÿ��Ԫ��
			sum = sum+value;          //��ÿ��Ԫ�����
		}
		double avg =(double) sum / index;      //��ƽ���� 
		System.out.println(avg); //3.5
		System.out.println(sum);//21
	}
}
*/
//����һ������a{1,2,3,4,5,6} ����������е�Ԫ��ͷβ��Ӧ����λ��
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,4,5,6};
		int c = a[0];
		int b = a[5];
		a[0] = b;
		a[5] = c;
		for (int num : a){
			System.out.println(num);
		}
	}
}
*/
//����һ������a{1,3,5,7,9,0,2,4,6,8} ��Ѱ�����е����ֵ����Сֵ(��ֵ����)
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,3,5,7,9,0,2,4,6,8};
		int maxValue = 0; 
		int minValue = 0;
		
		for (int index = 0;index<10;index++){
			
			if (a[index]>maxValue){
				maxValue = a[index];
			}
			if (a[index]<minValue){
				minValue = a[index];
			}
		//System.out.println(value);
		}
		System.out.println("���ֵΪ:"+maxValue);
		System.out.println("��СֵΪ:"+minValue);
	}
}
*/
//5.������������a{1,2,3}  b{4,5} �ϲ��������� (����һ���µ�����5����)
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3};
		int[] b = new int[]{4,5};
		int[] c = new int[5];
		for (int index= 0; index<3;index++){
			c[index]=a[index];
		}
		for (int index= 0; index<2;index++){
			c[index+3]=b[index];
		}
		//c[3] = b[0];
		//c[4] = b[1];
		for (int value : c){
			System.out.println(value);
		}
	}
}
*/
//6.����һ������a{1,2,3,9,4,5} ���������е����ֵλ�� �������ֳ�����{1,2,3} {4,5}



//7.����һ������a{1,2,3,0,0,4,5,0,6,0,7} ȥ�������е�0Ԫ�� (����һ�������� �̵� ����Ԫ��������)
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,0,0,4,5,0,6,0,7};
		int num = 0;
		int[] b = new int[7];
		for (int index= 0;index<11;index++){
			if (a[index] !=0){
				b[num]=a[index];
				num++;
			}
		}
		for (int value : b){
			System.out.println(value);
		}
	}
}
*/
//8.����һ������ �洢2-100֮�������(����)
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int num = 0;  
		int[] arr = new int[25];     //��������
		for (int a = 2;a <=100;a++){   
			boolean c = true;   //��ѭ���������
			for (int b = 2;b<=100;b++){
				if (a%b==0&&a!=b){     
					//System.out.println(a+"��������");
					c = false;
					break;
				}
			}
			if (c==true){
				arr[num]=a;
				num++;
			}	
		}
		for (int value : arr){
			System.out.println(value);
		}
	}
}
*/