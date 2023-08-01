package bitcamp.myapp.handler;

import java.io.IOException;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.vo.Money;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class MoneyAddListener implements ActionListener {

  MoneyDao moneyDao;
  SqlSessionFactory sqlSessionFactory;

  public MoneyAddListener(MoneyDao moneyDao, SqlSessionFactory sqlSessionFactory) {
    this.moneyDao = moneyDao;
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    Money money = new Money();
    money.setwheres(prompt.inputString("어디에? "));
    money.setPrice(prompt.inputInt("얼마? "));

    moneyDao.insert(money);
    try {
      moneyDao.insert(money);
      sqlSessionFactory.openSession(false).commit();
    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
  }

}
