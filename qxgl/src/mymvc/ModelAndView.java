package mymvc;

import java.util.HashMap;

public class ModelAndView {

    private String viewName;
    private HashMap<String,Object> attributeMap = new HashMap();

    //以下两个方法用户使用
    public void setViewName(String viewName){
        this.viewName = viewName;
    }
    public void addAttribute(String key,Object value){
        attributeMap.put(key,value);
    }

    //以下方法框架使用
    String getViewName(){
        return this.viewName;
    }
    Object getAttribute(String key){
        return this.attributeMap.get(key);
    }
    HashMap<String,Object> getAttributeMap(){
        return this.attributeMap;
    }

}
