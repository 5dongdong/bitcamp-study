package App.handle.board;

import util.Menu.MenuItem;
import util.Prompt;

import static App.handle.board.Board.board;
import static App.handle.board.Board.readBoard;

public class BoardMenu implements MenuItem {
    private Prompt prompt = new Prompt();

    public void execute() {
        while (true) {
            System.out.println("1 : 사용내역에 관한 내용작성");
            System.out.println("2 : 사용내역 내용 보기");

            String menuNo = prompt.inputString("메뉴를 선택하세요: ");
            if (menuNo.equals("1")) {
                board();
            } else if (menuNo.equals("2")) {
                readBoard();
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

}
