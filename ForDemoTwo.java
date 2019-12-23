// 甲乙丙丁四个人加工零件  加工零件的总数是 370个
// 如果甲加工的零件数多 10
// 乙加工的零件数 少20 
// 丙加工的零件数乘以2 
// 丁加工的零件数 除以2   则四个人加工的零件数就相等了   
// 求四个人 加工零件的个数分别是多少
// public class ForDemoTwo{
//     public static void main(String[] args){
//          for (int x = 1;x < 370;x++){
//              if (x-10+x+20+x/2+x*2 == 370){
//                  System.out.println("甲:"+(x-10));
//                  System.out.println("乙:"+(x+20));
//                  System.out.println("丙:"+(x/2));
//                  System.out.println("丁:"+(x*2));
//              }
//          }
//     }
// }

//鸡兔同笼 小鸡+小兔子=50  脚一共 160只  求
//小鸡和小兔子各多少只
// public class ForDemoTwo{
//     public static void main(String[] args) {
//         int a = 1;
        
//         for (; a<50 ;a++){
//             if (a*2+(50-a)*4 == 160){
//                 System.out.println("小鸡有"+a+"只");
//                 System.out.println("小兔子有"+(50-a)+"只");
//             }
//         }
//     }
// }

//寻找三位数字的水仙花数 方法一
// public class ForDemoTwo{
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
// public class ForDemoTwo{
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
// public class ForDemoTwo{
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


// public class ForDemoTwo{
//     public static void main(String[] args) {
//         for (int a = 1;a <= 9;a++){
//            for (int b= 1;b<= 9;b++){
//                 System.out.println("a:"+a+"b:"+b);
//            }
//         }
//     }
// }


// public class ForDemoTwo{
//     public static void main(String[] args) {
//         for (int a = 1; a<= 9;a++){
//             for (int b = 1; b<= 9;b++){
//                 System.out.println(a*b);
//             }
//         }
//     }
// }