package bitcamp.myapp.handler;

import java.io.IOException;
import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.vo.Money;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class MoneyDeleteListener implements ActionListener {

  MoneyDao moneyDao;

  public MoneyDeleteListener(MoneyDao moneyDao) {
    this.moneyDao = moneyDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {

    Money m = new Money();
    m.setNo(prompt.inputInt("번호"));

    if (moneyDao.delete(m) == 0) {
      prompt.inputString("해당 번호가 없습니다.");
    }
    prompt.println("삭제완료");

  }

}
