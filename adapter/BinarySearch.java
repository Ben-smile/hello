package adapter;

public class BinarySearch {

    public int binarySearch (int[] arr,int toFind){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left + right)>>1;
            if (arr[mid]>toFind){
                right = mid -1;
            }else if(arr[mid]<toFind){
                left = mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
