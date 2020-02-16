package systemtickets;

public class Ticket {
    private String begin;
    private String end;
    private Float price;

    public Ticket (){}

    public Ticket (String begin,String end,Float price){
        this.begin = begin;
        this.end = end;
        this.price = price;
    }

    public String toString (){
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(begin);
        stringBuilder.append("-");
        stringBuilder.append(end);
        stringBuilder.append("-");
        stringBuilder.append(price);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
