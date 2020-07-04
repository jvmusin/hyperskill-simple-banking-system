package banking;

public class Luhn {
    public static String withChecksum(String s) {
        return s + getChecksum(s);
    }

    public static int getChecksum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';
            if (i % 2 == 0) x *= 2;
            if (x > 9) x -= 9;
            sum += x;
        }
        return (10 - (sum % 10)) % 10;
    }

    public static boolean validate(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int x = s.charAt(i) - '0';
            if (i % 2 == 0) x *= 2;
            if (x > 9) x -= 9;
            sum += x;
        }
        return (sum + s.charAt(s.length() - 1) - '0') % 10 == 0;
    }
}
