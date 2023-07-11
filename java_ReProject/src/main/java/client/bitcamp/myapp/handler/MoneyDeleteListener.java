package client.bitcamp.myapp.handler;

import client.bitcamp.util.ActionListener;
import client.bitcamp.util.BreadcrumbPrompt;
import common.bitcamp.myapp.dao.MoneyDao;

public class MoneyDeleteListener implements ActionListener {

    MoneyDao moneyDao;

    public MoneyDeleteListener(MoneyDao moneyDao) {
        this.moneyDao = moneyDao;
    }

    @Override
    public void service(BreadcrumbPrompt prompt) {
        if(moneyDao.delete(prompt.inputInt("번호?")) == 0) {
            System.out.println("해당 번호의 게시글이 없습니다.");
        }
    }
}
