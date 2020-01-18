public class Test {
    public static void main(String[] args){
        int[] array = new int[]{1,2,4,5,6,7,8,9,10,11,13};
        int[] x = sortArray(array);
        for (int value:x){
            System.out.println(value);
        }

    }
//二分法查找
    public static int binarySearch (int[] arr,int toFind){
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (arr[mid]<toFind){
                left = mid+1;
            }else if(arr[mid]>toFind){
                right = mid -1;
            }else{
                return mid;
            }
        }
        return -1;
    }
//冒泡排序
    /*
    public static int[] bubbleSort (int[] arr){
        for (int i = 0;i<arr.length-1;i++){
            for (int j = arr.length-1;j>i;j--){
                if (arr[j]>arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }
    */
    public static int[] bubbleSort (int[] arr){
        for (int i = 1;i<arr.length;i++){
            for (int j = arr.length-1;j>=i;j--){
                if (arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }

    //逆序排列数组元素
    public static int[] exchangeArray(int[] arr){
        int left = 0;
        int right = arr.length-1;
        for(int i=0;i<arr.length/2;i++){
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
        return arr;
    }
    //将一个数组内的奇数在前面 偶数在后面
    public static int[] sortArray (int[] arr){
        int left = 0;
        int right = arr.length-1;
        while (left <right){
            if (arr[left] %2 == 0){

            }else {
                left++;
                continue;
            }
            if (arr[right]%2 != 0){

            }else{
                right--;
                continue;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        return arr;
    }
}
