package com.domain;

import java.util.List;

public class User {

    private Integer uno;
    private String uname;
    private String upass;
    private String truename;
    private Integer age;
    private String sex;
    private String phone;
    private String y11;
    private String y12;

    //实体类里面 用一个集合来表示 表之间的关系
    private List<Role> roles;

    public User() {
    }

    public User(Integer uno, String uname, String upass, String truename, Integer age, String sex, String phone, String y11, String y12) {
        this.uno = uno;
        this.uname = uname;
        this.upass = upass;
        this.truename = truename;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.y11 = y11;
        this.y12 = y12;
    }

    public Integer getUno() {
        return uno;
    }

    public void setUno(Integer uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        return "User{" +
                "uno=" + uno +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", turename='" + truename + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", y11='" + y11 + '\'' +
                ", y12='" + y12 + '\'' +
                ", roles=" + roles +
                '}';
    }
}
