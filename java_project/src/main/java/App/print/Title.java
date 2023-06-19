package App.print;


import App.handle.Board;
import App.handle.Handler;
import App.handle.PocketMoney;
import App.handle.UsageHistory;
import java.util.Scanner;


public class Title {

    static Scanner sc = new Scanner(System.in);

    static Handler pocketMoney = new PocketMoney("용돈");
    static Handler usageHistory = new UsageHistory("사용한 곳");
    static Handler board = new Board("comments");

    public static void title() {
        System.out.println("pocket money management");
        System.out.println("==========");
    }

    public static void menu() {
        System.out.println("1. 용돈 관련");
        System.out.println("2. 사용 내역");
        System.out.println("3. 사용 내역 comments");
        System.out.println("4. 종료");

        while (true) {
            String menuNO = sc.next();
            if(menuNO.equals("4")) {
                System.out.println("종료합니다");
                break;
            }else if(menuNO.equals("1")) {
                pocketMoney.execute();
            }else if (menuNO.equals("2")) {
                usageHistory.execute();
            }else if(menuNO.equals("3")) {
                board.execute();
            }else{
                System.out.println("잘못 입력하셨습니다.");
                menu();
            }
        }
    }
}


