package bitcamp.myapp.handler;

import java.io.IOException;
import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.vo.Money;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.DataSource;

public class MoneyAddListener implements ActionListener {

  MoneyDao moneyDao;
  DataSource ds;

  public MoneyAddListener(MoneyDao moneyDao, DataSource ds) {
    this.moneyDao = moneyDao;
    this.ds = ds;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    Money money = new Money();
    money.setwheres(prompt.inputString("어디에? "));
    money.setPrice(prompt.inputInt("얼마? "));

    moneyDao.insert(money);
    try {
      ds.getConnection().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
