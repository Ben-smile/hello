package adapter;

public class Test {

    public static int binarySearch (int[] arr,int toFind){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left + right)>>1;
            if (arr[mid]>toFind){
                left = mid +1;
            }else if(arr[mid]<toFind){
                right = mid -1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args){
//        BinarySearch b = new BinarySearch();
        int[] array = new int[]{1,2,3,4,5,6,7};
        int value = binarySearch(array,5);
        System.out.println(value);
    }
}
