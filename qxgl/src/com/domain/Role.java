package com.domain;

import java.util.List;

public class Role {

    private Integer rno;
    private String rname;
    private String description;

    private String y11;
    private String y12;

    private List<User> users;
    private List<Menu> menus;

    public Role() {
    }

    public Role(Integer rno, String rname, String description, String y11, String y12) {
        this.rno = rno;
        this.rname = rname;
        this.description = description;
        this.y11 = y11;
        this.y12 = y12;
    }

    public Integer getRno() {
        return rno;
    }

    public void setRno(Integer rno) {
        this.rno = rno;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getY11() {
        return y11;
    }

    public void setY11(String y11) {
        this.y11 = y11;
    }

    public String getY12() {
        return y12;
    }

    public void setY12(String y12) {
        this.y12 = y12;
    }
}
