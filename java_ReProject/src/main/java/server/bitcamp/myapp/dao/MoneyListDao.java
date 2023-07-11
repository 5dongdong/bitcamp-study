package server.bitcamp.myapp.dao;

import common.bitcamp.myapp.dao.MoneyDao;
import common.bitcamp.myapp.vo.Money;
import server.bitcamp.util.JsonDataHelper;

import java.util.ArrayList;
import java.util.List;

public class MoneyListDao implements MoneyDao {

    String filename;
    ArrayList<Money> list = new ArrayList<>();

    public MoneyListDao(String filename) {
        this.filename = filename;
        JsonDataHelper.loadJson(filename, list, Money.class);
    }

    @Override
    public void insert(Money money) {
        money.setNo(Money.MoneyNo++);
        this.list.add(money);
        JsonDataHelper.saveJson(filename, list);
    }

    @Override
    public List<Money> list() {
        return this.list;
    }

    @Override
    public Money findBy(int no) {
        for(int i = 0; i < this.list.size(); i++) {
            Money m = this.list.get(i);
            if(m.getNo() == no) {
                return m;
            }
        }
        return null;
    }

    @Override
    public int update(Money money) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getNo() == money.getNo()) {
                list.set(i, money);
                JsonDataHelper.saveJson(filename, list);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int delete(int no) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getNo() == no) {
                list.remove(i);
                JsonDataHelper.saveJson(filename, list);
                return 1;
            }
        }
        return 0;
    }
}
