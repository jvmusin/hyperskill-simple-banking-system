package banking;

import banking.menu.Menu;
import banking.menu.command.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        new Main().run(args[1]);
    }

    private void run(String dbFileName) {

        CardRepository cardRepository = new CardRepository("jdbc:sqlite:" + dbFileName);
        CardService cardService = new CardService(cardRepository);
        InputReader in = new InputReader();

        Menu notLoggedInMenu = new Menu(Arrays.asList(
                new IndexedCommand(1, new CreateAccountCommand(cardService)),
                new IndexedCommand(2, new LogInCommand(in, cardService)),
                new IndexedCommand(0, new ExitCommand())
        ));
        Menu loggedInMenu = new Menu(Arrays.asList(
                new IndexedCommand(1, new BalanceCommand(cardService)),
                new IndexedCommand(2, new AddIncomeCommand(in, cardService)),
                new IndexedCommand(3, new DoTransferCommand(in, cardService)),
                new IndexedCommand(4, new CloseAccountCommand(cardService)),
                new IndexedCommand(5, new LogOutCommand()),
                new IndexedCommand(0, new ExitCommand())
        ));

        Session session = new Session();
        while (!session.isExitTriggered()) {
            Menu menu = session.isLoggedIn() ? loggedInMenu : notLoggedInMenu;
            System.out.println(menu);
            int index = in.readInt();
            System.out.println();
            menu.choose(index, session);
        }

        System.out.println("Bye!");
    }
}
