package mymvc;

public class ControllerNotFoundException extends RuntimeException {

    public ControllerNotFoundException(){}
    public ControllerNotFoundException(String mess){
        super(mess);
    }
}
