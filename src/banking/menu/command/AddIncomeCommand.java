package banking.menu.command;

import banking.CardService;
import banking.InputReader;
import banking.Session;

public class AddIncomeCommand implements Command {
    private final InputReader in;
    private final CardService cardService;

    public AddIncomeCommand(InputReader in, CardService cardService) {
        this.in = in;
        this.cardService = cardService;
    }

    @Override
    public String getDescription() {
        return "Add income";
    }

    @Override
    public void execute(Session session) {
        int amount = in.readInt("Enter income");
        cardService.updateBalance(session.getActiveCardNumber(), amount);
        System.out.println("Income was added!");
        System.out.println();
    }
}
