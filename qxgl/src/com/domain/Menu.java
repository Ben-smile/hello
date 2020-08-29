package com.domain;

import java.util.List;

public class Menu {
    private Integer mno;
    private String mname;
    private String mhref;
    private String mtarget;
    private Menu parent;
    private String y11;
    private String y12;

    private List<Role> roles;

    public Menu() {
    }

    public Menu(Integer mno, String mname, String mhref, String mtarget, Menu parent, String y11, String y12) {
        this.mno = mno;
        this.mname = mname;
        this.mhref = mhref;
        this.mtarget = mtarget;
        this.parent = parent;
        this.y11 = y11;
        this.y12 = y12;
    }


    public Integer getMno() {
        return mno;
    }

    public void setMno(Integer mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMhref() {
        return mhref;
    }

    public void setMhref(String mhref) {
        this.mhref = mhref;
    }

    public String getMtarget() {
        return mtarget;
    }

    public void setMtarget(String mtarget) {
        this.mtarget = mtarget;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
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
