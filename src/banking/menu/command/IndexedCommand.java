package banking.menu.command;

public class IndexedCommand {
    private final int index;
    private final Command command;

    public IndexedCommand(int index, Command command) {
        this.index = index;
        this.command = command;
    }

    public int getIndex() {
        return index;
    }

    public Command getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return String.format("%d. %s", index, command.getDescription());
    }
}
