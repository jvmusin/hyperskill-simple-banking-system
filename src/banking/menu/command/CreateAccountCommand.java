package banking.menu.command;

import banking.Card;
import banking.CardService;
import banking.Session;

public class CreateAccountCommand implements Command {

    private final CardService cardService;

    public CreateAccountCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public String getDescription() {
        return "Create an account";
    }

    @Override
    public void execute(Session session) {
        Card card = cardService.createCard();
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(card.getNumber());
        System.out.println("Your card PIN:");
        System.out.println(card.getPin());
        System.out.println();
    }
}
