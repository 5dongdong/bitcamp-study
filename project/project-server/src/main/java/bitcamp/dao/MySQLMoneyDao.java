package bitcamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.vo.Money;

public class MySQLMoneyDao implements MoneyDao {

  Connection con;
  int category;

  public MySQLMoneyDao(Connection con, int category) {
    this.con = con;
    this.category = category;
  }

  @Override
  public void insert(Money moeny) {
    try (PreparedStatement stmt =
        con.prepareStatement("insert into myapp_board(title,content,writer,password,category)"
            + " values(?,?,?,sha1(?),?)")) {

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public List<Money> list() {
    try (PreparedStatement stmt = con.prepareStatement("select" + " money_no, " + " wheres, "
        + "  price, " + "  created_date" + " from project_wheres")) {

      try (ResultSet rs = stmt.executeQuery()) {
        List<Money> list = new ArrayList<>();
        while (rs.next()) {
          Money m = new Money();
          m.setNo(rs.getInt("money_no"));
          m.setwheres(rs.getString("wheres"));
          m.setPrice(rs.getInt("price"));
          m.setUseDate(rs.getTimestamp("created_date"));
          list.add(m);
        }
        return list;
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Money findBy(int no) {
	  try(PreparedStatement stmt = )
    return null;
  }

  @Override
  public int update(Money money) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int delete(Money money) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Money findByString(String use) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int delete(int no) {
    // TODO Auto-generated method stub
    return 0;
  }

}
