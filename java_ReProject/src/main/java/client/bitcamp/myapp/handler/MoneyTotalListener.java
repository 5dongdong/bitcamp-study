package client.bitcamp.myapp.handler;

import client.bitcamp.util.ActionListener;
import client.bitcamp.util.BreadcrumbPrompt;
import common.bitcamp.myapp.dao.MoneyDao;
import common.bitcamp.myapp.vo.Money;

import java.util.List;

public class MoneyTotalListener implements ActionListener {
    MoneyDao moneyDao;
    public MoneyTotalListener(MoneyDao moneyDao) {
        this.moneyDao = moneyDao;
    }

    @Override
    public void service(BreadcrumbPrompt prompt) {

        int total = 0;
        System.out.println("--------------------------");
        System.out.println("총 사용 금액");
        System.out.println("--------------------------");

        List<Money> list = moneyDao.list();
        for(Money m : list){
            total += m.getMoney();
        }
            System.out.printf("%d\n" , total);
    }
}
