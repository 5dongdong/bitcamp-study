package bitcamp.myapp.vo;

import java.io.Serializable;

public class Money implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static int MoneyNo = 1;
	
	private int no;
	
	private String use;
	
	private int money;
	
	private int addMoney;
	
	public Money() {
		
	}
	
	public Money(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getAddMoney() {
		return addMoney;
	}

	public void setAddMoney(int addMoney) {
		this.addMoney = addMoney;
	}
	
	
}
