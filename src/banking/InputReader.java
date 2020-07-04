package banking;

import java.util.Scanner;

public class InputReader {

    private final Scanner in = new Scanner(System.in);

    public String read() {
        return in.nextLine();
    }

    public String read(String prompt) {
        System.out.println(prompt + ": ");
        return read();
    }

    public int readInt() {
        return Integer.parseInt(read());
    }

    public int readInt(String prompt) {
        return Integer.parseInt(read(prompt));
    }
}
