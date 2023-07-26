package bitcamp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.vo.Money;
import bitcamp.util.DataSource;

public class mySQLMoneyDao implements MoneyDao {

  DataSource ds;

  public mySQLMoneyDao(DataSource ds) {
    this.ds = ds;
  }

  @Override
  public void insert(Money money) {
    try (PreparedStatement stmt = ds.getConnection(false)
        .prepareStatement("insert into project_wheres(wheres,price)" + " values(?,?)")) {

      stmt.setString(1, money.getwheres());
      stmt.setInt(2, money.getPrice());

      stmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public List<Money> list() {
    try (PreparedStatement stmt = ds.getConnection(false).prepareStatement("select" + " money_no, "
        + " wheres, " + "  price, " + "  created_date" + " from project_wheres")) {

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
    try (PreparedStatement stmt =
        ds.getConnection().prepareStatement("select" + "  money_no, " + "  wheres, " + "  price,"
            + "  created_date " + " from project_wheres where money_no=?")) {

      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Money m = new Money();
          m.setNo(rs.getInt("money_no"));
          m.setwheres(rs.getString("wheres"));
          m.setPrice(rs.getInt("price"));
          m.setUseDate(rs.getTimestamp("created_date"));

          return m;
        }
        return null;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int update(Money money) {
    try (PreparedStatement stmt = ds.getConnection(false).prepareStatement(
        " update project_wheres " + " set wheres=? , price=? " + " where money_no=? ")) {

      stmt.setString(1, money.getwheres());
      stmt.setInt(2, money.getPrice());
      stmt.setInt(3, money.getNo());

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(Money money) {
    try (PreparedStatement stmt = ds.getConnection(false)
        .prepareStatement("delete from project_wheres" + " where money_no=?")) {

      stmt.setInt(1, money.getNo());

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }



}
