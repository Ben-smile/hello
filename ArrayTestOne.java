���0-100֮�������
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
/*//������������a{1,2,3,4} b{5,6,7,8} ���������ڵ�Ԫ�ض�Ӧλ�û���
public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,4};
		int[] b = new int[]{5,6,7,8,9,0};
		int[] c = a;
		a = b;
		b = c;
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
		int[] a = new int[]{1,2,3,4,5,6,7,8,4,5,6,8,9};   //��������
		int sum = 0;   //����һ���͵ı���21
		int index=0;  
		for (;index<a.length;index++){   //�����ŵ��ٽ�ֵΪ����ĳ��� .length ���Ӹ�����
			int value = a[index];       //�ҵ������е�ÿ��Ԫ��
			sum +=value;          //��ÿ��Ԫ�����
		}
		double avg =(double) sum / index;      //��ƽ���� 
		System.out.println(avg); 
		System.out.println(sum);
	}
}
*/
//����һ������a{1,2,3,4,5,6} ����������е�Ԫ��ͷβ��Ӧ����λ��
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,4,5,6};
		for (int i =0;i<a.length/2;i++){    //�����ѭ�����������鳤�ȵ�һ��
			int temp = a[i];
			a[i] = a[(a.length-1)-i];
			a[(a.length-1)-i] = temp;
		}
		for (int c : a){
			System.out.println(c);
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
		int minValue = a[0];    //������Сֵ����ֱ�ӵ���0  ��������û��0Ԫ�� ����ʹ�����
		
		for (int index = 0;index<a.length;index++){
			
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
		int[] a = new int[]{1,2,3,6};
		int[] b = new int[]{4,5,8};
		int[] c = new int[a.length+b.length];
		for (int index= 0; index<a.length;index++){
			c[index]=a[index];
		}
		for (int index= 0; index<b.length;index++){
			c[index+a.length]=b[index];
		}
		for (int value : c){
			System.out.println(value);
		}
	}
}
*/
//6.����һ������a{1,2,3,9,4,5} ���������е����ֵλ�� �������ֳ�����{1,2,3} {4,5}

public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,9,4,5,4,6,8};
		int max = a[0];
		int num = 0;      //��¼���ֵ��λ��9
		for (int i = 1;i<a.length;i++){  //��Ϊѭ����1��ʼ����num��ֵ���ǵ�һ��������ĳ���
			if (a[i]>max){
				max = a[i];
				num++;
			}
		}
		int[] b = new int[num];        //�������ֵ��λ��ȷ����������ĳ���
		int[] c = new int[a.length-1-num];
		for (int index = 0; index < num;index++){     //�ֱ���������鸳ֵ
			b[index] = a[index];
		}  
		for (int index = 0;index<a.length-num-1;index++){
			c[index] = a[num+1+index];
		}
		for (int value :b){      //��� ����������
			System.out.println(value);
		}
		System.out.println("--------���ǻ����ķָ��-------");
		for (int temp :c){
			System.out.println(temp);
		}
	}
}


//7.����һ������a{1,2,3,0,0,4,5,0,6,0,7} ȥ�������е�0Ԫ�� (����һ�������� �̵� ����Ԫ��������)
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,0,0,4,5,0,6,0,7};
		int num = 0;                                 //����һ������ ��¼����Ԫ�صĸ���
		for (int index= 0;index<a.length;index++){ 
			if (a[index] !=0){
				num++;
			}
		}                                                    //������������з���Ԫ�صĸ���
		int[] b = new int[num];	//����������  ���鳤��Ϊ ������÷���Ԫ�صĸ���
		int numOne = 0;
		for (int index= 0;index<a.length;index++){ 
			if (a[index] !=0){
				b[numOne]=a[index]; //������Ԫ�ص�ֵ�����½�������
				numOne++;
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
				num++;
			}	
		}                                                       //�ҳ����������ĸ���
		int[] arr = new int[num];         	// ����һ������  ���鳤��Ϊ ������õ���������num
		int numOne = 0;
		for (int a = 2;a <=100;a++){   
			boolean c = true;
			for (int b = 2;b<=100;b++){
				if (a%b==0&&a!=b){     
					//System.out.println(a+"��������");
					c = false;
					break;
				}
			}
			if (c==true){
				arr[numOne]=a;    //�ҳ���������ֵ��������
				numOne++;
			}
		}
		for (int value : arr){
			System.out.println(value);
		}
	}
}
*/