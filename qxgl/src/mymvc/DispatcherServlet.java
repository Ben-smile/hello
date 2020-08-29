package mymvc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.net.URL;
import java.util.*;

public class  DispatcherServlet extends HttpServlet {

    //刚才我们发现 Controller类的个数减少了 每一个类中有好多方法
    //每一个Controller类中都需要写一个分发的流程
    //分发的流程固定的
    //将分发的流程统一提升出来 成为了这个类中的如下这个方法
    //原来只负责分发自己类中的方法 找寻起来很容易
    //类有好多个 每一个类中方法也有好多个
    //接收请求传递过来的信息   类是谁?  这个类中的哪个方法?

    //-------->>>>用来存放obj对象中的所有方法
    private Map<Object,Map<String,Method>> objectMethodMap = new HashMap();
    //-------->>>>用来存放Controller类的单个对象
    private Map<String,Object> objectMap = new HashMap();
    //用于启动服务器时，读取所有的类名并保存
    private Map<String,String> realNameMap = new HashMap();
    //用于存储请求的方法名与类名之间的关系
    private Map<String,String> methodWithRealNameMap = new HashMap();


    //加载配置文件信息
    private void loadPropertiesFile(){
        try {
            Properties pro = new Properties();
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ApplicationContext.properties");
            pro.load(inputStream);
            Enumeration en = pro.propertyNames();
            while(en.hasMoreElements()){
                String key = (String)en.nextElement();//请求名字
                String value = pro.getProperty(key);//真实类全名
                realNameMap.put(key,value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //设计一个方法 扫描注解
    private void scanAnnotation(){
        //获取scanPackage值
        String scanPackage = realNameMap.get("scanPackage");
        //如果不是空证明需要让框架扫描注解
        if(scanPackage!=null){
            //拆分需要扫描的包名
            String[] packageNames = scanPackage.split(",");
            //循环处理每一个包名
            for(String packageName : packageNames){
                //循环一次获取一个包路径
                URL url = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".","/"));
                if(url==null){
                   // System.out.println(packageName+"包不存在");
                    continue;//如包路径不存在，证明用户配置错误，继续下一个包
                }
                //根据URL获取包真实路径
                String packagePath = url.getPath();
                //根据包路径创建一个与包对应的File对象
                File packageFile = new File(packagePath);
                //获取packageFile的所有子文件(所有的class)   过滤一下文件类型
                File[] files = packageFile.listFiles(new FileFilter() {
                    public boolean accept(File file) {
                        if(file.isFile() && file.getName().endsWith("class")){
                            return true;
                        }
                        return false;
                    }
                });
                //遍历所有的子文件(所有的class)
                for(File file : files){
                    //每循环一次的一个file就是一个controller.class文件
                    //获取file名字
                    String fileNameWithEndFix = file.getName();
                    String fileName = fileNameWithEndFix.substring(0,fileNameWithEndFix.lastIndexOf("."));
                    //由于class文件名与类名一致，所以拼接处理类全名
                    String className = packageName+"."+fileName;
                    //反射获取Class 为了获取类上面的注解  将注解(请求名)和类名存在一起
                    try {
                        Class clazz = Class.forName(className);
                        RequestMapping classAnnotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
                        if(classAnnotation!=null){//类上有注解
                            realNameMap.put(classAnnotation.value(),className);
                        }else{//类上没有注解
                            //扫描类中的所有方法
                            Method[] methods = clazz.getDeclaredMethods();
                            //扫描每一个方法上面的注解
                            for(Method method : methods){
                                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                                if(methodAnnotation!=null){//方法上的注解和类名字的关系
                                    methodWithRealNameMap.put(methodAnnotation.value(),className);
                                }
                            }
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //第一次访问这个核心的时候，加载全部类名
    public void init(ServletConfig config){
        this.loadPropertiesFile();
        this.scanAnnotation();
    }

    //====================================================================================================

    //设计一个方法 解析URI
    private String parseToRequestContent(String uri){
        return uri.substring(uri.lastIndexOf("/")+1);
    }

    //设计一个方法 根据uri找寻对应的obj对象
    private Object findObject(String requestContent) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //通过请求的类名字 找到名字对应的Class
        //请求名字----找到一个类全名(配置文件--注解)
        String realControllerName = realNameMap.get(requestContent);
        if(realControllerName==null){
            //如果请求名字没有对应类名  证明请求的直接是个方法 则去另一个集合内找寻类名
            realControllerName = methodWithRealNameMap.get(requestContent);
            //若还没有 则找不到对应的资源
            if(realControllerName==null) {
                //404
                throw new ControllerNotFoundException(requestContent+"资源没有找到");
            }
        }
        Object obj = objectMap.get(requestContent);
        if(obj==null){
            Class clazz = Class.forName(realControllerName);
            obj = clazz.newInstance();
            objectMap.put(requestContent,obj);
            //---->>>>obj对象创建了  随之就加载obj中所有的方法
            Method[] methods = clazz.getDeclaredMethods();
            Map<String,Method> methodMap = new HashMap();//每一个methodMap存储 (方法名,方法对象) 好多方法存在一个大Map里
            for(Method method : methods){//遍历所有的方法
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if(methodAnnotation!=null){
                    methodMap.put(methodAnnotation.value(),method);
                }else {
                    methodMap.put(method.getName(),method);
                }
            }
            //将obj对象和methodMap存储在一起，便于以后寻找
            objectMethodMap.put(obj,methodMap);
        }
        return obj;
    }

    //设计一个方法 根据方法名找寻方法
    private Method findMethod(Object obj,String methodName) {
        Class clazz = obj.getClass();
        //现在我们找方法参数是随意的，随意的怎么找？索性都找到---将方法存起来
        //obj对象创建了  这个对象中的方法就可以加载了---->再写一个集合，用来存储对象中的所有方法
        //还是获取请求的方法-----从objectMethodMap中获取
        //先获取对象对应的那个方法集合
        Map<String,Method> methodMap = objectMethodMap.get(obj);
        Method method = methodMap.get(methodName);
        return method;
    }

    //设计一个方法 解析方法中所有的参数 做自动注入Dependency Injection
    private Object[] injectionParameters(Method method,HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //-------->>>>解析method中所有参数类型，做参数值的自动注入
        //获取method的所有参数对象
        Parameter[] parameters = method.getParameters();
        //这里最好做一个严谨判断，没有参数就不用分析了。。。
        //创建一个Object[]用于存放所有的参数值，最后交给method执行时使用
        Object[] finalParamValue = new Object[parameters.length];
        //遍历每一个参数对象
        for(int i=0;i<parameters.length;i++){
            Parameter parameter = parameters[i];
            //获取参数注解
            Param paramAnnotation = parameter.getAnnotation(Param.class);
            //如果有注解 是零散的参数值，如果没有注解 是对象类型或map类型
            if(paramAnnotation!=null){//零散的参数
                //System.out.println(paramAnnotation.value()+"参数处理");
                //目的是为了获取请求传递的参数信息(当然注解value与请求name必须一致)
                String requestValue = request.getParameter(paramAnnotation.value());
                if(requestValue!=null) {//证明根据注解信息 接受到了请求的参数 做注入
                    //获取参数类型
                    Class paramClazz = parameter.getType();
                    //分析参数类型
                    if(paramClazz==String.class){
                        finalParamValue[i] = new String(requestValue);
                    }else if(paramClazz==Integer.class || paramClazz==int.class){
                        finalParamValue[i] = new Integer(requestValue);
                    }else if(paramClazz==Float.class || paramClazz==float.class){
                        finalParamValue[i] = new Float(requestValue);
                    }else if(paramClazz==Double.class || paramClazz==double.class){
                        finalParamValue[i] = new Double(requestValue);
                    }//多个else 自己写吧
                }
            }else{//对象或map类型
                //获取参数类型
                Class paramClazz = parameter.getType();
                if(paramClazz.isArray()){//数组
                    //System.out.println("数组类型的参数");
                }else{//除了数组以外的引用类型
                    if(paramClazz==HttpServletRequest.class){
                        finalParamValue[i] = request;
                        //System.out.println("request对象处理");
                        continue;
                    }
                    if(paramClazz==HttpServletResponse.class){
                        finalParamValue[i] = response;
                        //System.out.println("response对象处理");
                        continue;
                    }
                    if(paramClazz==Map.class || paramClazz==List.class || paramClazz==Set.class || paramClazz==Enum.class){
                        //System.out.println("处理不了");continue;
                    }
                    //普通对象类型    创建一个参数类型的对象
                    Object paramObj = paramClazz.newInstance();
                    if(paramObj instanceof Map){
                        //造型成map
                        Map<String,String> paramMap = (Map<String,String>)paramObj;
                        Enumeration en = request.getParameterNames();
                        while(en.hasMoreElements()){
                            String key = (String)en.nextElement();
                            String value = request.getParameter(key);
                            paramMap.put(key,value);
                        }
                        finalParamValue[i] = paramMap;
                        //System.out.println("map集合处理");
                    }else if(paramObj instanceof Object){
                        Field[] fields = paramClazz.getDeclaredFields();//获取对象中的全部属性
                        for(Field field : fields){
                            field.setAccessible(true);
                            Class fieldType = field.getType();
                            Constructor fieldContructor = fieldType.getConstructor(String.class);
                            field.set(paramObj,fieldContructor.newInstance(request.getParameter(field.getName())));
                        }
                        finalParamValue[i] = paramObj;
                        //System.out.println("对象类型参数处理");
                    }else{
                        //我可处理不了。。。
                    }
                }
            }
        }
        return finalParamValue;
    }

    //设计一个方法 处理方法执行返回结果
    private void parseModelAndView(Object obj,ModelAndView mv,HttpServletRequest request){
        //获取mv中map集合
        HashMap<String,Object> mvMap = mv.getAttributeMap();
        //集合内元素遍历 存入request域内
        Iterator<String> it = mvMap.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            Object value = mvMap.get(key);
            request.setAttribute(key,value);
        }

        //获取obj上面的SessionAttributes注解
        //获取注解里面的信息 将信息对应的那些值存入session作用域内
        SessionAttributes sessionAttributesAnnotation = obj.getClass().getAnnotation(SessionAttributes.class);
        if(sessionAttributesAnnotation!=null) {
            String[] attributeNames = sessionAttributesAnnotation.value();
            if(attributeNames.length!=0) {
                HttpSession session = request.getSession();
                for (String attributeName : attributeNames) {
                    session.setAttribute(attributeName,mvMap.get(attributeName));
                }
            }
        }
    }
    //设计一个方法 处理转发和重定向
    private void handleResponseContent(String viewName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //-------->>>>处理响应信息问题
        if (!"".equals(viewName) && !"null".equals(viewName)) {
            String[] value = viewName.split(":");
            if (value.length == 1) {
                //System.out.println("正常转发");
                request.getRequestDispatcher(viewName).forward(request, response);
            } else {
                if (value[0].equals("redirect")) {
                   // System.out.println("正常重定向");
                    response.sendRedirect(value[1]);
                } else {
                    //404
                }
            }
        } else {
            //System.out.println("返回空信息");
        }
    }
    //设计一个方法 判断如何处理响应信息
    private void finalHandleResponse(Object obj,Method method,Object methodResult,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        if(methodResult!=null){//方法有返回值
            //解析方法返回结果
            if(methodResult instanceof ModelAndView){//ModelAndView情况
                ModelAndView mv = (ModelAndView)methodResult;
                this.parseModelAndView(obj,mv,request);
                //处理最终响应信息
                this.handleResponseContent(mv.getViewName(),request,response);
            }else if(methodResult instanceof String){//String情况

                //当作JSON形式处理
                ResponseBody responseBody = method.getAnnotation(ResponseBody.class);
                if(responseBody!=null) {
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().write((String)methodResult);

                }else {
                    String viewName = (String) methodResult;
                    //处理最终响应信息
                    this.handleResponseContent(viewName, request, response);
                }
            }else{
                //对象类型，暂时不考虑错误情况
                //JSONObject jsonObject = new JSONObject();
                //jsonObject.put("jsonObject", methodResult);
                String json = JSON.toJSONString(methodResult);
                response.setContentType("text/json;charset=utf-8");
                response.getWriter().write(json);
            }
        }else{//方法返回void

        }
    }

    //=======================================================================================
    //=======================================================================================
    //=======================================================================================

    //这个方法 负责处理所有的.do请求
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //接收请求的类名字
            String uri = request.getRequestURI();// 工程名/资源名.do
            //解析URI获取请求资源名
            String requestContent = this.parseToRequestContent(uri);
            //通过requestContent找寻obj对象
            Object obj = this.findObject(requestContent);
            //接收请求的参数
            String methodName = request.getParameter("method");
            if(methodName==null){
                methodName = requestContent;
            }
            //通过obj和methodName 找寻一个method
            Method method = this.findMethod(obj,methodName);
            //通过method获取注入的参数
            Object[] finalParamValue = this.injectionParameters(method,request,response);
            //执行方法
            Object methodResult = method.invoke(obj,finalParamValue);
            //处理返回值
            this.finalHandleResponse(obj,method,methodResult,request,response);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            //e.printStackTrace();
            throw new MethodNoParamException("方法里没有Param");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
