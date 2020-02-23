package domain;


//domain对象
public class User {
    private String account;
    private String password;

    public User (){}
    public User(String account,String password){
        this.account = account;
        this.password = password;
    }

    public String getAccount(){
        return account;
    }

    public String getPassword(){
        return password;
    }
}
