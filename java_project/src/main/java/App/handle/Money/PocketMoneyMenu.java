package App.handle.Money;

import App.handle.PocketMoney2;
import util.Menu.MenuItem;
import util.Prompt;

import java.util.NoSuchElementException;

import static App.print.Title.menu;


public class PocketMoneyMenu implements MenuItem {
    private  Prompt prompt ;
    private PocketMoney2 pocketMoney2;

    public  PocketMoneyMenu(PocketMoney2 pocketMoney2){
        this.prompt =new Prompt(System.in);
        this.pocketMoney2 = pocketMoney2;
    }

    @Override
    public void execute(){

            System.out.println("1. 용돈 입력");
            System.out.println("2. 용돈 확인");
            System.out.println("3. 이전 메뉴로");



                String menuNo = prompt.inputString("메뉴를 선택하세요: ");

                if (menuNo.equals("1")) {
                    pocketMoney2.plusMoney();
                } else if (menuNo.equals("2")) {
                    pocketMoney2.showMoney();
                } else if (menuNo.equals("3")) {
                    return;
                } else {
                    System.out.println("잘못 입력하셨습니다.");
                    menu();
                }

                menu();
            }

        }

