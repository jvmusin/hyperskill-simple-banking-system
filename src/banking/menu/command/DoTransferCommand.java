package banking.menu.command;

import banking.CardService;
import banking.InputReader;
import banking.Session;
import banking.Luhn;

public class DoTransferCommand implements Command {
    private final InputReader in;
    private final CardService cardService;

    public DoTransferCommand(InputReader in, CardService cardService) {
        this.in = in;
        this.cardService = cardService;
    }

    @Override
    public String getDescription() {
        return "Do transfer";
    }

    @Override
    public void execute(Session session) {
        System.out.println("Transfer");
        String toNumber = in.read("Enter card number");

        String fromNumber = session.getActiveCardNumber();
        if (toNumber.equals(fromNumber)) {
            System.out.println("You can't transfer money to the same account!");
            System.out.println();
            return;
        }
        if (!Luhn.validate(toNumber)) {
            System.out.println("Probably you made mistake in the card number. Please try again!");
            System.out.println();
            return;
        }
        if (!cardService.cardExists(toNumber)) {
            System.out.println("Such a card does not exist.");
            System.out.println();
            return;
        }

        int amount = in.readInt("Enter how much money you want to transfer");
        if (cardService.getBalance(fromNumber) < amount) {
            System.out.println("Not enough money!");
            System.out.println();
            return;
        }

        cardService.updateBalance(fromNumber, -amount);
        cardService.updateBalance(toNumber, amount);

        System.out.println("Success!");
        System.out.println();
    }
}
