public class Test {
    public static void main(String[] args){
        ArrayBox box = new ArrayBox();   //创建ArrayBox 对象
        for (int i = 1;i <= 23;i++){     //通过 box.add()  存储元素
            box.add(i);
        }
        System.out.println("有效元素数为:"+box.size);
        System.out.println("Box的长度为:"+box.elementData.length);
        for (int i = 0;i<box.size;i++){        //通过get方法S查看
            int value = box.get(i);
            System.out.println(value+" ");
        }

    }
}
