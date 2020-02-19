package testtimer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    private int count = 1;
    //属性  集合  存储所有人的电话号--账号
    private ArrayList<String> userBox = new ArrayList<String>();
    {
        userBox.add("a");userBox.add("b");userBox.add("d");userBox.add("d");
    }
    //设计一个方法  做点坏事儿   垃圾短信
    //  每隔一段时间  发送一些数据
    public void test() throws ParseException {
        System.out.println("开始~");
        Timer timer = new Timer();//启动一个小线程  做记录  每隔时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = sdf.parse("2020-2-19 16:50:20");
        timer.schedule(new TimerTask(){
            public void run() {

                for(int i=0;i<userBox.size();i++){
                    System.out.println("给"+userBox.get(i)+"发送了一条消息:[皮包皮带便宜卖了！！！]");
                }

            }
        },firstTime,3000);
    }

    public static void main(String[] args){
        try {
            TestTimer tt = new TestTimer();
            tt.test();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
