package systemtickets;

import jdk.nashorn.internal.objects.Global;

import java.util.Vector;

public class SystemTickets {

    private  Vector<Ticket> tickets = new Vector(); //单例模式 我们认为只有一个系统
    private static SystemTickets sys = new SystemTickets();
    public static SystemTickets getInstance (){
        return sys;
    }
    //相比于ArrayList 是线程安全的
    //不会出现 几个线程同时 取走一张票的情况
    {
        for (int i= 1; i<=100;i++){
            tickets.add(new Ticket("上海"+i,"西安"+i,(i%5+5)*50.0F)) ;
        }
    }

    public Ticket getTicket(){
        try {
            return tickets.remove(0);
        }catch (Exception e){
            return null;
        }
    }
}
