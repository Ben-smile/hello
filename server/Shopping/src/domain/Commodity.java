package domain;

public class Commodity {

    private Integer cid;
    private String cname;
    private Float cprice;
    private Kind kind;//外键

    public Commodity(){}
    public Commodity(Integer cid, String cname, Float cprice, Kind kind) {
        this.cid = cid;
        this.cname = cname;
        this.cprice = cprice;
        this.kind = kind;
    }

    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public Float getCprice() {
        return cprice;
    }
    public void setCprice(Float cprice) {
        this.cprice = cprice;
    }
    public Kind getKind() {
        return kind;
    }
    public void setKind(Kind kind) {
        this.kind = kind;
    }
}
