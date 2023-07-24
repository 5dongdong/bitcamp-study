package bitcamp.myapp.handler;

import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.vo.Money;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class MoneyAddListener implements ActionListener{

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
