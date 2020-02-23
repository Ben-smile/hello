package domain;

public class Question {



    private String title;
    private String answer;
    private String path;

    public String getPath (){
        return path;
    }
    public Question (){}
    public Question (String title,String answer){
        this.answer = answer;
        this.title = title;
    }
    public Question (String title,String answer,String path){
        this.answer = answer;
        this.title = title;
        this.path = path;
    }
    public String getTitle(){
        return title;
    }
    public String getAnswer(){
        return answer;
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj instanceof Question){
            Question anQuestion = (Question) obj;
            String questionTitle = this.getTitle().substring(0,this.getTitle().indexOf("<br>"));
            String anQuestionTitle = this.getTitle().substring(0,this.getTitle().indexOf("<br>"));
            if (questionTitle.equals(anQuestionTitle)){
                return true;
            }
        }
        return false;
    }

    public int hashCode(){
        String questionTitle = this.getTitle().substring(0,this.getTitle().indexOf("<br>"));
        return questionTitle.hashCode();
    }
}
