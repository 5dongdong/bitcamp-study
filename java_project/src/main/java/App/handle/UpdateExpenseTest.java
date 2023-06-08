package App.handle;

import java.util.InputMismatchException;
import java.util.Scanner;


import static App.vo.Use.*;
import static App.print.Title.menu;

public class UpdateExpenseTest {
    static String selectedExpense;
    public static void update() {
        Scanner sc = new Scanner(System.in);

        System.out.println("수정 또는 삭제할 항목을 선택하세요:");
        System.out.println("1. 수정");
        System.out.println("2. 삭제");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                updateExpense(sc);
                break;
            case 2:
                deleteExpense(sc);
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                sc.close();
                return;
        }

        sc.close();
    }

    private static void updateExpense(Scanner sc) {
        System.out.println("수정할 항목을 입력하세요:");
        selectedExpense = sc.next();
        for (int i = 0; i < cnt; i++) {
            if (where[i].equals(selectedExpense)) {
                System.out.println("현재 " + selectedExpense + " 사용 금액: " + a[i]);
                System.out.println("수정할 " + selectedExpense + " 사용 금액을 입력하세요:");
                int updatedExpense = sc.nextInt();

                a[i] = updatedExpense; // 입력한 값으로 배열의 값을 변경

                System.out.println(selectedExpense + " 사용 내역이 수정되었습니다.");
                menu(); // 수정된 값들을 고려하여 total2() 메소드 호출
                return;
            }
        }
        System.out.println(selectedExpense + " 사용 내역이 없습니다.");
        update();
    }


    private static void deleteExpense(Scanner sc) {
        System.out.println("삭제할 항목을 입력하세요:");
        selectedExpense = sc.next();

        int deleteIndex = -1;
        for (int i = 0; i < cnt; i++) {
            if (where[i].equals(selectedExpense)) {
                System.out.println(selectedExpense + " 사용 내역을 삭제합니다.");
                deleteIndex = i;
                break;
            }
        }

        if (deleteIndex == -1) {
            System.out.println(selectedExpense + " 사용 내역이 없습니다.");
            return;
        }

        // 삭제된 항목 이후의 배열 요소들을 앞으로 당깁니다.
        for (int i = deleteIndex; i < cnt - 1; i++) {
            a[i] = a[i + 1];
            where[i] = where[i + 1];
        }

        // 마지막 요소를 0으로 초기화합니다. (불필요한 값 제거)
        a[cnt - 1] = 0;
        where[cnt - 1] = null;

        cnt--; // 배열 크기 감소

        System.out.println(selectedExpense + " 사용 내역이 삭제되었습니다.");
        menu(); // 삭제된 값들을 고려하여 total2() 메소드 호출
    }
}
