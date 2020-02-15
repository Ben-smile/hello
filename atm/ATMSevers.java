package atm;

import java.io.*;
import java.util.HashMap;

public class ATMSevers {
    HashMap<String,User> users = new HashMap<>();
    //用来把文件中的数据加载到集合里 方便操作 提高性能
    {
        FileReader fr = null;
        BufferedReader bd = null;
        try {
            fr = new FileReader("src//atm//Users.txt");
            bd = new BufferedReader(fr);
            String user = bd.readLine();
            User u = new User(user.split("-")[0],user.split("-")[1],Float.parseFloat(user.split("-")[2]));
            users.put(u.getName(),u);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr != null) {
                    bd.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public String login (String name,String password){
        User realMsg = users.get(name);
        if (realMsg != null&& realMsg.getPassword().equals(password)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }
}
