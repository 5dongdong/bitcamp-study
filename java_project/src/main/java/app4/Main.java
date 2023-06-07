package app4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("용돈을 관리 해보자잉");
        System.out.println("==========");
        System.out.println("이번달 용돈");
        System.out.println("----------");
        int money = sc.nextInt();
        System.out.println(money);
        System.out.println("----------------------------");

        System.out.println("택시 탐");
        int taxi = sc.nextInt();
        System.out.println("택시 탐" + taxi);


        System.out.println("과자 사먹음");
        int cookie = sc.nextInt();
        System.out.println("과자 : " + cookie);

        System.out.println("점심 사먹음 ");
        int lunch = sc.nextInt();
        System.out.println("점심 :" + lunch);

        System.out.println("----------------------------");
        System.out.println("남은 용돈" + (money -(taxi + cookie + lunch)));



    }
}