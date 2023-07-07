package bitcamp.myapp.dao;

import java.util.List;
import bitcamp.myapp.vo.Board;

public interface BoardDao {
  static void insert(Board board) {
    // TODO Auto-generated method stub

  }

  List<Board> list();

  Board findBy(int no);

  int update(Board board);

  int delete(int no);
}
