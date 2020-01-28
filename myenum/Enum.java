package myenum;

public class Enum {
    private String name;
    private int index;
    private Enum (){}
    private Enum (String name){
        this.name = name;
    }
    private Enum (int index){
        this.index = index;
    }

    public static final Day monday = new Day();
    public static final Day tuesday = new Day();
    public static final Day wednesday = new Day();
    public static final Day thursday = new Day();
    public static final Day friday = new Day();
    public static final Day saturday = new Day();
    public static final Day sunday = new Day();
}
