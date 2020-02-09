package string;

public class StringTest {
    public static void main(String[] args){
     //1.String类 属于 java.lang包
      //无任何的继承关系 实现了三个接口 Serializable,CharSequence,Comparable<String>

     //2.创建对象
     //   String str1 = "abc"; //直接将字符串常量赋值给str (字符串常量池)
     //   String str2 = new String();//无参数的构造方法创建对象
     //   String str3 = new String("abc");//带String参数的构造方法创建对象
     //   String str4 = new String(byte[]);//将数组中的每一个元素转化成对应的char 组合成String
     //   String str5 = new String(char[]);//将数组中的每一个char元素拼接成最终的String

     //3.String的不可变特性
        //String类中包含一个 private final char[] value;
        //体现在两个地方 长度及内容
        //长度---->final 修饰的数组  数组本身长度不变 final修饰数组的地址不变
        //内容---->private修饰属性  不能在类的外部访问

     //4.常用方法
        //equals()  hashCode() compareTo() toString()

/*equalsIgnoreCase();  忽略大小写进行比较
equals()  和 == 的区别
                == 可以比基本类型 也可以比引用类型
                 基本类型比的是值  引用类型比的是地址

                equals 只能比引用类型 (方法)
                默认比较地址(this==obj)
                若想修改其比较规则 可以重写equals 方法
                通常重写 equals 方法时会伴随 重写 hashCode 方法
                比如 String类 Integer 类

        String s1 = "abc";  //  "abc"对象  字符串常量缓冲区
        String s2 = "abc";
        String s3 = new String("abc"); // "abc"对象  堆内存
        String s4 = new String("abc");
        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(s3==s4);//false
        System.out.println(s1.equals(s2));//true   String类将继承自Object中的equals方法重写啦
        System.out.println(s1.equals(s3));//true   将原有比较==的方式改为比较字符值
        System.out.println(s3.equals(s4));//true
*/
 /*       int = hashCode();
        继承自Object类 重写了 将当前字符串的每一个char元素拆开 乘以31 求和

        String str = "abc";
        int value = str.hashCode();  //96354

*/
/*toString()
        继承自Object 重写了 输出字符串的字面值
        str.toString();
*/
/*compareTo()
        实现自Comparable 接口  实现方法 结果按照字典排布(Unicode码)顺序
        按照两个字符串长度较短的那个(次数) 进行循环
        若字符不一致  则直接返回code之差
        若比较之后都一致 则直接返回长度之差  0代表相等
        compareToIgnoreCase(); 忽略大小写进行比较
*/

       /*5.  char = charAt(int index);
                返回给定index 的对应的字符
              int = codePointAt(int index);
                返回给定index位置对应的code码
       */
       //String str = "abc";
       //int i = str.codePointAt(2);
       //System.out.println(i); //99

        /*6.int = length();

            返回字符串的长度 (其实就是底层char[] value属性的长度)
            注意 区别数组length是属性  String的length() 是方法 集合size() 是方法
         */
        //String str = "abc";
        //System.out.println(str.length());//3

        /*7 String = conCat(String str);
            将给定的字符串 拼接在当前String 对象的后面
                注意:方法执行完毕需要接收返回值  (String 的不可变特性)
                     conCat() 与 + 拼接的性能问题  (conCat的性能比+ 好)
                     开发中若遇到频繁的拼接字符串-->通常使用StringBuilder/StringBuffer

         */
        //String str = "abc";
        //str = str.concat("ef");
        //System.out.println(str); //abcef

        /*8.boolean = contains(CharSequence s);
                判断给定的s 是否在字符串中存在
         */
       // String str = "abc";
        //boolean a = str.contains("bc");
        //System.out.println(a); true

        /*9.startWith(String prefix)
            endWith(String suffix);
            判断此字符串是否以 xx 开头/结束
         */
       // String str = "abcdefg";
        //System.out.println(str.endsWith("g")); //true
        //System.out.println(str.startsWith("ab"));//true
        /*10.   byte[] = getBytes();
                char[] = toCharArray();
                将当前的字符串转化成数组  "我爱你中国"-->char[] {'我' '爱' '你' '中' '国'}
         */

        /*11.  int = indexOf(int/String str,[int fromIndex]); 四个方法重载
               找寻给定元素在字符串第一次出现的位置   若不存在返回-1
               int fromIndex 代表从哪里开始找

               int = lastIndexOf(int/String str,[int fromIndex]);
               找寻给定元素在字符串最后一次出现的位置  若不存在返回-1
         */
//        String str = "abcdef";
//        int index = str.indexOf("d");
//        System.out.println(index); //3

        /*12. boolean = isEmpty();
                判断当前字符串是否为空串 (length是否为0)
                注意: 与null之间的区别
         */

        /*13.replace(); 两个方法重载
        replaceAll(); 换全部的字串
        replaceFirst();换第一次出现的字串
                将给定的字符串替换成另外的字符串
         */

        //String str = "abcabcabc";
        //str = str.replace("a","b");
        //System.out.println(str);//bbcbbcbbc

        /*14 String[] = split(String regex,[int limit限度界限]);
            按照给定的表达式 将字符串拆分开来
         */
//        String str = "a-b-c-d";
//        String[] a = str.split("-",2); limit表示拆成几段
//        for (String value : a){
//            System.out.println(value);
//        }

        /*15.String  = substring(int beginIndex[,int endIndex])
                将当前字符串截取一段 从begin开始到 end结束
                若不写endIndex 则默认到字符串结束
         */

        /*16.  String = toUpperCase()
                String = toLowerCase()
                将全部字符串转换成大写/小写
         */

        /*17.  String = trim();
                去掉字符串前后多余的空格
         */
    }
}
