package common.bitcamp.myapp.dao;


import common.bitcamp.myapp.vo.Board;
import java.util.List;

public interface BoardDao {
    void insert(Board board);
    List<Board> list();
  Board findBy(int no);
  int update(Board board);
  int delete(int no);
}
