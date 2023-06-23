package App.handle;



import App.handle.Money.PlusMoneyMenuItemItem;
import App.handle.Money.ShowMoneyMenuItemItem;
import util.MoneyMenuItem;
import util.MoneyMenuItemGroup;
import util.Prompt;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.List;

import static App.handle.PocketMoney.sc;
import static App.handle.PocketMoney.use;
import static App.print.Title.menu;
import static App.vo.Use.*;


public class PocketMoney2 {
    private MoneyMenuItemGroup moneyMenuItemGroup;
    Prompt prompt = new Prompt();

    public PocketMoney2() {
        moneyMenuItemGroup = new MoneyMenuItemGroup("용돈 관리");

        //메뉴 아이템 생성
        PlusMoneyMenuItemItem plusMoneyMenuItemItem = new PlusMoneyMenuItemItem(this);
        ShowMoneyMenuItemItem showMoneyMenuItemItem = new ShowMoneyMenuItemItem(this);

        // 메뉴 그룹에 메뉴 아이템 추가
        moneyMenuItemGroup.addMenuItem(plusMoneyMenuItemItem);
        moneyMenuItemGroup.addMenuItem(showMoneyMenuItemItem);
    }

    public void execute(){
        printMenu();
        while (true) {
            int menuNO = prompt.inputInt("메뉴를 선택해주세요");
            if(menuNO >= 1 && menuNO <= moneyMenuItemGroup.getMoneyMenuItems().size()){
                MoneyMenuItem moneyMenuItem = moneyMenuItemGroup.getMoneyMenuItems().get(menuNO - 1);
                moneyMenuItem.execute();
            }else{
                System.out.println("잘못 입력하셨습니다.");
            };
        }
    }

    private void printMenu() {
        System.out.println("== 메뉴 ==");
        List<MoneyMenuItem> moneyMenuItems = moneyMenuItemGroup.getMoneyMenuItems();
        for (int i = 0; i < moneyMenuItems.size(); i++) {
            System.out.println((i + 1) + ". " + moneyMenuItems.get(i).toString());
        }
    }

    public void plusMoney() {
        System.out.println("용돈을 추가해주세요");
        try { //오류를 발생시킬수 있는 곳
            use.setMoneyToAdd(sc.nextInt());
            money += use.getMoneyToAdd();
            System.out.println();
            System.out.println("----------");
            System.out.println(use.getMoneyToAdd() + "원 추가되었습니다.");
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
            sc.nextLine();
        }
        menu();
    }

    public void showMoney() {
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




