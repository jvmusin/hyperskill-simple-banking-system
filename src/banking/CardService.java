package banking;

import java.util.Optional;

public class CardService {

    private final CardRepository cardRepository;
    private final CardGenerator cardGenerator = new CardGenerator();

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void updateBalance(String number, int delta) {
        cardRepository.updateBalance(number, delta);
    }

    public Card createCard() {
        while (true) {
            Card card = cardGenerator.generate();
            if (cardRepository.loadCard(card.getNumber()).isEmpty()) {
                return cardRepository.saveCard(card);
            }
        }
    }

    public Optional<Card> findCard(String number) {
        return cardRepository.loadCard(number);
    }

    public void closeCard(String number) {
        cardRepository.deleteCard(number);
    }

    public int getBalance(String number) {
        return cardRepository.loadCard(number).orElseThrow().getBalance();
    }

    public boolean cardExists(String number) {
        return cardRepository.loadCard(number).isPresent();
    }
}
