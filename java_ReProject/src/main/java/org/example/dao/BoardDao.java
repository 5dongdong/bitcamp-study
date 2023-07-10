package org.example.dao;

import org.example.vo.Board;

import java.util.List;


public interface BoardDao {
  static void insert(Board board) {
    // TODO Auto-generated method stub

  }

  List<Board> list();

  Board findBy(int no);

  int update(Board board);

  int delete(int no);
}
