package client.bitcamp.myapp.handler;

import client.bitcamp.util.ActionListener;
import client.bitcamp.util.BreadcrumbPrompt;
import common.bitcamp.myapp.dao.MoneyDao;
import common.bitcamp.myapp.vo.Money;

import java.util.List;

public class MoneyListListener implements ActionListener {

    MoneyDao moneyDao;

    public MoneyListListener(MoneyDao moneyDao) {
        this.moneyDao = moneyDao;
    }

    @Override
    public void service(BreadcrumbPrompt prompt) {
        System.out.println("--------------------------");
        System.out.println("번호, 사용처, 사용금액");
        System.out.println("--------------------------");

        List<Money> list = moneyDao.list();
        for(Money m : list) {
            System.out.printf("%d, %s, %d\n",
                    m.getNo(),m.getUse(),m.getMoney());
        }
    }
}
