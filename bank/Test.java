package bank;

public class Test {
    public static void main(String[] args){
        Bank bank = new Bank();
        Person p = new OldMan("长者");
        bank.profession(p);//银行欢迎长者进来办理业务

    }
}
