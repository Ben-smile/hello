package runningman;

public class Person extends Thread{

    private String name;

    public Person (){

    }

    public Person (String name){
        this.name = name;
    }

    public void run(){
        for(int i= 1;i<=100;i++) {
            System.out.println(this.name + "跑到第"+i+"米了");
        }
    }
}
