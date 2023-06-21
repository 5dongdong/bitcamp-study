package App.handle;


import java.util.ArrayList;

import static App.handle.UsageHistory.sc;
import static App.print.Title.menu;
import static App.vo.Use.*;


public class Board implements Handler{
    static String selectedExpense;
    static ArrayList<String> commentsList = new ArrayList<>();
    //1번 사용 내역에 관한 내용을 적을수 있도록 코드를 짜보자
    //음 먼저 사용 내역을 가져와야해

    String title;
    public Board(String title){
        this.title = title;
    }

    public void execute() {
        printMenu();
        System.out.printf("%s 메뉴를 선택해주세요", title);
        while (true) {
            String menuNo = sc.next();
            if(menuNo.equals("1")) {
                board();
            } else if (menuNo.equals("2")) {
                readBoard();
            } else {
                System.out.println("잘못 입력하셨습니다");
            }
        }
    }


    public void printMenu() {
        System.out.println("1 : 사용내역에 관한 내용작성");
        System.out.println("2 : 사용내역 내용 보기");
    }

    public static void board() {
        System.out.println("일기를 쓰고 싶은 사용 내역을 선택하세요");
        selectedExpense = sc.next();
        sc.nextLine();
        for (int i = 0; i < cnt; i++) {
            if (whereList.get(i).equals(selectedExpense)){
                System.out.println(selectedExpense + "에 관한 내용을 작성해주세요");
                String comment = sc.nextLine();
                commentsList.add(comment);
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
            if (whereList.get(i).equals(selectedExpense)){
                System.out.println(whereList.get(i) + "에 관해 작성한 내용입니다.");
                System.out.println("-----------------------------------");
                System.out.println("|     " +    commentsList.get(i) + "       |");
                System.out.println("-----------------------------------");
            }else{
                System.out.println(selectedExpense + " 사용 내역이 없습니다.");
            }
        }
        menu();
    }

}
