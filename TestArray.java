//二分法查找
/*
public class TestArray{
	public static void main{
		int[] arr = {1,2,3,4,5,6};
		System.out.println(binarySearch(arr,5));
	}
}

public static int binarySearch(int[] arr,int toFind){
	int lelf = 0;
	int right = arr.length - 1;
	while (left <= right){
		int mid = (left + right)/2;
		if (toFind < arr[mid]){
			right = mid -1;
		}else if (toFind > arr[mid]){
			left = mid +1;
		}else {
			return mid;
		}
	}
	return -1;
}
*/

//二维数组
import java.util.Scanner;

public class ChangeGroup{
	public static void main(String[] args){
		//创建一个二维数组 用来表示班级里的每一列同学
		int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		Scanner input = new Scanner(System.in);
		System.out.println("请您输入一个周数,我来告诉您交换后的结果");
		int week = input.nextInt();//6
		for(int i=1;i<=week%4;i++){
			int[] x = array[0];
			array[0] = array[1];
			array[1] = array[2];
			array[2] = array[3];
			array[3] = x;
		}
		for(int[] arr:array){
			for(int v:arr){
				System.out.print(v+"\t");
			}
			System.out.println();
		}
	}
}