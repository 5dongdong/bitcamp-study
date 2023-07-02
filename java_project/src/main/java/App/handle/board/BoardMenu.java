package App.handle.board;

import util.Menu.MenuItem;
import util.Prompt;

import static App.handle.board.Board.board;
import static App.handle.board.Board.readBoard;
import static App.print.Title.menu;

public class BoardMenu implements MenuItem {
    private Prompt prompt = new Prompt();

    public void execute() {
        while (true) {
            System.out.println("1 : 사용내역에 관한 내용작성");
            System.out.println("2 : 사용내역 내용 보기");
            System.out.println("3 : 돌아가기");

            try {
                String menuNo = prompt.inputString("메뉴를 선택하세요: ");
                if (menuNo.equals("1")) {
                    board();
                } else if (menuNo.equals("2")) {
                    readBoard();
                } else if (menuNo.equals("3")) {
                    return;
                }
            } catch (Exception e) {
                // 예외를 무시하고 계속 실행
                System.out.println("예외가 발생했습니다. 계속 실행합니다.");
            }
            menu();
        }

    }

}
