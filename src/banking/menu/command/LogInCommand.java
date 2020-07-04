package banking.menu.command;

import banking.Card;
import banking.CardService;
import banking.InputReader;
import banking.Session;

import java.util.Optional;

public class LogInCommand implements Command {

    private final InputReader in;
    private final CardService cardService;

    public LogInCommand(InputReader in, CardService cardService) {
        this.in = in;
        this.cardService = cardService;
    }

    @Override
    public String getDescription() {
        return "Log into account";
    }

    @Override
    public void execute(Session session) {
        String number = in.read("Enter your card number");
        String pin = in.read("Enter your PIN");
        System.out.println();

        Optional<String> card = cardService.findCard(number)
                .filter(c -> c.getPin().equals(pin))
                .map(Card::getNumber);
        if (card.isPresent()) {
            session.login(card.get());
            System.out.println("You have successfully logged in!");
        } else {
            System.out.println("Wrong card number or PIN!");
        }
        System.out.println();
    }
}
