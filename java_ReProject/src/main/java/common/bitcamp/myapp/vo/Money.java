package common.bitcamp.myapp.vo;

import java.io.Serializable;

public class Money implements Serializable, CsvObject, AutoIncrement {
    private static final long serialVersionUID = 1L;

    public static int MoneyNo = 1;

    private int no;

    private String use;
    private int money;


    public Money() {}

    public Money(int no) {
        this.no = no;
    }

    public static Money fromCsv(String csv) {
        String[] values = csv.split(",");

        Money money = new Money(Integer.parseInt(values[0]));
        money.setUse(values[1]);
        money.setMoney(Integer.parseInt(values[2]));

        if (Money.MoneyNo <= money.getNo()) {
            Money.MoneyNo = money.getNo() + 1;
        }

        return money;
    }


    @Override
    public String toCsvString() {
        return String.format("%d,%d",
                this.getNo(),
                this.getMoney());
    }

    @Override
    public void updateKey() {
        if (Member.userId <= this.no) {
            Member.userId = this.no + 1;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Member m = (Member) obj;
        if (this.getNo() != m.getNo()) {
            return false;
        }
        return true;
    }

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }
}
