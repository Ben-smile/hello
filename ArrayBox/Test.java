public class Test {
    public static void main(String[] args){
        ArrayBox box = new ArrayBox();
        for (int i = 1;i <= 23;i++){
            box.add(i);
        }
        System.out.println("有效元素数为:"+box.size);
        System.out.println("Box的长度为:"+box.elementData.length);
        for (int i = 0;i<box.size;i++){
            int value = box.get(i);
            System.out.println(value+" ");
        }

    }
}
