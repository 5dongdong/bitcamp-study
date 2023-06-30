package util;

import java.io.InputStream;
import java.util.Scanner;

public class Prompt {
    private Scanner sc;

    public Prompt() {
        this.sc = new Scanner(System.in);
    }

    public Prompt(InputStream in) {
        this.sc = new Scanner(in);
    }

    public String inputString(String title, Object... args){
        System.out.printf(title, args);
        return this.sc.nextLine();
    }
    public String next() {
        return this.sc.next();
    }

    public int inputInt(String title, Object... args) {
        return Integer.parseInt(inputString(title, args));
    }

    public void close() {
        sc.close();
    }
}
