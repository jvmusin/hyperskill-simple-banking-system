package banking.menu.command;

import banking.Session;

public class ExitCommand implements Command {
    @Override
    public String getDescription() {
        return "Exit";
    }

    @Override
    public void execute(Session session) {
        session.triggerExit();
    }
}
