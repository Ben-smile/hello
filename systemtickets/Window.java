package systemtickets;

public class Window extends Thread{
    private String name;
    public Window (){}
    public Window (String name){
        this.name = name;
    }
    public void run(){
        this.sell();
    }

    public void sell(){
        while (true){
            SystemTickets system = SystemTickets.getInstance();
            Ticket ticket = system.getTicket();
            if(ticket == null){
                System.out.println(name+"窗口的票已经卖完");
                break;
            }
            System.out.println(name+"窗口卖出了"+ticket);
        }
    }


}
