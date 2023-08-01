package bitcamp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.vo.Money;

public class mySQLMoneyDao implements MoneyDao {

  SqlSessionFactory sqlSessionFactory;

  public mySQLMoneyDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Money money) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    sqlSession.insert("bitcamp.myapp.dao.MoneyDao.insert", money);
  }

  @Override
  public List<Money> findAll() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    return sqlSession.selectList("bitcamp.myapp.dao.MoneyDao.findAll");
  }

  @Override
  public Money findBy(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("moneyNo", no);

    return sqlSession.selectOne("bitcamp.myapp.dao.MoneyDao.findBy", paramMap);
  }

  @Override
  public int update(Money money) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update("bitcamp.myapp.dao.MoneyDao.update", money);
  }

  @Override
  public int delete(Money money) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.delete("bitcamp.myapp.dao.MoneyDao.delete", money);
  }



}
