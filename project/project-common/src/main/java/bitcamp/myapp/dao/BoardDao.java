package bitcamp.myapp.dao;

import java.util.List;

import bitcamp.myapp.vo.Board;

public interface BoardDao {
	void insert(Board board);

	Board findBy(int category, int no);

	int update(Board board);

	int delete(Board board);

	int updateCount(Board board);

	int insertFiles(Board board);

	List<Board> findAll(int category);
}
