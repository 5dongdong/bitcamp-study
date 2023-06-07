package app3;

public class Main {
    public static void main(String[] args) {
        int money = 100000;
        int taxi = 5000;
        int cookie = 5000;
        int lunch = 10000;

        System.out.println("용돈을 관리 해보자잉");
        System.out.println("이번달 용돈");
        System.out.println("==========");
        System.out.println(money); //용돈
        System.out.println("----------------------------");
        System.out.println("택시비 : " + taxi);
        System.out.println("과자 사먹음 :" + cookie);
        System.out.println("점심 사먹음 :" + lunch); //
        System.out.println("----------------------------");
        System.out.println("남은 용돈" + (money -(taxi + cookie + lunch)));
    }
}