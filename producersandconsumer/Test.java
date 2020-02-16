package producersandconsumer;

public class Test {
    public static void main(String[] args){
        Warehouse warehouse =new Warehouse();
        Consumer consumer1 = new Consumer(warehouse);
        Consumer consumer2 = new Consumer(warehouse);
        Producer producer = new Producer(warehouse);
        //producer.setPriority(10);
        producer.start();
        consumer1.start();
        consumer2.start();



    }
}
