import java.sql.SQLOutput;
import java.util.Scanner;

public class ArrayTest5 {
    public static void main(String[] args){
        String[] accountBox = new String[]{"张三","李四","王五"};
        int[] passwordBox = new int[]{123,666,999};
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名");
        String account = input.nextLine();
        System.out.println("请输入密码");
        int password = input.nextInt();
        boolean a = true;
        for (int i = 0;i<accountBox.length;i++){
            if (account.equals(accountBox[i])){
                if (password == passwordBox[i]){
                    System.out.println("登录成功");
                    a = false;
                }
                break;
            }
        }
        if (a){      //  a 是true  !a是 false
            System.out.println("用户名或密码错误");
        }

    }
}

