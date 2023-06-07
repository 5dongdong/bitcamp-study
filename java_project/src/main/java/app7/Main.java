package app7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int SIZE = 5; //테스트용 SIZE 값 1로 처리
        int cnt = 0;

        String[] where = new String[SIZE];
        int[] a = new int[SIZE];

        System.out.println("용돈을 관리 해보자잉");
        System.out.println("==========");
        System.out.println("이번달 용돈");
        System.out.println("----------");
        int money = sc.nextInt();
        System.out.println(money);
        System.out.println("----------------------------");
        for(int i = 0; i < SIZE; i++) {
            System.out.println("뭐에 썼을까");
            where[i] = sc.next();
            System.out.println("얼마씀");
            a[i] = sc.nextInt();
            System.out.println("그만 쓸까?");
            String response = sc.next();
            cnt ++;
            if(response.equals("y")) {
                break;
            }
        }
        for(int i = 0; i < cnt; i++) {
            System.out.println(where[i]);
            System.out.println("나간 비용 :" + a[i]);
        }
    }
}