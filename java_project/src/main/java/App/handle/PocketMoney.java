package App.handle;

import App.vo.Use;

import java.util.InputMismatchException;
import java.util.Scanner;


import static App.print.Title.menu;
import static App.vo.Use.*;
import static App.vo.Use.money;

public class PocketMoney  implements Handler {
    static Scanner sc = new Scanner(System.in);
    static Use use = new Use();
    private String title;

    public PocketMoney(String title) {
        this.title = title;
    }

    public void execute() {
        printMenu();
        System.out.printf("%s 메뉴를 선택해주세요", title);
        while (true) {
            String menuNo = sc.next();
            if (menuNo.equals("1")) {
                plusMoney();
            } else if (menuNo.equals("2")) {
                ShowMoney();
            } else {
                System.out.println("잘못 입력하셨습니다");
            }
        }
    }

private void printMenu() {
    System.out.println("1. 용돈 추가");
    System.out.println("2. 용돈 확인");
}

            public static void plusMoney() {
                System.out.println("용돈을 추가해주세요");
                try { //오류를 발생시킬수 있는 곳
                    use.setMoneyToAdd(sc.nextInt());
                    money += use.getMoneyToAdd();
                    System.out.println();
                    System.out.println("----------");
                    System.out.println(use.getMoneyToAdd() + "원 추가되었습니다.");
                    System.out.println("----------");
                    System.out.println();
                } catch (InputMismatchException e) { //오류를 잡음
                    System.out.println();
                    System.out.println("$*$*$*$*$*$*$*$*$");
                    System.out.println("-잡았다 오류-");
                    System.out.println("$*$*$*$*$*$*$*$*$");
                    System.out.println();
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println();
                    sc.nextLine();
                }
                menu();
            }

            public static void ShowMoney() {
                System.out.println();
                System.out.println("==============");
                System.out.println("2. 용돈 확인하기");
                System.out.println("==============");
                System.out.println();

                int totalExpenses = 0;
                for (int i = 0; i < cnt; i++) {
                    totalExpenses += a[i];
                }

                int remainingMoney = money - totalExpenses;
                System.out.println("=============================");
                System.out.println("    총 사용 금액: " + totalExpenses);
                System.out.println("    남은 용돈: " + remainingMoney);
                System.out.println("=============================");
                System.out.println();

                menu();
            }
}




