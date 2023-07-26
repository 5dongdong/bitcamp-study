package bitcamp.myapp.handler;

import java.io.IOException;

import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.vo.Money;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class MoneyDetailListener implements ActionListener {

	MoneyDao moneyDao;
	
	public MoneyDetailListener(MoneyDao moneyDao) {
		this.moneyDao = moneyDao;
	}

	@Override
	public void service(BreadcrumbPrompt prompt) throws IOException {
		int moneyNo = prompt.inputInt("번호? ");
		
		Money money  = moneyDao.findBy(moneyNo);
		if (money == null) {
			System.out.println("해당 번호의 게시글이 없습니다!");
			return;
		}
		
		System.out.printf("where: %s\n", money.getwheres());
		System.out.printf("price: %d\n", money.getPrice());
		System.out.printf("where: %s\n", money.getwheres());
		System.out.printf("등록일: %tY-%1$tm-%1$td\n", money.getUseDate());

	}

}
