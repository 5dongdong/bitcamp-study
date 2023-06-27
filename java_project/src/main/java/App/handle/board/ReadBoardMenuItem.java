package App.handle.board;

import util.Menu.MenuItem;

public class ReadBoardMenuItem implements MenuItem {
    private Board board;

    public ReadBoardMenuItem(Board board) {
        this.board = board;
    }

    @Override
    public void execute() {
        board.readBoard();
    }
}
