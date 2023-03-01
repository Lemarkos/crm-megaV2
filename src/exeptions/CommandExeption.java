package exeptions;

public class CommandExeption extends RuntimeException{
    public CommandExeption(String message) {
        super(message);
    }
}
