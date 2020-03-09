package domain;

public class Country {
    private Integer cid;
    private String cname;

    public Country(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }
    public Country (){}

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }
}
