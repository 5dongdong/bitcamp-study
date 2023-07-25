package bitcamp.myapp.handler;

import java.text.SimpleDateFormat;
import java.util.List;
import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.vo.Money;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class MoneyListListener implements ActionListener {

  MoneyDao moneyDao;
  SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

  public MoneyListListener(MoneyDao moneyDao) {
    this.moneyDao = moneyDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    prompt.println("-------------------------------");
    prompt.println("번호, 사용처, 가격, 등록일");
    prompt.println("-------------------------------");


    List<Money> list = moneyDao.list();

    for (Money money : list) {
      prompt.printf("%d, %s, %d, %s\n", money.getNo(), money.getwheres(), money.getPrice(),
          dateFormatter.format(money.getUseDate()));
    }
  }

}
