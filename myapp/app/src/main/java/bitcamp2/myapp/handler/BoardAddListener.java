package bitcamp.myapp.handler;

import java.util.List;
import bitcamp.myapp.vo.Board;
import bitcamp.util.BreadCrumbPrompt;

public class BoardAddListener extends AbstractBoardListener {

  public BoardAddListener(List<Board> list) {
    super(list);
  }


  @Override
  public void service(BreadCrumbPrompt prompt) {
    Board board = new Board();
    board.setTitle(prompt.inputString("제목? "));
    board.setContent(prompt.inputString("내용? "));
    board.setWriter(prompt.inputString("작성자? "));
    board.setPassword(prompt.inputString("암호? "));
    this.list.add(board);
  }
}


