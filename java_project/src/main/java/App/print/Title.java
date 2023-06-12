package App.print;



import App.vo.Use;

import java.util.InputMismatchException;
import java.util.Scanner;

import static App.handle.List.list;
import static App.handle.UpdateExpenseTest.update;
import static App.vo.Use.*;
import static App.handle.Where.choice2;

public class Title {
    static Scanner sc = new Scanner(System.in);
    public static void title() {
        System.out.println("pocket money management");
        System.out.println("==========");
    }
    public static void menu(){
        System.out.println("1. 용돈 추가하기");
        System.out.println("2. 용돈 확인하기");
        System.out.println("3. 사용 내역 작성하기");
        System.out.println("4. 사용 내역 확인하기");
        System.out.println("5. 사용 내역 수정하기");
        System.out.println("6. 종료");

        Use use = new Use();
        use.setMenu(sc.nextInt());
        switch (getMenu()) {
            case 1:
                System.out.println("1. 용돈을 추가해주세요");
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
                break;


            case 2:
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
                break;
            case 3:
                System.out.println("3. 사용 내역 작성하기");
                choice2();
                break;
            case 4:
                System.out.println("4. 사용 내역 확인하기");
                list();
                break;
            case 5:
                System.out.println("5. 사용 내역 수정하기");
                update();
                break;
						case 6:
						break;
        }
    }
}
