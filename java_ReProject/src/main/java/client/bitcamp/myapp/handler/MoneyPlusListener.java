package client.bitcamp.myapp.handler;

import client.bitcamp.util.ActionListener;
import client.bitcamp.util.BreadcrumbPrompt;
import common.bitcamp.myapp.dao.MoneyDao;
import common.bitcamp.myapp.vo.Money;

public class MoneyPlusListener implements ActionListener {

    MoneyDao moneyDao;
    public MoneyPlusListener(MoneyDao moneyDao) {
        this.moneyDao = moneyDao;
    }

    @Override
    public void service(BreadcrumbPrompt prompt) {
        Money m  = new Money();
        m.setAddMoney(prompt.inputInt("수입 : "));

        moneyDao.insert(m);
    }
}
