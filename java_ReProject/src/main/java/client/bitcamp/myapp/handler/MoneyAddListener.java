package client.bitcamp.myapp.handler;

import client.bitcamp.util.ActionListener;
import client.bitcamp.util.BreadcrumbPrompt;
import common.bitcamp.myapp.dao.MoneyDao;
import common.bitcamp.myapp.vo.Money;

public class MoneyAddListener implements ActionListener {

    MoneyDao moneyDao;

    public MoneyAddListener(MoneyDao moneyDao) {
        this.moneyDao = moneyDao;
    }

    @Override
    public void service(BreadcrumbPrompt prompt) {
        Money m = new Money();
        m.setUse(prompt.inputString("어디에"));
        m.setMoney(prompt.inputInt("얼마?"));

        moneyDao.insert(m);


    }
}
