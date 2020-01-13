public class ArrayBox {
    private int[] elementData = new int[10];
    private int size = 0;

    public void add (int num){  //用户调用的储存方法
        this.judgeCapacity(size+1);
        elementData[size++] = num;
    }

    public int get (int index){   //获取元素
        this.judgeIndexWhetherLegal(index);
        int value = elementData[index];
        return value;
    }

    public int delete (int index){  //删除元素
        this.judgeIndexWhetherLegal(index);
        int value = elementData[index];   //记录删除的元素是什么
        for (int i = index;i <size-1;i++){
            elementData[i] = elementData[i+1];  //用后一个的值覆盖前一个的值  最后一个
        }                                       //不动
        elementData[--size] = 0;//将最后一个值赋为0
         //size--;    //将有效长度减少1
        return value;
    }
    //124566
    //123456
    public ArrayBox (){    //构造方法 无参数

    }
    public ArrayBox (int a){  //构造方法重载 让用户创建自定义的初始长度
        elementData = new int[a];
    }
    //==============================================================================

    public int size (){   //创建一个size的方法 保证属性数据不被修改
        return this.size;
    }
    public int[] elementData(){
        return this.elementData;
    }

    private void judgeIndexWhetherLegal (int index){  //判断索引的数字是否合法
        if (index >=size||index<0){  //如果索引小于零 或者大于size 抛出异常
            throw new BoxIndexOutOfBoundsException("index:"+index+"size:"+size);
        }//抛出异常
    }


    private void judgeCapacity (int minCapacity){  //判断容量是否足够
        if (this.elementData.length<minCapacity){
            //如果容量不够  再创建一个方法 用来扩容
            this.expandCapacity(elementData,size+1);//调用 扩容方法
        }
    }

    private void expandCapacity (int[] arr,int minCapacity){//扩容
        int newLength = this.elementData.length + (this.elementData.length >>1);
        if (newLength < minCapacity){
            newLength = minCapacity;
        }       //通过算法  获得新数组的长度
        this.setNewArray(elementData,newLength);  //调用 创建新数组方法
    }

    private void setNewArray (int[] oldArr,int newLength){  //创建新数组
        int[] newArray = new int[newLength];
        for (int i = 0;i< size;i++){
            newArray[i] = this.elementData[i];
        }
        elementData = newArray;
    }

}
