package banking.menu.command;

import banking.Session;

public class LogOutCommand implements Command {
    @Override
    public String getDescription() {
        return "Log out";
    }

    @Override
    public void execute(Session session) {
        session.logout();

        System.out.println("You have successfully logged out!");
        System.out.println();
    }
}
