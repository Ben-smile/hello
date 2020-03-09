package domain;

public class Atm {
    private String aname;
    private String apassword;
    private Float abalance;
    public Atm (){}

    public Atm(String aname, String apassword, Float abalance) {
        this.aname = aname;
        this.apassword = apassword;
        this.abalance = abalance;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public void setAbalance(Float abalance) {
        this.abalance = abalance;
    }

    public String getAname() {
        return aname;
    }

    public String getApassword() {
        return apassword;
    }

    public Float getAbalance() {
        return abalance;
    }
}
