package circlearrayqueue;

public class CircleArrayQueue {

//用数组来实现  环形队列

    private int maxSize; //队列的最大长度
    private int front; //表示队列的第一个元素 默认为0
    private int rear; //表示队列的最后一个元素的后一个,因为是环形队列 所以默认为0
    private int[] queue;

    //构造方法
    public CircleArrayQueue (int maxSize){
        this.maxSize = maxSize;
        queue = new int[maxSize];
    }

    /*
    * 分析 环形队列的 头和尾的关系
    * 如何判断 队列为空  rear == front
    * 如何判断 队列为满  (rear+1)%maxSize == front
    * 如何计算 队列的有效值个数 (rear + maxSize - front) % maxSize
    *
    * */

    //方法 判断队列是否为空
    private boolean isEmpty(){
        if (rear == front){
            return true;
        }
        return false;

    }

    //方法 判断队列是否已满
    private boolean isFull(){
        if((rear + 1)%maxSize == front){
            return true;
        }
        return false;
    }

    //方法 新增一个数据
    public void add(int value){
        if(isFull()){ //如果 队列满了
            System.out.println("对不起,队列已满,下次再来");
        }else {
            System.out.println(rear);
            queue[rear] = value;
            rear = (rear+1)%maxSize;
        }
    }

    //方法 取出一个数据
    public void get(){
        int value;
        if(isEmpty()){
            System.out.println("对不起,队列是空的");
        }else{

            value = queue[front];
            front = (front + 1)% maxSize;
            System.out.println(value);
        }
    }

    //方法 显示有效数据的个数
    public void  size(){
        if(isEmpty()){
            System.out.println(0);
        }else{

            System.out.println((rear + maxSize - front)% maxSize);
        }
    }

    //方法 显示整个队列
    //思路 从front 开始遍历 遍历有效个数次
    public void show(){
        if (isEmpty()){
            System.out.println("队列为空");
        }else {
            int length = (rear + maxSize -front)%maxSize;
            for(int i= front ; i<front+length;i++){
                System.out.println("序号"+i%maxSize+"---"+queue[i%maxSize]);
            }
        }
    }

}
