输出0-100之间的奇数
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
/*//给定两个数组a{1,2,3,4} b{5,6,7,8} 将两个组内的元素对应位置互换
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
		int[] a = new int[]{1,2,3,4,5,6,7,8,4,5,6,8,9};   //创建数组
		int sum = 0;   //定义一个和的变量21
		int index=0;  
		for (;index<a.length;index++){   //索引号的临界值为数组的长度 .length 增加复用性
			int value = a[index];       //找到数组中的每个元素
			sum +=value;          //让每个元素相加
		}
		double avg =(double) sum / index;      //求平均数 
		System.out.println(avg); 
		System.out.println(sum);
	}
}
*/
//给定一个数组a{1,2,3,4,5,6} 将这个数组中的元素头尾对应互换位置
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,4,5,6};
		for (int i =0;i<a.length/2;i++){    //这里的循环次数是数组长度的一半
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
//给定一个数组a{1,3,5,7,9,0,2,4,6,8} 找寻数组中的最大值和最小值(极值问题)
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,3,5,7,9,0,2,4,6,8};
		int maxValue = 0; 
		int minValue = a[0];    //这里最小值不能直接等于0  若数组中没有0元素 输出就错误了
		
		for (int index = 0;index<a.length;index++){
			
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
//6.给定一个数组a{1,2,3,9,4,5} 按照数组中的最大值位置 将数组拆分成两个{1,2,3} {4,5}

public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,9,4,5,4,6,8};
		int max = a[0];
		int num = 0;      //记录最大值的位置9
		for (int i = 1;i<a.length;i++){  //因为循环从1开始所以num的值就是第一个新数组的长度
			if (a[i]>max){
				max = a[i];
				num++;
			}
		}
		int[] b = new int[num];        //根据最大值的位置确定两个数组的长度
		int[] c = new int[a.length-1-num];
		for (int index = 0; index < num;index++){     //分别给两个数组赋值
			b[index] = a[index];
		}  
		for (int index = 0;index<a.length-num-1;index++){
			c[index] = a[num+1+index];
		}
		for (int value :b){      //输出 两个新数组
			System.out.println(value);
		}
		System.out.println("--------我是华丽的分割符-------");
		for (int temp :c){
			System.out.println(temp);
		}
	}
}


//7.给定一个数组a{1,2,3,0,0,4,5,0,6,0,7} 去掉数组中的0元素 (创建一个新数组 短的 非零元素挑出来)
/*
public class ArrayTestOne{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3,0,0,4,5,0,6,0,7};
		int num = 0;                                 //创建一个变量 记录非零元素的个数
		for (int index= 0;index<a.length;index++){ 
			if (a[index] !=0){
				num++;
			}
		}                                                    //以上是求得所有非零元素的个数
		int[] b = new int[num];	//定义新数组  数组长度为 上面求得非零元素的个数
		int numOne = 0;
		for (int index= 0;index<a.length;index++){ 
			if (a[index] !=0){
				b[numOne]=a[index]; //将非零元素的值赋给新建的数组
				numOne++;
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
				num++;
			}	
		}                                                       //找出所有素数的个数
		int[] arr = new int[num];         	// 定义一个数组  数组长度为 上面求得的素数个数num
		int numOne = 0;
		for (int a = 2;a <=100;a++){   
			boolean c = true;
			for (int b = 2;b<=100;b++){
				if (a%b==0&&a!=b){     
					//System.out.println(a+"不是素数");
					c = false;
					break;
				}
			}
			if (c==true){
				arr[numOne]=a;    //找出素数并赋值给新数组
				numOne++;
			}
		}
		for (int value : arr){
			System.out.println(value);
		}
	}
}
*/