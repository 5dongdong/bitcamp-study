package App.handle;

import util.List;
import util.Prompt;

import java.util.InputMismatchException;
import java.util.Scanner;

import static App.handle.PocketMoney.use;
import static App.print.Title.menu;
import static App.vo.Use.money;

public class MoneyPlusListener extends AbstractMoneyListener{

    Scanner sc = new Scanner(System.in);
    public MoneyPlusListener(List list) {
        super(list);
    }

    @Override
    public void service(Prompt prompt) {
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

}
