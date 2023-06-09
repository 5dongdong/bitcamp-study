package App.handle.Money;



import App.handle.PlusMenuItem;
import App.handle.ShowMenuItemItem;
import util.Menu.MenuItem;
import util.Menu.MenuGroup;
import util.Prompt;


import java.util.InputMismatchException;


import static App.print.Title.menu;
import static App.vo.Use.*;


public class PocketMoney2 {
    private MenuGroup moneyMenuGroup;

    Prompt prompt = new Prompt();

    public PocketMoney2() {
        moneyMenuGroup = new MenuGroup("용돈 관리");

        //메뉴 아이템 생성
        MenuItem plusMoneyMenuItem = new PlusMenuItem(this);
        MenuItem showMoneyMenuItemItem = new ShowMenuItemItem(this);

        // 메뉴 그룹에 메뉴 아이템 추가
        moneyMenuGroup.addMenuItem(plusMoneyMenuItem);
        moneyMenuGroup.addMenuItem(showMoneyMenuItemItem);
    }



    public void plusMoney() {
        System.out.println("용돈을 추가해주세요");
        try { //오류를 발생시킬수 있는 곳
            int moneyToAdd = prompt.inputInt("추가할 용돈을 입력하세요");
            money += moneyToAdd;
            System.out.println();
            System.out.println("----------");
            System.out.println(moneyToAdd + "원 추가되었습니다.");
            System.out.println("----------");
            System.out.println();
        } catch (InputMismatchException e) { //오류를 잡음
            System.out.println();
            System.out.println("$*$*$*$*$*$*$*$*$");
            System.out.println("-잡았다 오류-");
            System.out.println("$*$*$*$*$*$*$*$*$");
            System.out.println();
            System.out.println("잘못 입력하셨습니다.");
            System.out.println();
            prompt.close();
        }
        menu();
    }

    public static void showMoney() {
        System.out.println();
        System.out.println("==============");
        System.out.println("2. 용돈 확인하기");
        System.out.println("==============");
        System.out.println();

        int totalExpenses = 0;
        for (int i = 0; i < cnt; i++) {
            totalExpenses += expenseList.get(i);
        }

        int remainingMoney = money - totalExpenses;
        System.out.println("=============================");
        System.out.println("    총 사용 금액: " + totalExpenses);
        System.out.println("    남은 용돈: " + remainingMoney);
        System.out.println("=============================");
        System.out.println();

        menu();
    }


}




