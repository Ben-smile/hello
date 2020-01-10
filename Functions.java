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

        //设计一个方法 找寻一个区间的所有素数
    public int[] primeNum (int begin,int end){
        if (begin<=1||end <=1){    //判断区间  质数是指在大于1的自然数中，
            return null;            // 除了1和它本身以外不再有其他因数的自然数。
        }
        if (begin >= end){          //区间的开始必须小于结束
            return null;
        }
        int[] a = new int[begin+end];     //创建一个足够长的数组
        int index = 0;             //记录 素数的个数
        for (int i = begin; i<=end;i++){
            boolean x = true;
            for (int j = 2;j<=end;j++){
                if (i%j==0 && i!=j){
                    x = false;
                    break;
                }
            }
            if (x){               //若x标记没改变 则说明就是素数
                a[index] = i;
                index++;
            }
        }
        int[] array = new int[index]; 
        for (int i =0;i<array.length;i++){ // 去除足够长数组中的0元素
            array[i] = a[i];
        }
        a = null;
        return array;             //返回数组
    }

    //冒泡排序算法              待优化
    public int[] bubbleSort (int[] a){
        for (int i = 0;i<a.length-1;i++){
            for (int j = a.length-1;j>i;j--){
                if (a[j]<a[j-1]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
        return a;
    }

    //设计一个方法  做一个简单的登录验证
    public String logon (String name,String password) {
        String result = "用户名或密码错误";
        String[][] arr = new String[][]{{"张三","123"},{"李四","666"},{"王五","888"}};
        for (int i = 0;i<arr.length;i++){
            if (arr[i][0].equals(name)&&arr[i][1].equals(password)){
                result= "登录成功";
            }
        }
        return result;
    }
}


