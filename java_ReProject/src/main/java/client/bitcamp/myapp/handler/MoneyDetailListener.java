package client.bitcamp.myapp.handler;

import client.bitcamp.util.ActionListener;
import client.bitcamp.util.BreadcrumbPrompt;
import common.bitcamp.myapp.dao.MoneyDao;
import common.bitcamp.myapp.vo.Money;

public class MoneyDetailListener implements ActionListener {

    MoneyDao moneyDao;
    public MoneyDetailListener(MoneyDao moneyDao) {
        this.moneyDao = moneyDao;
    }

    @Override
    public void service(BreadcrumbPrompt prompt) {
        int moneyNo = prompt.inputInt("번호?");

        Money m = moneyDao.findBy(moneyNo);
        if (m == null) {
            System.out.println("해당 번호가 없습니다.");
            return;
        }

        System.out.printf("사용한 곳 : %s", m.getUse());
        System.out.println();
        System.out.printf("사용 금액: %d", m.getMoney());
        System.out.println();
    }
}
