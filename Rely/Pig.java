package ClassTestOne;

public class Pig {

    public String name;
    public int age;
    public int weight=20;
    public Pig (String name){
        this.name = name;
    }
    public Pig (){}

    public void beKilled () {
        System.out.println(name+"被杀了 好惨");
    }
    public void tellWeight (){
        System.out.println("现在"+weight+"斤");
    }
    public void tellName (){
        System.out.println("这头猪名字叫"+name);
    }
    public void grow (int month){
        for (int i = 1;i<=month ; i++){
            this.weight*=2;
        }
    }
}
