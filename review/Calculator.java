import java.util.Scanner;

public class Calculator {     //计算器  类
    public float subtract (float one,float two){ //减
        return one - two;
    }
    public float add (float one,float two){  //加
        return one + two;
    }
    public float multiply (float one,float two){  //乘
        return one * two;
    }
    public float divide (float one,float two) {  //除
        return one / two;
    }

    public void calculate (){
        Scanner input = new Scanner(System.in);   //创建一个Scanner对象
        System.out.println("请输入数字");
        String one = input.nextLine();
        float a = Float.parseFloat(one);     // 利用包装类 将String 转化成float
        while(true) {                       //利用 while 做一个死循环
            System.out.println("请输入符号");
            String symbol = input.nextLine();
            if (symbol.equals("=")){     //如果符号为 =  则中断循环
                System.out.println("执行完毕");
                break;
            }
            //  加上判断 增强程序的健壮性
            if(!(symbol.equals("+")||symbol.equals("-")||symbol.equals("*")||symbol.equals("/"))){
                System.out.println("输入有误 请输入[+ - * /]中的一个");
                continue;
            }
            System.out.println("请输入数字");
            String two = input.nextLine();
            float b = Float.parseFloat(two);
            switch (symbol) {   //根据 符号调用不同的计算方法
                case "+":
                    a = this.add(a, b);     //将每次计算的值 再次的存入 a 中,保证第二次
                                            // 计算的第一个值 是上次的算的结果
                    break;
                case "-":
                    a = this.subtract(a, b);
                    break;
                case "*":
                    a = this.multiply(a, b);
                    break;
                case "/":
                    a = this.divide(a, b);
                    break;
            }
            System.out.println(a);   //打印 每一次计算的结果
        }
    }



}
