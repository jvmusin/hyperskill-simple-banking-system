package banking.menu;

import banking.CommandNotFoundException;
import banking.Session;
import banking.menu.command.IndexedCommand;

import java.util.List;
import java.util.stream.Collectors;

public class Menu {
    private final List<IndexedCommand> commands;

    public Menu(List<IndexedCommand> commands) {
        this.commands = commands;
    }

    public void choose(int index, Session session) {
        for (IndexedCommand command : commands) {
            if (command.getIndex() == index) {
                command.getCommand().execute(session);
                return;
            }
        }
        throw new CommandNotFoundException(index);
    }

    @Override
    public String toString() {
        return commands.stream()
                .map(Object::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
