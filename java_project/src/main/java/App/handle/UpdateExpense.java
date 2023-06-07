package App.handle;

import static App.handle.Total.total;
import static App.handle.Use.*;

import java.util.Scanner;

public class UpdateExpense {

    public static void update() {
        Scanner sc = new Scanner(System.in);

        System.out.println("수정할 항목을 선택하세요:");
        System.out.println("1. 식비");
        System.out.println("2. 옷");
        System.out.println("3. 기타");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("식비 사용 내역 수정:");
                for (int i = 0; i < cnt; i++) {
                    if (where[i].equals("식비")) {
                        System.out.println("현재 식비 사용 금액: " + a[i]);
                        System.out.println("수정할 식비 사용 금액을 입력하세요:");
                        int updatedFoodExpense = sc.nextInt();

                        System.out.println("1. 더하기");
                        System.out.println("2. 빼기");
                        int expenseChoice = sc.nextInt();

                        switch (expenseChoice) {
                            case 1:
                                a[i] = updatedFoodExpense; // 수정된 값을 할당
                                break;
                            case 2:
                                a[i] = -updatedFoodExpense; // 수정된 값을 할당 (음수로 표현하여 빼기)
                                break;
                            default:
                                System.out.println("잘못된 선택입니다. 수정이 취소되었습니다.");
                                return;
                        }
                        System.out.println("식비 사용 내역이 수정되었습니다.");
                        break; // 수정된 내역을 찾았으므로 반복문 종료
                    }
                }
                break;
            case 2:
                System.out.println("옷 사용 내역 수정:");
                for (int i = 0; i < cnt; i++) {
                    if (where[i].equals("옷")) {
                        System.out.println("현재 옷 사용 금액: " + a[i]);
                        System.out.println("수정할 옷 사용 금액을 입력하세요:");
                        int updatedClothingExpense = sc.nextInt();

                        System.out.println("1. 더하기");
                        System.out.println("2. 빼기");
                        int expenseChoice = sc.nextInt();

                        switch (expenseChoice) {
                            case 1:
                                a[i] = updatedClothingExpense; // 수정된 값을 할당
                                break;
                            case 2:
                                a[i] = -updatedClothingExpense; // 수정된 값을 할당 (음수로 표현하여 빼기)
                                break;
                            default:
                                System.out.println("잘못된 선택입니다. 수정이 취소되었습니다.");
                                return;
                        }
                        System.out.println("옷 사용 내역이 수정되었습니다.");
                        break; // 수정된 내역을 찾았으므로 반복문 종료
                    }
                }
                break;
            case 3:
                System.out.println("기타 사용 내역 수정:");
                for (int i = 0; i < cnt; i++) {
                    if (where[i].equals("기타")) {
                        System.out.println("현재 기타 사용 금액: " + a[i]);
                        System.out.println("수정할 기타 사용 금액을 입력하세요:");
                        int updatedOtherExpense = sc.nextInt();

                        System.out.println("1. 더하기");
                        System.out.println("2. 빼기");
                        int expenseChoice = sc.nextInt();

                        switch (expenseChoice) {
                            case 1:
                                a[i] = updatedOtherExpense; // 수정된 값을 할당
                                break;
                            case 2:
                                a[i] = -updatedOtherExpense; // 수정된 값을 할당 (음수로 표현하여 빼기)
                                break;
                            default:
                                System.out.println("잘못된 선택입니다. 수정이 취소되었습니다.");
                                return;
                        }
                        System.out.println("기타 사용 내역이 수정되었습니다.");
                        break; // 수정된 내역을 찾았으므로 반복문 종료
                    }
                }
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                return;
        }

        total(); // 수정된 값들을 고려하여 total() 메소드 호출
        sc.close();
    }
}
