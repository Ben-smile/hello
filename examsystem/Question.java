package examsystem;

public class Question {

    private String title;
    private String answer;
    public Question (String title,String answer){
        this.title = title;
        this.answer = answer;
    }

    public String getTitle(){
        return title;
    }
    public String getAnswer (){
        return answer;
    }

    public boolean equals (Object obj){
        if (this == obj){
            return true;
        }

        if (obj instanceof Question){
            Question anQuestion = (Question)obj;
            if((this.title.split("\\\\?"))[0] == (anQuestion.title.split("\\\\?"))[0]){
                return true;
            }
        }
        return false;
    }

    public int hashCode (){
        return this.title.hashCode();
    }


}
