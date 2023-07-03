package App.print;


import App.handle.Money.PocketMoneyMenu;
import App.handle.Money.PocketMoney2;
import App.handle.Usage.UsageHistoryMenu;
import App.handle.board.BoardMenu;
import util.Menu.MenuGroup;
import util.Menu.MenuItem;
import util.Prompt;

import java.util.ArrayList;
import java.util.List;


public class Title implements MenuItem {

    private final String title;
    private MenuGroup menuGroup;
    private List<MenuItem> menuItems;
    private static boolean running = true;


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



            while (running) {
                System.out.println("1. 용돈 관련");
                System.out.println("2. 사용 내역");
                System.out.println("3. 사용 내역 comments");
                System.out.println("4. 종료");

                String menuNo = prompt.inputString("메뉴를 선택하세요:");
                switch (menuNo) {
                    case "1":
                        pocketMoney.execute();
                        break;
                    case "2":
                        usageHistory.execute();
                        break;
                    case "3":
                        board.execute();
                        break;
                    case "4":
                        System.out.println("종료합니다");
                        running = false;
                        break;
                    default:
                        System.out.println("잘못 입력하셨습니다.");
                        return;
                }

            }
        }
    }




