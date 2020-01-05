import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
       int[] arr = new int[]{9,3,2,5,4,6};
       //System.out.println(binarySearch(arr, 5));  //二分查找
        // System.out.println(avg(arr));     //求数组平均数
        bubbleSort(arr);     //冒泡排序
        System.out.println(Arrays.toString(arr));
    }

    public static int binarySearch(int[] arr ,int toFind){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left + right)/2;
            if (toFind < arr[mid]){
                right = mid -1;
            }else if(toFind > arr[mid]){
                left = mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static double avg(int[] arr){
        int sum = 0;
        for (int i = 0;i < arr.length;i++){
            sum += arr[i];
        }
        double avg =(double) sum/(arr.length);
        return avg;
    }

    public static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length;i++){
            for (int j = arr.length-1;j>i;j--){
                if (arr[j]<arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        return arr;
    }
}
