package banking;

import java.util.Objects;

public class Card {
    @SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal", "unused"})
    private Integer id;
    private final String number;
    private final String pin;
    private final int balance;

    public Card(Integer id, String number, String pin) {
        this(id, number, pin, 0);
    }

    public Card(Integer id, String number, String pin, int balance) {
        this.id = id;
        this.number = number;
        this.pin = pin;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(number, card.number) &&
                Objects.equals(pin, card.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, pin);
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
