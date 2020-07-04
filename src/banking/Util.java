package banking;

public class Util {
    public static boolean checkLuhnChecksum(String s) {
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
