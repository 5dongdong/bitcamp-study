package App.handle;

import App.print.Title;
import util.Prompt;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

import static App.print.Title.menu;
import static App.vo.Use.*;
import static App.vo.Use.cnt;

public class UsageHistory implements Handler{

    static ArrayList<LocalDateTime> localDateTimeArrayList = new ArrayList<>();
    private static Stack<String> recentUsageStack = new Stack<>();

    Prompt prompt = new Prompt();



    static Scanner sc = new Scanner(System.in);
    private String title;

    public UsageHistory(String title) {
        this.title = title;
    }

    public void execute() {
        printMenu();
        while (true) {
            String menuNo = prompt.inputString("메뉴를 선택해주세요");
            if(menuNo.equals("1")) {
                choice2();
            } else if (menuNo.equals("2")) {
                list();
            } else if (menuNo.equals("3")) {
                update();
            } else if (menuNo.equals("4")) {
                recent();
            }
            else {
                menu();
            }
        }
    }


    private void printMenu(){
        System.out.println("1 : 사용처");
        System.out.println("2 : 내역 확인");
        System.out.println("3 : 내역 수정");
        System.out.println("4 : 최근 내역");
        System.out.println("5 : 메뉴");
    }


    public  void choice2() {

        String response = "y";
        while (response.equalsIgnoreCase("y")) {
            localDateTimeArrayList.add(LocalDateTime.now());
            String x = prompt.inputString("사용한 곳을 입력하세요");
            System.out.println(x + "에 얼마를 사용했는지 입력하세요");
            try {
                int expense = sc.nextInt();
                expenseList.add(expense);
            } catch (InputMismatchException e){
                System.out.println("잘못 입력하셨습니다.");
                sc.nextLine();
                choice2();
            }

            whereList.add(x);
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

    public  void Choice() {
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

        ArrayList<Integer> remainingList  = new ArrayList<>();
        int remainingMoney = money; // 용돈의 초기값으로 remainingMoney를 초기화합니다.

        for(int i = 0; i < cnt; i++) {
            remainingMoney -= expenseList.get(i);
            remainingList .add(remainingMoney);
        }


        for (int i = 0; i < cnt; i++) {
            System.out.println("==========================");
            System.out.printf("등록일: %s%n",localDateTimeArrayList.get(i));
            System.out.println("사용한곳 : " + whereList.get(i));
            System.out.println("사용금액 : " + expenseList.get(i));
            System.out.println("남은 용돈: " +  remainingList .get(i));
            System.out.println("==========================");
        }
        Title.menu();
    }


    public static void recent(){
        System.out.println("최근 사용 내역 몇건을 조회하시겠습니까");
        int a = sc.nextInt();

        if(cnt == 0) {
            System.out.println("최근 사용 내역이 없습니다.");
            menu();
        }

        int start = Math.max(cnt - a, 0);
        int end = Math.min(cnt, start + a);
        System.out.println("최근 사용내역" + end  + "건의 사용 내역");
        for(int i = start; i < end; i++){
            String recent =  String.format("등록일: %s, 사용한 곳: %s, 사용금액: %d",
                    localDateTimeArrayList.get(i), whereList.get(i), expenseList.get(i));
            recentUsageStack.push(recent);


            while (!recentUsageStack.isEmpty()){
                String recentPop = recentUsageStack.pop();
                System.out.println("====================================");
                System.out.println(recentPop);
                System.out.println("====================================");
                System.out.println();
            }
        }
        menu();
    }


    // ======================수정 && 삭제==========================
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
            if (whereList.get(i).equals(selectedExpense)){
                System.out.println("현재 " + selectedExpense + " 사용 금액: " + expenseList.get(i));
                System.out.println("수정할 " + selectedExpense + " 사용 금액을 입력하세요:");
                int updatedExpense = sc.nextInt();
                expenseList.set(i, updatedExpense);
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
            if(whereList.get(i).equals(selectedExpense)){
                System.out.println(selectedExpense + " 사용 내역을 삭제합니다.");
                deleteIndex = i;
                break;
            }
        }

        if (deleteIndex == -1) {
            System.out.println(selectedExpense + " 사용 내역이 없습니다.");
            return;
        }
        expenseList.remove(deleteIndex);
        whereList.remove(deleteIndex);
        localDateTimeArrayList.remove(deleteIndex);


        cnt--; // 배열 크기 감소

        System.out.println(selectedExpense + " 사용 내역이 삭제되었습니다.");
        menu(); // 삭제된 값들을 고려하여 total2() 메소드 호출
    }

}
