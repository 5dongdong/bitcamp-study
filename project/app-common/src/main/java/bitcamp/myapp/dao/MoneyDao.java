package bitcamp.myapp.dao;

import java.util.List;
import bitcamp.myapp.vo.Money;

public interface MoneyDao {
    void insert(Money money);

    List<Money> findAll();

    Money findBy(int no);

    int update(Money money);

    int delete(Money money);

}