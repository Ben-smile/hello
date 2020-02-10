package set;

import java.util.HashSet;

public class TestHashSet {
    public static void main(String[] args){
//        1.java.util
//        2.如何创建对象   无参数  有参数
//        3.集合容器的基本使用
//                增删改查
//        boolean = add(value)   addAll(collection c)   retainAll   removeAll
//        boolean = remove(Object)
//        没有修改方法
//        iterator()  获取一个迭代器对象
//        size()
//        4.无重复的原则
//                首先通过String类型和Person类型存储
//        大概猜测  无重复的原则  利用equals方法进行比较
//        如果我们想要让Person对象的name一致 认为是同一个对象
//
//        我们可以重写equals方法
//
//        重写了equals方法  发现还没有产生无重复的效果
//        证明可能原则不止equals一个方法这么简单
//
//        还有另一个规则同时起着作用 hashCode方法  int
//
//        五个Person对象只剩一个   第一次存储的   还是最后一次存储
//        set集合是发现重复的元素 拒绝存入  存储的是第一个
        HashSet<String> hashSet = new HashSet();
        hashSet.add("张三");
        hashSet.add("张三");
        hashSet.add("张三");
        hashSet.add("张三");
        hashSet.add("张三");

        System.out.println(hashSet.size()); //1
        System.out.println(hashSet); //[张三]

        HashSet<Person> personSet = new HashSet();
        personSet.add(new Person("张三",18));
        personSet.add(new Person("张三",18));
        personSet.add(new Person("张三",18));
        personSet.add(new Person("张三",18));
        personSet.add(new Person("张三",18));
        System.out.println(personSet.size());  //1
        System.out.println(personSet);  //[张三,18]

    }
}
