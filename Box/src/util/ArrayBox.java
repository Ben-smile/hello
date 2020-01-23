package util;

import javax.xml.bind.annotation.XmlType;

public class ArrayBox implements Box{
    private int[] element;
    private int size;
    private static final int DEFAULT_LENGTH = 10;

    public ArrayBox (){
        element= new int[DEFAULT_LENGTH];
    }
    public ArrayBox (int length){
        element = new int[length];
    }
//-----------------------------------------------------
    private void ensureCapacity (int minCapacity){
        if (minCapacity > element.length){
             //如果需要的最小容量比数组长度大  扩容
            this.grow(minCapacity);
        }
    }

    private void grow (int minCapacity){ //扩容
        int oldLength = element.length;
        int newLength = oldLength + (oldLength >> 1);
        if (newLength <minCapacity){
            newLength = minCapacity;
        }
        //创建新数组
        element = this.set(minCapacity,element);
    }

    private int[] set (int newLength,int[] oldArray){//创建数组
        int[] newArray = new int[newLength];
        for (int i = 0;i <oldArray.length;i++){
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    private void rangeCheck (int index){
        if (index <0||index >=size){
            throw new IndexOutOfBoundsException("index:"+index+"size:"+size);
        }
    }
//--------------------------------------------------------------
    public boolean add(int element) {
        //判断 容量
        this.ensureCapacity(size+1);
        this.element[size++] = element;
        return true;
    }


    public int remove(int index) {
        this.rangeCheck(index);
        int removeElement = element[index];
        for (int i = index;i<element.length-1;i++){
            element[i]=element[i+1];
        }
        element[--size] = 0;
        return removeElement;
    }


    public int get(int index) {
        this.rangeCheck(index);

        return element[index];
    }


    public int size() {
        return size;
    }
}
