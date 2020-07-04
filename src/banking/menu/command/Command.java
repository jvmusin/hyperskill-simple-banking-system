package banking.menu.command;

import banking.Session;

public interface Command {
    String getDescription();

    void execute(Session session);
}
