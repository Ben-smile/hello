package domain;

import java.sql.Date;

public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Float sal;
    private Float comm;
    private Integer deptno;

    public Emp(Integer empno, String ename, String job, Integer mgr, Date hiredate, Float sal, Float comm, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public Emp() {}

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public void setSal(Float sal) {
        this.sal = sal;
    }

    public void setComm(Float comm) {
        this.comm = comm;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public String getJob() {
        return job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public Float getSal() {
        return sal;
    }

    public Float getComm() {
        return comm;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        sb.append(empno);
        sb.append("-");
        sb.append(ename);
        sb.append("-");
        sb.append(job);
        sb.append("-");
        sb.append(mgr);
        sb.append("-");
        sb.append(hiredate);
        sb.append("-");
        sb.append(sal);
        sb.append("-");
        sb.append(comm);
        sb.append("-");
        sb.append(deptno);
        sb.append("]");
        return sb.toString();
    }
}
