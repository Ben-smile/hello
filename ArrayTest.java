public class ArrayTest{
	public static void main(String[] args){
		int[] array = new int[50];                         //��� 100�ڵ�ż��
		for (int index = 0;index<array.length;index++){
			array[index]=2*index+2;
		}
		for (int num:array){
			System.out.println(num);
		}
		
		/*
		for (int value:array){                                     //��ͨfor
			System.out.println(value);	
		}
		System.out.println("----------����һ�������ķָ��------------");
		for (int index = 0;index<5;index++){         //��ǿfor
			int value = array[index];
			System.out.println(value);
		}
		*/
	}
}