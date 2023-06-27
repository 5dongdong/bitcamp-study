package App.handle.board;

import util.Menu.MenuItem;

public class BoardMenuItem implements MenuItem {
    private Board board;

    public BoardMenuItem(Board board) {
        this.board = board;
    }

    @Override
    public void execute(){
        board.board();
    }
}

