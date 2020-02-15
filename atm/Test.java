package atm;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        ATMSevers as = new ATMSevers();
        System.out.println("欢迎进入ATM自助服务系统");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入账户名:");
        String name = input.nextLine();
        System.out.println("请输入密码:");
        String password = input.nextLine();
        System.out.println(as.login(name,password));
    }
}
