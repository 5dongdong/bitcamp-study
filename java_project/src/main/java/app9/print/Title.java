package app9.print;

import app9.handle.Where;

import java.util.Scanner;

import static app9.handle.Use.money;

public class Title {
    public static void Title() {
        Scanner sc = new Scanner(System.in);
        System.out.println("pocket money management");
        System.out.println("==========");
        System.out.println("이번달에 받은 용돈");
        System.out.println("----------");
        money = sc.nextInt();
        System.out.println("----------");
        System.out.println(money + "원");
        System.out.println("----------");
        Where.choice();
    }
}
