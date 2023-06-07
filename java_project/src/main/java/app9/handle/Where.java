package app9.handle;

import java.util.Scanner;

import static app9.handle.Use.*;

public class Where {

    static Scanner sc = new Scanner(System.in);
    public static void choice() {
        System.out.println("사용한 곳을 선택하세요");
        System.out.println("1. 식비");
        System.out.println("2. 옷");
        System.out.println("3. 기타");
        System.out.print("선택하세요: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("식비를 선택하셨습니다.");
                // 여기에 먹을거에 해당하는 동작 또는 코드를 작성하세요.
                System.out.println("식비에 얼마를 썼는지 입력하세요.");
                String response = ""; //nullpoint 방지
                while (!response.equalsIgnoreCase("n")) {
                    int expense = sc.nextInt();
                    a[cnt] = expense;
                    where[cnt] = "식비";
                    cnt++;
                    System.out.print("더 쓸 내용이 있습니까? (Y/N): ");
                    response = sc.next();
                }
                break;

            case 2:
                System.out.println("옷을 선택하셨습니다.");
                // 여기에 옷에 해당하는 동작 또는 코드를 작성하세요.
                System.out.println("옷에 얼마를 썼는지 입력하세요.");
                response = "";
                while (!response.equalsIgnoreCase("n")) {
                    int clothExpense = sc.nextInt();
                    a[cnt] = clothExpense;
                    where[cnt] = "옷";
                    cnt++;
                    System.out.print("더 쓸 내용이 있습니까? (Y/N): ");
                    response = sc.next();
                }
                break;

            case 3:
                System.out.println("기타를 선택하셨습니다.");
                // 여기에 기타에 해당하는 동작 또는 코드를 작성하세요.
                System.out.println("기타에 얼마를 썼는지 입력하세요.");
                response = "";
                while (!response.equalsIgnoreCase("n")) {
                    int expense = sc.nextInt();
                    a[cnt] = expense;
                    where[cnt] = "기타";
                    cnt++;
                    System.out.print("더 쓸 내용이 있습니까? (Y/N): ");
                    response = sc.next();
                }
                break;

            default:
                System.out.println("잘못된 선택입니다.");
                break;
        }

        System.out.println();
        System.out.println("----------");
        Choice.Choice();

    }
}
