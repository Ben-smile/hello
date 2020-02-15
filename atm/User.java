package atm;

public class User {
    private String name;
    private String password;
    private Float balance;
    private long serialVersionUID = -45651561684L;

    public User (String name,String password,Float balance){
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public String getName (){
        return name;
    }

    public String getPassword (){
        return password;
    }

    public Float setBalance (Float value){
        return this.balance = value;
    }

    public Float getBalance(){
        return balance;
    }
}
