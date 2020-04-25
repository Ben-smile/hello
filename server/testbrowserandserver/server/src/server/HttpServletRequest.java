package server;

import java.util.HashMap;

public class HttpServletRequest {
    //自己创建的一个类型
    //目的是为了存储  浏览器发送请求时携带的所有信息

    private String content;
    private HashMap<String,String> paramsMap;

    public HttpServletRequest() {}
    public HttpServletRequest(String content, HashMap<String, String> paramsMap) {
        this.content = content;
        this.paramsMap = paramsMap;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public HashMap<String, String> getParamsMap() {
        return paramsMap;
    }
    public void setParamsMap(HashMap<String, String> paramsMap) {
        this.paramsMap = paramsMap;
    }
}
