
public class ArrayReview{
	//6.给定一个数组a{1,2,3,9,4,5} 按照数组中的最大值位置 将数组拆分成两个{1,2,3} {4,5}
	public static void main(String[] args){
		int[] oldArray = {1,2,3,90,4,5,6,90,4,5,6,7,8};
		//2.找寻最大值的索引位置
		int max = oldArray[0];//数组的第一个元素值
		int index = 0;//数组的第一个索引位置----(扩展需要一个数组用来记录所有最大值的索引位置)
		for(int i=1;i<oldArray.length;i++){
			if(oldArray[i]>max){
				max = oldArray[i];
				index = i;
			}
		}
		System.out.println("最大值为:"+max);
		System.out.println("最大值位置:"+index);
		//3.需要两个小数组分别承载元素
		int[] newa = new int[index];
		int[] newb = new int[oldArray.length-index-1];
		//4.分别将两个小数组填满
		for(int i=0;i<newa.length;i++){
			newa[i] = oldArray[i];
		}
		for(int i=0;i<newb.length;i++){
			newb[i] = oldArray[(index+1)+i];
		}
		//4.分别验证两个新数组 看一看
		for(int v:newa){
			System.out.println(v);
		}
		System.out.println("------");
		for(int v:newb){
			System.out.println(v);
		}
	}
}

//给定两个数组a{1,2,3}  b{4,5} 合并两个数组 (创建一个新的数组5长度)
public class ArrayReview{
	
	public static void main(String[] args){
		//1.创建两个数组
		int[] a = {1,2,3};
		int[] b = {4,5};
		//2.因为数组长度一旦确定 不能再次改变  需要创建一个新的数组
		int[] newArray = new int[a.length+b.length];//只有长度 元素默认值0
		//3.思路二:想要将新数组填满
		for(int i=0;i<newArray.length;i++){
			if(i<a.length){//新数组的索引位置还没有a数组长度以外的范围
				newArray[i] = a[i];
			}else{
				newArray[i] = b[i-a.length];
			}
		}
		//4.验证
		for(int v:newArray){
			System.out.println(v);
		}
	}
}

//2.给定一个数组a{1,2,3,4,5,6} 将这个数组中的元素头尾对应互换位置
public class ArrayReview{
	
	public static void main(String[] args){
		int[] array = {1,2,3,4};
		for(int i=0;i<array.length/2;i++){//控制交换的次数 数组长度的一半
			int x = array[i];
			array[i] = array[(array.length-1)-i];
			array[(array.length-1)-i] = x;
		}
		for(int v:array){
			System.out.println(v);
		}
	}
}

//给定一个数组a{1,3,5,7,9,0,2,4,6,8} 找寻数组中的最大值和最小值(极值问题)
public class ArrayReview{
	
	public static void main(String[] args){
		int[] a = {1,3,5,7,9,2,4,6,8};
		int min = a[0];
		int max = a[0];
		//寻找数组中的元素  与变量中的元素进行比较 
		for(int i=1;i<a.length;i++){
			if(a[i]<min){
				min = a[i];
			}
			if(a[i]>max){
				max = a[i];
			}
		}
		System.out.println("数组中的最小值为:"+min);
		System.out.println("数组中的最大值为:"+max);
	}
}