package circlearrayqueue;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
        while (true) {
            System.out.println("请选择你的操作");
            System.out.println("show");
            System.out.println("add");
            System.out.println("get");
            System.out.println("size");
            Scanner input = new Scanner(System.in);
            String value = input.nextLine();


            switch (value) {
                case "show":
                    queue.show();
                    break;
                case "add":
                    System.out.println("请输入你要存取的数字");
                    String number = input.nextLine();
                    queue.add(Integer.parseInt(number));
                    break;
                case "get":
                    queue.get();
                    break;
                case "size":
                    queue.size();
                    break;
                default:
                    break;
            }
        }
    }
}
