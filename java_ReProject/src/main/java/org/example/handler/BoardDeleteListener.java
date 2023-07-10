package org.example.handler;


import org.example.dao.BoardDao;
import org.example.util.ActionListener;
import org.example.util.BreadCrumbPrompt;

public class BoardDeleteListener implements ActionListener {

  BoardDao boardDao;

  public BoardDeleteListener(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadCrumbPrompt prompt) {
    if (boardDao.delete(prompt.inputInt("번호? ")) == 0) {
      System.out.println("해당 번호의 게시글이 없습니다!");
    }
  }
}


