package service;

import dao.EmpDao;
import domain.Emp;

import java.util.ArrayList;

public class EmpService {

    private EmpDao dao = new EmpDao();

    //设计一个方法 用来获取页码对应的行索引

    public ArrayList<Emp> getRowIndex(int page){
        int rowIndex = 5*(page-1);

        return dao.selectLimit(rowIndex);
    }
}
