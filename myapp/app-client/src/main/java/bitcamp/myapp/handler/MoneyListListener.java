package bitcamp.myapp.handler;

import java.util.List;

import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.vo.Money;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class MoneyListListener implements ActionListener{

	MoneyDao moneydao;
	
	public MoneyListListener(MoneyDao moneydao) {
		this.moneydao = moneydao;
	}
	
	
	@Override
	public void service(BreadcrumbPrompt prompt) {
		System.out.println("----------------------");
		System.out.println("번호, 사용처, 사용금액");
		System.out.println("----------------------");
		
		List<Money> list = moneydao.list();
		for(Money m : list) {
			System.out.printf("%d, %s, %d\n",
					m.getNo(), m.getUse(), m.getMoney());
		}
	}

}
