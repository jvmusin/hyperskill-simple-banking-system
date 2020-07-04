package banking;

import java.util.Random;

public class CardGenerator {

    private static final int CARD_NUMBER_LENGTH = 4 * 4;
    private static final String PREFIX = "400000";

    private final Random rnd = new Random(239);

    private String generateCardNumber() {
        StringBuilder res = new StringBuilder(PREFIX);
        while (res.length() < CARD_NUMBER_LENGTH - 1) res.append(rnd.nextInt(10));
        int sum = 0;
        for (int i = 0; i < res.length(); i++) {
            int x = res.charAt(i) - '0';
            if (i % 2 == 0) x *= 2;
            if (x > 9) x -= 9;
            sum += x;
        }
        int checkSum = (10 - (sum % 10)) % 10;
        return res.toString() + checkSum;
    }

    private String generatePinCode() {
        return String.format("%04d", rnd.nextInt((int) 1e4));
    }

    public Card generate() {
        return new Card(null, generateCardNumber(), generatePinCode());
    }
}
