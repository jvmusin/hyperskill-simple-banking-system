package banking.menu.command;

import banking.CardService;
import banking.Session;

public class BalanceCommand implements Command {
    private final CardService cardService;

    public BalanceCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public String getDescription() {
        return "Balance";
    }

    @Override
    public void execute(Session session) {
        System.out.printf("Balance: %d%n%n", cardService.getBalance(session.getActiveCardNumber()));
    }
}
