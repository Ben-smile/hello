public class ArrayTest{
	public static void main(String[] args){
		int[] array = new int[50];                         //输出 100内的偶数
		for (int index = 0;index<array.length;index++){
			array[index]=2*index+2;
		}
		for (int num:array){
			System.out.println(num);
		}
		
		/*
		for (int value:array){                                     //普通for
			System.out.println(value);	
		}
		System.out.println("----------我是一条华丽的分割符------------");
		for (int index = 0;index<5;index++){         //加强for
			int value = array[index];
			System.out.println(value);
		}
		*/
	}
}