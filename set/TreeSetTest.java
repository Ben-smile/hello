package set;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main (String[] args){
//        1.无序无重复  java.util
//        2.无参数构造方法    带Collection构造方法
//        3.基本常用方法
//              add(E e)  iterator()  remove(E e)  没有修改  size()
//        4.无重复的规则是如何实现的
//              treeSet集合本身有顺序
//              我们指的无序存入的和取出来的不一致
//          compareTo---->String类  按照字母的自然顺序排布(Unicode)
//              如果想要把自己写的类型 比如Person对象存入TreeSet集合里
//              不能随意的存储	需要让自己写的类先实现Comparable接口
//              否则会抛出异常 ClassCastException 造型异常
        TreeSet<String> treeSet = new TreeSet();
        treeSet.add(new String("张三"));
        treeSet.add(new String("张三"));
        treeSet.add(new String("张三"));
        treeSet.add(new String("张三"));
        treeSet.add(new String("张三"));

        System.out.println(treeSet.size());
        System.out.println(treeSet);
        TreeSet<Person> personTreeSet = new TreeSet<Person>();
        personTreeSet.add(new Person("a",17));
        personTreeSet.add(new Person("b",28));
        personTreeSet.add(new Person("c",19));
        personTreeSet.add(new Person("d",20));
        personTreeSet.add(new Person("a",22));
        System.out.println(personTreeSet.size());
        System.out.println(personTreeSet);

    }
}
