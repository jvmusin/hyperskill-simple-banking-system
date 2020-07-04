package banking.menu.command;

import banking.CardService;
import banking.Session;

public class CloseAccountCommand implements Command {

    private final CardService cardService;

    public CloseAccountCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public String getDescription() {
        return "Close account";
    }

    @Override
    public void execute(Session session) {
        cardService.closeCard(session.getActiveCardNumber());
        session.logout();

        System.out.println("The account has been closed!");
        System.out.println();
    }
}
