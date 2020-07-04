package banking;

public class CommandNotFoundException extends RuntimeException {
    public CommandNotFoundException(int index) {
        super(String.format("Command with index %d not found", index));
    }
}
