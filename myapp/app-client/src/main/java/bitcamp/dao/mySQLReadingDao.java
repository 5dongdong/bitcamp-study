package bitcamp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;

public class mySQLReadingDao implements BoardDao {

  Connection con;

  public mySQLReadingDao(Connection con) {
    this.con = con;
  }

  @Override
  public List<Board> list() {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select board_no, title, content, writer from myapp_board order by title asc")) {

      List<Board> list2 = new ArrayList<>();

      while (rs.next()) {
        Board b = new Board();
        b.setNo(rs.getInt("board_no"));
        b.setTitle(rs.getString("title"));
        b.setContent(rs.getString("content"));
        b.setWriter(rs.getString("writer"));

        list2.add(b);
      }

      return list2;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Board findBy(int no) {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select board_no, title, content, writer from myapp_board order by title asc")) {


      if (rs.next()) {
        Board b = new Board();
        b.setNo(rs.getInt("board_no"));
        b.setTitle(rs.getString("title"));
        b.setContent(rs.getString("content"));
        b.setWriter(rs.getString("writer"));
        return b;
      }

      return null;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int update(Board board) {
    try (Statement stmt = con.createStatement()) {

      return stmt.executeUpdate(String.format(
          "update myapp_board set" + " title='%s' ," + " content='%s'," + " password='%s',"
              + " writer ='%s'" + " where board_no =%d",

          board.getTitle(), board.getContent(), board.getPassword(), board.getWriter(),
          board.getNo()));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(int no) {
    try (Statement stmt = con.createStatement()) {

      return stmt.executeUpdate(String.format("delete from myapp_board where board_no = %d", no));

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void insert(Board board) {
    try (Statement stmt = con.createStatement()) {

      stmt.executeUpdate(String.format(
          "insert into myapp_board(title, content, writer, password, category) values('%s', '%s','%s','%s', '%d')",
          board.getTitle(), board.getContent(), board.getWriter(), board.getPassword(),
          board.getCategory()));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
