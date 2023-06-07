package app8;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    final static int SIZE = 5; //테스트용 SIZE 값 1로 처리
    static int cnt = 0;

    static String[] where = new String[SIZE];
    static int[] a = new int[SIZE];


    public static void main(String[] args) {

        Title();
        Use();
        Total();


    }

    static void Title() {
        System.out.println("pocket money management");
        System.out.println("==========");
        System.out.println("this month pocket money");
        System.out.println("----------");
        int money = sc.nextInt();
        System.out.println(money + "won");
        System.out.println("----------------------------");
    }

    static void Use() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println("Where to use");
            where[i] = sc.next();
            System.out.println("how much");
            a[i] = sc.nextInt();
            System.out.println("Should I stop writing?");
            String response = sc.next();
            cnt++;
            if (response.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    static void Total() {
        for (int i = 0; i < cnt; i++) {
            System.out.println(where[i]);
            System.out.println("나간 비용 :" + a[i]);
        }
    }
}

