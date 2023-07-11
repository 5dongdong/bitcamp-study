package client.bitcamp.myapp.handler;

import client.bitcamp.util.ActionListener;
import client.bitcamp.util.BreadcrumbPrompt;
import common.bitcamp.myapp.dao.MoneyDao;
import common.bitcamp.myapp.vo.Board;
import common.bitcamp.myapp.vo.Money;

public class MoneyUpdateListener implements ActionListener {

    MoneyDao moneyDao;
    public MoneyUpdateListener(MoneyDao moneyDao) {
        this.moneyDao = moneyDao;
    }

    @Override
    public void service(BreadcrumbPrompt prompt) {
        int moneyNo = prompt.inputInt("번호? ");

        Money money = moneyDao.findBy(moneyNo);
        if (money == null) {
            System.out.println("해당 번호가 없습니다.");
            return;
        }

        money.setMoney(prompt.inputInt("사용금액(%s)?", money.getMoney()));

        moneyDao.update(money);
    }
}
