package server;

//出现的目的是为了定义一个规则
//  方法名字必须统一 服务器找寻的时候就方便啦
//  方法参数必须统一 request response
public abstract class HttpServlet {

    public abstract void service(HttpServletRequest request,HttpServletResponse response);
}
