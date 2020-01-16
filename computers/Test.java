package ClassTestTwo;

public class Test {
    public static void main(String[] args){
        ComputerRoom computerRoom = new ComputerRoom();
        Student student1 = new Student("小明");
        computerRoom.welcomeStudent(student1);
        Student student2 = new Student("小花");
        computerRoom.welcomeStudent(student2);
        Student student3= new Student("小雷");
        computerRoom.welcomeStudent(student3);
        Student student4 = new Student("小芳");
        computerRoom.welcomeStudent(student4);
        Student student5= new Student("小风");
        computerRoom.welcomeStudent(student5);
        Student student6 = new Student("小雨");
        computerRoom.welcomeStudent(student6);
    }
}
