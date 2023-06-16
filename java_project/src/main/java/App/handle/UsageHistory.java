package App.handle;

import App.print.Title;
import App.vo.Use;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import static App.print.Title.menu;
import static App.vo.Use.*;
import static App.vo.Use.cnt;

public class UsageHistory implements Handler{

    static Scanner sc = new Scanner(System.in);
    private String title;

    public UsageHistory(String title) {
        this.title = title;
    }

    public void execute() {
        printMenu();
        System.out.printf("%s 메뉴를 선택해주세요", title);
        while (true) {
            String menuNo = sc.next();
            if(menuNo.equals("1")) {
                choice2();
            } else if (menuNo.equals("2")) {
                list();
            } else if (menuNo.equals("3")) {
                update();
            }
        }
    }


    private void printMenu(){
        System.out.println("1 : 사용처");
        System.out.println("2 : 내역 확인");
        System.out.println("3 : 내역 수정");
    }


    public static void choice2() {
        String response = "y";
        while (response.equalsIgnoreCase("y")) {
            localDateTime[cnt] = LocalDateTime.now();
            System.out.println("사용한 곳을 입력하세요");
            String x = sc.next();
            System.out.println(x + "에 얼마를 사용했는지 입력하세요");
            try {
                int expense = sc.nextInt();
                a[cnt] = expense;
            } catch (InputMismatchException e){
                System.out.println("잘못 입력하셨습니다.");
                sc.nextLine();
                choice2();
            }
            Use use = new Use();

            where[cnt] = x;
            cnt++;
            System.out.print("더 쓸 내용이 있습니까? (Y/N): ");
            response = sc.next();
            System.out.println();
            while(!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("n")){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                System.out.print("더 쓸 내용이 있습니까? (Y/N): ");
                response = sc.next();
                System.out.println();
            }
        }
        System.out.println("----------");
        Choice();
    }

    public static void Choice() {
        System.out.println("1. 다시 선택하기");
        System.out.println("2. 사용 내역 보기");
        System.out.println("3. 메뉴");
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
        } else if(selection == 3){
            System.out.println();
            System.out.println("----------");
            System.out.println();
            menu();
        } else{
            System.out.println("잘못된 선택입니다.");
            System.out.println();
            System.out.println("----------");
            System.out.println();
            Choice();
        }

    }


    public static void list() {
        if (cnt == 0) {
            System.out.println();
            System.out.println("사용 내역이 없습니다.");
            System.out.println();
            Title.menu();
            return;
        }

        int remainingMoney = money; // 용돈의 초기값으로 remainingMoney를 초기화합니다.

        for (int i = 0; i < cnt; i++) {
            System.out.println("==========================");
            System.out.printf("등록일: %tY-%tm-%td%n", localDateTime[i], localDateTime[i], localDateTime[i]);
            System.out.println("사용한곳 : " + where[i]);
            System.out.println("사용금액 : " +a[i]);
            System.out.println("남은 용돈: " + (remainingMoney - a[i]));
            System.out.println("==========================");
            remainingMoney -= a[i]; // 지출액을 차감합니다.
        }
        Title.menu();
    }

    static String selectedExpense;
    public static void update() {
        Scanner sc = new Scanner(System.in);

        System.out.println("수정 또는 삭제할 항목을 선택하세요:");
        System.out.println("1. 수정");
        System.out.println("2. 삭제");
        System.out.println("3. 돌아가기");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                updateExpense(sc);
                break;
            case 2:
                deleteExpense(sc);
                break;
            case 3:
                menu();
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