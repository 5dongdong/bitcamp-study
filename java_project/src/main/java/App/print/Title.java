package App.print;


import App.handle.Money.PocketMoneyMenu;
import App.handle.PocketMoney2;
import App.handle.UsageHistoryMenu;
import App.handle.board.BoardMenu;
import util.Menu.MenuGroup;
import util.Menu.MenuItem;
import util.Prompt;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Title implements MenuItem {

    private String title;
    private MenuGroup menuGroup;
    private List<MenuItem> menuItems;


    public Title(String title) {
        this.title = title;
        this.menuGroup = new MenuGroup(title);
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem menuItem){
        menuItems.add(menuItem);
        menuGroup.addMenuItem(menuItem);
    }

    public void execute(){
        menuGroup.execute();
    }

    public static void title() {
        System.out.println("pocket money management");
        System.out.println("==========");
    }

    public static void menu() {
        Prompt prompt = new Prompt();

        Title pocketMoney = new Title("용돈");
        Title usageHistory = new Title("사용내역");
        Title board = new Title("comments");

        PocketMoney2 pocketMoney2 = new PocketMoney2();

        pocketMoney.addMenuItem(new PocketMoneyMenu(pocketMoney2));
        usageHistory.addMenuItem(new UsageHistoryMenu());
        board.addMenuItem(new BoardMenu());



        while (true) {
            System.out.println("1. 용돈 관련");
            System.out.println("2. 사용 내역");
            System.out.println("3. 사용 내역 comments");
            System.out.println("4. 종료");


            String menuNo = prompt.inputString("메뉴를 선택하세요:");
            if (menuNo.equals("4")) {
                System.out.println("종료합니다");
                break;
            } else if (menuNo.equals("1")) {
                pocketMoney.execute();
            } else if (menuNo.equals("2")) {
                usageHistory.execute();
            } else if (menuNo.equals("3")) {
                board.execute();
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }

            System.out.println();
            prompt.inputString("계속하려면 엔터 키를 눌러주세요: ");

        }
    }

    }



