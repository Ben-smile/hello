package Ben.Test;

public class Person {  //Person 类
   //设计一个方法  画星星 倒直角三角
    public void drawStar(int line,boolean direction){
        for (int i = 1;i <= line;i++ ){
            if (!direction) {
                for (int j = 1; j <= i-1; j++) {
                    System.out.print(" ");
                }
            }
            for (int j = 0; j <= line - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    //交换两个数组中的元素
    public void changeArray (int[] a,int[] b){
        int[] tmp = new int[a.length];
        tmp = a;
        a =  b;
        b =  tmp;
    }
  //交换一个数组中头尾的位置
    public void exchangeArray (int[] arr){
        int left = 0;
        int bound = arr.length-1;
        while (left < bound){
            int tmp = arr[left];
            arr[left] = arr[arr.length-1];
            arr[arr.length-1] = tmp;
            left++;
            bound--;
        }
        for (int value : arr){
            System.out.print(value+"\t");
        }
    }


}
