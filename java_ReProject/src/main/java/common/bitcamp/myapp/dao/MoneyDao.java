package common.bitcamp.myapp.dao;

import common.bitcamp.myapp.vo.Money;

import java.util.List;

public interface MoneyDao {

    void insert(Money money);

    List<Money> list();

    Money findBy(int no);

    Money findByString(String use);

    int update(Money money);

    int delete(int no);
}
