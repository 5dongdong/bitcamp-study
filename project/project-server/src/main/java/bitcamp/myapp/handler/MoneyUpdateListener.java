package bitcamp.myapp.handler;

import java.io.IOException;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.vo.Money;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class MoneyUpdateListener implements ActionListener {

  MoneyDao moneyDao;
  SqlSessionFactory sqlSessionFactory;

  public MoneyUpdateListener(MoneyDao moneyDao, SqlSessionFactory sqlSessionFactory) {
    this.moneyDao = moneyDao;
    this.sqlSessionFactory = sqlSessionFactory;
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


    try {
      prompt.println("변경했습니다.");
      sqlSessionFactory.openSession(false).commit();
    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }

  }
}
