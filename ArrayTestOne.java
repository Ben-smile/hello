//输出0-100之间的奇数
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
//给定两个数组a{1,2,3,4} b{5,6,7,8} 将两个组内的元素对应位置互换
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
		System.out.println("----------我是一条华丽的分割符--------");
		for (int num : b){
			System.out.println(num);
		}
	}
}
*/
//给定一个数组a{1,2,3,4,5,6}  计算数组所有元素的平均值
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,4,5,6};   //创建数组
		int sum = 0;   //定义一个和的变量21
		int index=0;   //
		for (;index<6;index++){   
			int value = a[index];       //找到数组中的每个元素
			sum = sum+value;          //让每个元素相加
		}
		double avg =(double) sum / index;      //求平均数 
		System.out.println(avg); //3.5
		System.out.println(sum);//21
	}
}
*/
//给定一个数组a{1,2,3,4,5,6} 将这个数组中的元素头尾对应互换位置
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
//给定一个数组a{1,3,5,7,9,0,2,4,6,8} 找寻数组中的最大值和最小值(极值问题)
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
		System.out.println("最大值为:"+maxValue);
		System.out.println("最小值为:"+minValue);
	}
}
*/
//5.给定两个数组a{1,2,3}  b{4,5} 合并两个数组 (创建一个新的数组5长度)
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
//6.给定一个数组a{1,2,3,9,4,5} 按照数组中的最大值位置 将数组拆分成两个{1,2,3} {4,5}



//7.给定一个数组a{1,2,3,0,0,4,5,0,6,0,7} 去掉数组中的0元素 (创建一个新数组 短的 非零元素挑出来)
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
//8.创建一个数组 存储2-100之间的素数(质数)
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int num = 0;  
		int[] arr = new int[25];     //定义数组
		for (int a = 2;a <=100;a++){   
			boolean c = true;   //在循环中做标记
			for (int b = 2;b<=100;b++){
				if (a%b==0&&a!=b){     
					//System.out.println(a+"不是素数");
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