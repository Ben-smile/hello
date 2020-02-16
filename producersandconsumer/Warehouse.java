package producersandconsumer;

import java.util.ArrayList;

public class Warehouse {

    private ArrayList<String> arrayList = new ArrayList<>();
    public int getSize(){
        return arrayList.size();
    }

    public synchronized void add(){
        if(arrayList.size() < 20) {
            arrayList.add("小萝莉");
        }else{
            try {
                this.notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void take(){
        if(arrayList.size()>0) {
            arrayList.remove(0);
        }else{
            try {
                this.notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
