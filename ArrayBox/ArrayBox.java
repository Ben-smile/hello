public class ArrayBox {
    public int[] elementData = new int[10];
    public int size = 0;

    public void add (int num){   //用户调用的储存方法
        this.judgeCapacity(size+1);
        elementData[size++] = num;
    }

    public void judgeCapacity (int minCapacity){  //判断容量是否足够
        if (this.elementData.length<minCapacity){
            //如果容量不够  再创建一个方法 用来扩容
            this.expandCapacity(elementData,size+1);//调用 扩容方法
        }
    }

    public void expandCapacity (int[] arr,int minCapacity){//扩容
        int newLength = this.elementData.length + (this.elementData.length >>1);
        if (newLength < minCapacity){
            newLength = minCapacity;
        }       //通过算法  获得新数组的长度
        this.setNewArray(elementData,newLength);  //调用 创建新数组方法
    }

    public void setNewArray (int[] oldArr,int newLength){  //创建新数组
        int[] newArray = new int[newLength];
        for (int i = 0;i< size;i++){
            newArray[i] = this.elementData[i];
        }
        elementData = newArray;
    }

    public int get (int index){   //获取元素
        int value = elementData[index];
        return value;
    }


}
