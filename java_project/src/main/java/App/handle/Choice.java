package App.handle;

import java.util.Scanner;

import static App.handle.List.list;
import static App.handle.Where.choice2;


public class Choice {
    static Scanner sc = new Scanner(System.in);

    public static void Choice() {
        System.out.println("1. 다시 선택하기");
        System.out.println("2. 사용 내역 보기");
        System.out.print("선택하세요: ");
        int selection = sc.nextInt();

        if (selection == 1) {
            System.out.println();
            System.out.println("----------");
            System.out.println();
            choice2();
        } else if (selection == 2) {
            System.out.println();
            System.out.println("----------");
            System.out.println();
            list();
        } else {
            System.out.println("잘못된 선택입니다.");
            System.out.println();
            System.out.println("----------");
            System.out.println();
            Choice();
        }

    }
}
