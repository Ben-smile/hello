package com.domain;

import java.util.List;

public class Menu {
    private Integer mno;
    private String mname;
    private String mhref;
    private String mtarget;
    private Integer pno;
    private String y11;
    private String y12;

    private List<Role> roles;

    public Menu() {
    }

    public Menu(Integer mno, String mname, String mhref, String mtarget, Integer pno, String y11, String y12) {
        this.mno = mno;
        this.mname = mname;
        this.mhref = mhref;
        this.mtarget = mtarget;
        this.pno = pno;
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

    public Integer getPno() {
        return pno;
    }

    public void setPno(Integer pno) {
        this.pno = pno;
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

    @Override
    public String toString() {
        return "Menu{" +
                "mno=" + mno +
                ", mname='" + mname + '\'' +
                ", mhref='" + mhref + '\'' +
                ", mtarget='" + mtarget + '\'' +
                ", pno=" + pno +
                ", y11='" + y11 + '\'' +
                ", y12='" + y12 + '\'' +
                ", roles=" + roles +
                '}';
    }
}
