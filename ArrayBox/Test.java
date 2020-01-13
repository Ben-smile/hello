public class Test {
    public static void main(String[] args){
        ArrayBox box = new ArrayBox();
        for (int i = 1;i <= 8;i++){
            box.add(i);
        }
       int num = box.delete(2);
        System.out.println("删除的元素为:"+num);
        System.out.println("有效元素数为:"+box.size());
        System.out.println("Box的长度为:"+box.elementData().length);
        for (int i = 0;i<box.size();i++){
            int value = box.get(i);
            System.out.println(value+" ");
        }
        //int value = box.get(5);
        //System.out.println(value);

    }
}
