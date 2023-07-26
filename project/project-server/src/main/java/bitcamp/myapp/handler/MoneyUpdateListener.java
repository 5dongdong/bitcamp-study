package bitcamp.myapp.handler;

import java.io.IOException;
import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.vo.Money;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class MoneyUpdateListener implements ActionListener {

  MoneyDao moneyDao;

  public MoneyUpdateListener(MoneyDao moneyDao) {
    this.moneyDao = moneyDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    int moneyNo = prompt.inputInt("번호?");

    Money money = moneyDao.findBy(moneyNo);
    if (money == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    money.setwheres(prompt.inputString("어디?(%s)", money.getwheres()));
    money.setPrice(prompt.inputInt("얼마?", money.getPrice()));

    prompt.println("변경완료");
    moneyDao.update(money);
  }
}
