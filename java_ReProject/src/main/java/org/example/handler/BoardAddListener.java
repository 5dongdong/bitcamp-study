package org.example.handler;


import org.example.dao.BoardDao;
import org.example.util.ActionListener;
import org.example.util.BreadCrumbPrompt;
import org.example.vo.Board;

public class BoardAddListener implements ActionListener {

  BoardDao boardDao;

  public BoardAddListener(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadCrumbPrompt prompt) {
    Board board = new Board();
    board.setTitle(prompt.inputString("제목? "));
    board.setContent(prompt.inputString("내용? "));
    board.setWriter(prompt.inputString("작성자? "));
    board.setPassword(prompt.inputString("암호? "));

    BoardDao.insert(board);
  }
}


