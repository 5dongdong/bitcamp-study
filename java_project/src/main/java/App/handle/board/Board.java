package App.handle.board;

import util.Menu.MenuGroup;
import util.Menu.MenuItem;

import java.util.ArrayList;
import java.util.Scanner;

import static App.print.Title.menu;
import static App.vo.Use.*;


public class Board {

    private MenuGroup menuGroup;
    private static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> commentsList = new ArrayList<>();

    public Board() {
        menuGroup = new MenuGroup("comments");
        menuGroup.addMenuItem(new MenuItem() {
            public void execute() {
                writeBoard();
            }
        });
        menuGroup.addMenuItem(new MenuItem() {
            public void execute() {
                readBoard();
            }
        });
    }

    public void writeBoard() {
        System.out.println("일기를 쓰고 싶은 사용 내역을 선택하세요");
        String selectedExpense = sc.next();
        sc.nextLine();

        boolean expenseFound = false;
        for (int i = 0; i < cnt; i++) {
            if (whereList.get(i).equals(selectedExpense)) {
                System.out.println(selectedExpense + "에 관한 내용을 작성해주세요");
                String comment = sc.nextLine();
                commentsList.add(comment);
                expenseFound = true;
                break;
            }
        }

        if (!expenseFound) {
            System.out.println(selectedExpense + " 사용 내역이 없습니다.");
        }

        menu();
    }

    public void readBoard() {
        System.out.println("보고싶은 사용내역을 선택해주세요");
        String selectedExpense = sc.next();
        sc.nextLine();

        boolean expenseFound = false;
        for (int i = 0; i < cnt; i++) {
            if (whereList.get(i).equals(selectedExpense)) {
                System.out.println(whereList.get(i) + "에 관해 작성한 내용입니다.");
                System.out.println("-----------------------------------");
                System.out.println("|     " + commentsList.get(i) + "       |");
                System.out.println("-----------------------------------");
                expenseFound = true;
                break;
            }
        }

        if (!expenseFound) {
            System.out.println(selectedExpense + " 사용 내역이 없습니다.");
        }

        menu();
    }

    public void execute() {
        menuGroup.execute();
    }
}
