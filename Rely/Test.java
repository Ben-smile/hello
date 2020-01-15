package ClassTestOne;

public class Test {
    public static void main (String[] args){
        Farmer f = new Farmer();
        Pig p = f.growPig(4);
        Butcher butcher = new Butcher();
        butcher.killPig(p);
    }
}
