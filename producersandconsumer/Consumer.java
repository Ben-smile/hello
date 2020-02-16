package producersandconsumer;

public class Consumer extends Thread{
    //为了保证生产者消费者用同一个仓库  除了单例模式 还可以添加属性 不赋值

    private Warehouse warehouse;
    //添加构造方法  参数用Warehouse
    //再创建对象时 传warehouse对象 而且 和消费者必须传递同一个
    public Consumer (Warehouse warehouse){
        this.warehouse = warehouse;
    }

    public void run(){
        while(true) {

            warehouse.take();
            System.out.println("抱走了一个小萝莉");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
