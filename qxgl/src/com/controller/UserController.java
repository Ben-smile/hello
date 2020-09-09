package com.controller;

import com.domain.Role;
import com.domain.User;
import com.service.RoleService;
import com.service.UserService;
import com.sun.deploy.net.HttpRequest;
import mymvc.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.*;
import orm.annotation.Insert;
import orm.annotation.Select;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionAttributes("loginUser")
public class UserController {
    private UserService service= UserService.getInstance();

    //登录
    @RequestMapping("login.do")
    public ModelAndView login(@Param("uname")String uname, @Param("upass")String upass){

        User user = service.checkLogin(uname,upass);

        if (user != null){
            //登录成功
            ModelAndView mv = new ModelAndView();
            mv.setViewName("main.jsp");
            mv.addAttribute("loginUser",user);
            return mv;
        }else {
            //登录失败
            ModelAndView mv = new ModelAndView();
            mv.setViewName("index.jsp");
            mv.addAttribute("flag","-1");
            return mv;
        }
    }

    //查询全表
    @RequestMapping("userList.do")
    public ModelAndView selectAllUser(){
        List<User> users = service.selectAllUser();
        ModelAndView mv = new ModelAndView();
        mv.addAttribute("users",users);
        mv.setViewName("users.jsp");
        return mv;
    }

    //新建用户
    @RequestMapping("createUser.do")
    public String createUser(User user){
        service.addUser(user);
        return "userList.do";
    }

    //删除用户
    @RequestMapping("deleteUser.do")
    public String delete(@Param("uno")String uno){
        Integer value = Integer.parseInt(uno);
        service.deleteUser(value);
        return "userList.do";
    }

    //查询一条记录 并跳转到修改页面
    @RequestMapping("selectUser.do")
    public ModelAndView select(@Param("uno")String uno){
        Integer value = Integer.parseInt(uno);
        User user = service.selectUser(value);
        ModelAndView mv = new ModelAndView();
        mv.addAttribute("user",user);
        mv.setViewName("updateUser.jsp");
        return mv;
    }

    //修改一条信息
    @RequestMapping("updateUser.do")
    public String update(User user){
        service.updateUser(user);
        return "userList.do";
    }

    //批量删除
    @RequestMapping("deleteUsers.do")
    public String deleteUsers(@Param("uno")String uno){
        String[] unos = uno.split(",");
        for (int i = 0;i<unos.length;i++){
            delete(unos[i]);
        }
        return "userList.do";
    }

    //批量导入excel文件中的用户信息
    @RequestMapping("addUsers.do")
    public String addUsers(HttpServletRequest request){
        try {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> list = upload.parseRequest(request);

            FileItem item = list.get(0);
            InputStream  input = item.getInputStream();
            //通过 poi 将字节流 重新转换成 Excel结构 获取Workbook对象
            Workbook book = WorkbookFactory.create(input);
            //获取第一个表
            Sheet sheet = book.getSheetAt(0);
            //循环表  getLastRowNum() 获取最后一行的索引
            for (int i = 1;i<=sheet.getLastRowNum();i++){
                //获取一行数据
                Row row = sheet.getRow(i);
                //如果这一行为空 就跳过
                if (row == null) continue ;
                //如果不是空 就获取每一个单元
                Cell c1 = row.getCell(0);
                Cell c2 = row.getCell(1);
                Cell c3 = row.getCell(2);
                Cell c4 = row.getCell(3);
                Cell c5 = row.getCell(4);
                Cell c6 = row.getCell(5);
                Cell c7 = row.getCell(6);
                Cell c8 = row.getCell(7);

                //获取每一个单元里面的数据
                String uname = c1.getStringCellValue();
                //只要Excel里面写的都是数字 就必须按照数字 来获取 而且都是浮点型
                String upass = (int)c2.getNumericCellValue()+"";
                String truename = c3.getStringCellValue();
                Integer age = (int)c4.getNumericCellValue();
                String sex = c5.getStringCellValue();
                String phone = (int)c6.getNumericCellValue()+"";
                String y11 = null;
                String y12 = null;
                if (c7 != null){
                    y11 = c7.getStringCellValue();
                }
                if (c8 != null){

                    y12 = c8.getStringCellValue();
                }

                User user = new User(null,uname,upass,truename,age,sex,phone,y11,y12);
                createUser(user);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "userList.do";
    }

    //下载模板
    @RequestMapping("downloadUserTemplate.do")
    @ResponseBody
    public void downloadUserTemplate(HttpServletResponse response) throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("files/users.xlsx");

        OutputStream out = response.getOutputStream();
        response.setHeader("content-Disposition","attachment;filename=users.xlsx");
        byte[] b = new byte[1024];
        int length = is.read(b);
        while (length != -1){
            out.write(b,0,length);
            length = is.read(b);
            out.flush();
        }
        out.close();
        is.close();
    }



}
