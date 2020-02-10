package set;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person (String name,int age){
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object obj) { //重写equals方法让默认比地址改成比值
        if (this == obj){
            return true;
        }
        if (obj instanceof Person){
            Person anPerson = (Person)obj;
            if (this.name.equals(anPerson.name) && this.age == anPerson.age){
                return true;
            }
        }
        return false;
    }

    public int hashCode (){  //重写hashCode方法
        return this.name.hashCode(); //name是String 类型 所以这里的.hashCode是调用的String类
                                     //的hashCode方法
    }

    public String toString (){  //重写toString 打印输出更方便
        StringBuilder s = new StringBuilder(this.name);
        s.append(",");
        s.append(this.age);

        return new String(s);
    }


    //要想让Person对象存入 TreeSet 必须先实现comparable接口 然后重写compareTo方法
    public int compareTo (Person anPerson){
        int value = this.name.compareTo(anPerson.name);
        if (value != 0){
            return value;
        }
        return this.age - anPerson.age;
    }
}
