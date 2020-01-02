
//寻找三位数字的水仙花数 方法一
 public class ReviewTest1{
//     public static void main(String[] args) {
//         for (int a = 0 ; a <= 9;a++){
//             for (int b = 0; b <= 9;b++){
//                 for (int c = 1;c <= 9;c++)
//                     if (100*c +10*b+a == a*a*a+b*b*b+c*c*c){
//                         System.out.println("水仙花数是"+(100*c +10*b+a));
//                     }
//             }
//         }
//     }
// }

//方法二
// public class ReviewTest1{
//     public static void main(String[] args){
//         int num = 100;
//         for (;num<1000;num++){
//             int b = num/100;
//             int s = num/10%10;
//             int g = num%10;
//             if (b*b*b+s*s*s+g*g*g == num){
//                 System.out.println("三位数的水仙花数是:"+num);
//             }
//         }
//     }
// }
//使用 Math.pow(double a,double b)来计算
// public class ReviewTest1{
//     public static void main(String[] args){
//        //Math.pow(double a,double b);帮我们计算a的b次方
//         for ( int num = 100;num<1000;num++){
                            //百位                十位                    各位
//             if (Math.pow(num/100,3)+Math.pow(num/10%10,3)+Math.pow(num%10,3) == num){
//                 System.out.println("三位数的水仙花数是:"+num);
//             }
//         }
//     }
// }

