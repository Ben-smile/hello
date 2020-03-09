package service;

import dao.CountryDao;

import java.util.ArrayList;
import java.util.HashMap;

public class CountryService {
    private CountryDao dao = new CountryDao();
    //2.

    public ArrayList<HashMap<String,String>> select2 (){
        return dao.selectNum2();

    }
}
