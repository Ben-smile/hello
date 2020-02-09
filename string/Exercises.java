package string;

public class Exercises {
    //1.设计一个方法 将字符串反转
    public String revers (String str){
        char[] r = str.toCharArray();
        for (int i = 0;i<r.length/2;i++){
            char temp = r[i];
            r[i] = r[r.length-1-i];
            r[r.length-1-i] = temp;
        }
        String result = new String(r);
        return result;
    }

    //2.将给定字符串的正序和反序进行连接
    public String connect (String str){
        String str1 = this.revers(str);
        str = str.concat(str1);
        return str;
    }

    //3.判断字符串是否是回文序列
    public boolean judge (String str){
        if (this.revers(str).equals(str)){
            return true;
        }
        return false;
    }

    //4.将给定字符串右移x个位置
    public String move (String str,int num){
        String str1 = str.substring(str.length()-num);
        String str2 = str.substring(0,str.length()-num);
        str1 = str1.concat(str2);
        return str1;
    }
    //5.寻找若干字符串中最长的那个
    public String findLongest (String[] str){
        for (int i = str.length-1; i>=1;i--){
            if (str[i].length() > str[i-1].length()){
                String temp = str[i];
                str[i] = str[i-1];
                str[i-1] = temp;
            }
        }
        String str1 = str[0];
        return str1;
    }

    public String find (String...strs){
        String maxString = strs[0];
        int maxValue = strs[0].length();
        for (int i = 1; i<strs.length;i++){
            if (strs[i].length() > maxValue){
                maxValue = strs[i].length();
                maxString = strs[i];
            }
        }
        return maxString;
    }

    //6.统计给定字母在字符串中出现的次数
    public int count (String str,char ch){
        char[] c = str.toCharArray();
        int count = 0;
        for (int i = 0; i<c.length;i++){
            if (c[i] == ch){
                count++;
            }
        }
        return count;
    }

    //7.将给定的字符串的每一个首字母大写
    public String upperString (String str){
        String[] str1 = str.split(" ");
        String result = "";
        for (int i = 0;i<str1.length;i++){
            String first = str1[i].substring(0,1).toUpperCase();
            String other = str1[i].substring(1);
            str1[i] = first.concat(other);
            result += (str1[i]+" ");
        }
        return result.trim();
    }

    //8.获取给定字符串中的全部数字
    public int  findNumber (String str){
        String str1 = "";
        for (int i = 0; i<str.length();i++){
            if (str.codePointAt(i) <= 57 && str.codePointAt(i) >=48){
                str1 = str1.concat(String.valueOf(str.charAt(i)));
            }
        }
        return Integer.parseInt(str1);
    }
}
