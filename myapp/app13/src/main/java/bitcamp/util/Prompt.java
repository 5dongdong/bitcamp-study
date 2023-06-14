package bitcamp.util;

import java.util.Scanner;


public class Prompt {
  public static Scanner sc = new Scanner(System.in); // 의존객체 Dependency

  public static String inputString(String title, Object... args) {
    System.out.printf(title, args);
    return sc.nextLine();
  }

  public static int inputInt(String title, Object... args) {
    return Integer.parseInt(inputString(title, args));
  }

  public static void close() {
    sc.close();
  }
}
