package bitcamp.myapp.handler;

import java.io.IOException;
import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.vo.Money;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class MoneyAddListener implements ActionListener {

  MoneyDao moneyDao;

  public MoneyAddListener(MoneyDao moneyDao) {
    this.moneyDao = moneyDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    Money money = new Money();
    money.setwheres(prompt.inputString("어디에? "));
    money.setPrice(prompt.inputInt("얼마? "));

    moneyDao.insert(money);
  }

}
