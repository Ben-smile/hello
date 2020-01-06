public class TwoArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4}, {3, 2, 4}, {7, 8}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int value = arr[i][j];
                System.out.print(value+"\t");
            }
            System.out.println();
        }
        System.out.println("--------我是一条华丽的分割符-----");
        for (int[]array:arr){
            for (int num:array){
                System.out.print(num+"\t");
            }
            System.out.println();
        }

    }
}
