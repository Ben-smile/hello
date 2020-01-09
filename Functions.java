public class Functions {
    
//星星 倒直角三角
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
            for(int value : a){
                System.out.print(value+"\t");
            }
            System.out.println();
            for(int value : b){
                System.out.print(value+"\t");
            }
            System.out.println();
        }
        //交换一个数组中头尾的位置
        public void exchangeArray (int[] arr){
            int left = 0;
            int bound = arr.length-1;
            while (left < bound){
                int tmp = arr[left];
                arr[left] = arr[bound];
                arr[bound] = tmp;
                left++;
                bound--;
            }
        }
        //设计一个方法  求一个数组中的极值
        public int arrayExtreme(int[] arr,boolean x){
            int extremeValue = arr[0];
            for(int i = 1; i<arr.length-1;i++) {
                if (x && arr[i]>extremeValue) {
                    extremeValue = arr[i];
                }else if (!x && arr[i]<extremeValue){
                    extremeValue = arr[i];
                }
            }
            return extremeValue;
        }
        //设计一个方法 用来寻找给定的元素是否在数组中存在      待优化
        public String searchArray(int[] arr,int value){
            String a = "您输入的值没有";    //方法必须有返回值 若返回值在条件内 系统会默认条件不执行无返回值
            for (int i = 0;i<arr.length;i++){
                if (arr[i]==value){
                    return "您输入的值是有的";
                }
            }
            return a;
        }
        //设计一个方法 用来合并两个数组
        public int[] mergeArray (int[] a,int[] b){
            int[] sum = new int[a.length+b.length];
            for (int i = 0;i<a.length;i++){
                sum[i] = a[i];
            }
            for (int i = 0;i<b.length;i++){
                sum[a.length+i] = b[i];
            }
            return sum;
        }

        //设计一个方法  把一个数组按照最大值位置拆分成两个数组
        public int[][] splitArray (int[] arr) {
            int index = 0;
            int maxValue = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > maxValue) {
                    maxValue = arr[i];
                    index = i;
                }
            }
            int[] a = new int[index];
            int[] b = new int[arr.length - index - 1];
            for (int i = 0; i < index; i++) {
                a[i] = arr[i];
            }
            for (int i = 0; i < arr.length - index - 1; i++) {
                b[i] = arr[index + i + 1];
            }
            int[][] array = new int[][]{a, b};
            return array;
        }
        //设计一个方法 去除一个数组中的某一个元素
        public int[] removeElement (int[] arr,int value){
            int num = 0;
            for (int i = 0;i<arr.length;i++){
                if (arr[i] != value){
                    num++;
                }
            }
            int[] array = new int[num];
            int index = 0;
            for (int i =0;i<arr.length;i++){
                if (arr[i] != value){
                    array[index] = arr[i];
                    index++;
                }
            }
            return array;
        }

}


