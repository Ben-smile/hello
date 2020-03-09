package domain;

public class Area {

    private Integer aid;
    private String aname;
    private Country country;

    public Area(Integer aid, String aName, Country country) {
        this.aid = aid;
        this.aname = aName;
        this.country = country;
    }
    public Area (){}

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public void getAname(String aName) {
        this.aname = aName;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getAid() {
        return aid;
    }

    public String getAname() {
        return aname;
    }

    public Country getCountry() {
        return country;
    }
}
