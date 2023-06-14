package App.handle;

import static App.handle.Choice.sc;
import static App.print.Title.menu;
import static App.vo.Use.*;
import static App.vo.Use.a;

public class Board {
    static String selectedExpense;
    //1번 사용 내역에 관한 내용을 적을수 있도록 코드를 짜보잠ㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅇㅁㄴㅇㅁㄴㅇㅇㅁㄴㄻㄴㄹㄴㄻ
    //음 먼저 사용 내역을 가져와야해
    public static void board() {
        System.out.println("일기를 쓰고 싶은 사용 내역을 선택하세요");
        selectedExpense = sc.next();
        sc.nextLine();
        for (int i = 0; i < cnt; i++) {
            if (where[i].equals(selectedExpense)) {
                System.out.println(selectedExpense + "에 관한 내용을 작성해주세요");
                String comment = sc.nextLine();
                comments[i] = comment;
                break;
            }
            System.out.println(selectedExpense + " 사용 내역이 없습니다.");
        }
        menu();
    }

    public static void readBoard() {
        System.out.println("보고싶은 사용내역을 선택해주세요");
        selectedExpense = sc.next();
        for (int i = 0; i < cnt; i++) {
            if (where[i].equals(selectedExpense)) {
                System.out.println(where[i] + "에 관해 작성한 내용입니다.");
                System.out.println("-----------------------------------");
                System.out.println("|     " +    comments[i] + "       |");
                System.out.println("-----------------------------------");
            }else{
                System.out.println(selectedExpense + " 사용 내역이 없습니다.");
            }
        }
        menu();
    }

}
