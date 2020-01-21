package test;

import util.ArrayBox;
import util.LinkedBox;

public class MainTest {
    public static void main( String[] args){
        LinkedBox l = new LinkedBox();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);

        l.remove(1);
        int value1=l.get(0);
        int value2=l.get(1);
        int value3=l.get(2);
        int value4=l.get(4);
        int size = l.size();
        System.out.println(value1+" "+value2+" "+value3+" "+value4);
        System.out.println(size);
    }

}
