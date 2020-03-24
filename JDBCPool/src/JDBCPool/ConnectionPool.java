package JDBCPool;

import java.util.ArrayList;

public class ConnectionPool {

    //创建一个集合  用来 存储10个连接
    private static int DEFAULT_SIZE = 10;
    private ArrayList<MyConnection> pool = new ArrayList<>();

    {

        for(int i = 0;i<DEFAULT_SIZE;i++){
            MyConnection mc = new MyConnection();
            pool.add(mc);
        }
    }

    public MyConnection getConnection() {
        MyConnection mc = null;
        for(int i = 0; i<pool.size();i++){
            mc = pool.get(i);
            if(mc.isState() == false){
                mc.setState(true);
                break;
            }
        }
        return mc;
    }


}
