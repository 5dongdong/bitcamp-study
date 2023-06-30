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
    private static String selectedExpense;
    public static ArrayList<String> commentsList = new ArrayList<>();


    String title;
    public Board(String title){
        this.title = title;
    }


    public void execute() {
//        printMenu();
        System.out.print(" 메뉴를 선택해주세요");
        while (true) {
            String menuNo = sc.next();
            if(menuNo.equals("1")) {
                MenuItem menuItem = menuGroup.getMenuItems().get(0);
                menuItem.execute();
            } else if (menuNo.equals("2")) {
                MenuItem menuItem = menuGroup.getMenuItems().get(1);
                menuItem.execute();
            } else if(menuNo.equals("3")){
                MenuItem menuItem = menuGroup.getMenuItems().get(2);
                menuItem.execute();
            }
        }
    }


//    public void printMenu() {
//        System.out.println("1 : 사용내역에 관한 내용작성");
//        System.out.println("2 : 사용내역 내용 보기");
//        System.out.println("3 : 돌아가기");
//    }

    public static void board() {
        System.out.println("일기를 쓰고 싶은 사용 내역을 선택하세요");
        selectedExpense = sc.next();
        sc.nextLine();

        for (int i = 0; i < cnt; i++) {
            if (whereList.get(i).equals(selectedExpense)){
                System.out.println(selectedExpense + "에 관한 내용을 작성해주세요");
                String comment = sc.nextLine();
                commentsList.add(comment);
                return;
            }else {
                System.out.println(selectedExpense + " 사용 내역이 없습니다.");
                break;
            }
        }
        sc.nextLine();
        sc.close();
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
