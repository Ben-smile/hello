package util;

import domain.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class UserFileReader {

    //创建一个集合 作为缓存机制 一次将文件内容读取到集合中  提高性能
    private static HashMap<String, User> userBox = new HashMap<>();

    public static User getUser(String account){
        return userBox.get(account);
    }


    static{

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("src//datafile//User.txt");
            br = new BufferedReader(fr);
            String value = br.readLine();

            while(value != null){
                String[] values = value.split("-");
                userBox.put(values[0],new User(values[0],values[1]));
                value = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br!=null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
