package server;

public class HttpServletResponse {
    //自己创建的一个对象
    //存储响应信息

    private StringBuilder responseContent = new StringBuilder();

    public void write(String str){
        this.responseContent.append(str);
    }

    public String getResponseContent(){
        return this.responseContent.toString();
    }
}
