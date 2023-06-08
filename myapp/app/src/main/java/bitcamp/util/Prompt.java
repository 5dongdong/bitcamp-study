package bitcamp.util;

import java.util.Scanner;


public class Prompt {
public static	Scanner sc = new Scanner(System.in); //의존객체 Dependency

public static String inputString(String title) {
	System.out.println(title);
	return sc.nextLine();
}

public static int inputInt(String title) {
	return Integer.parseInt(inputString(title));
}

public static void close() {
	sc.close();
}
}
