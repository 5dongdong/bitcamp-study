package bitcamp.myapp.dao;

import java.util.List;
import bitcamp.myapp.vo.Money;

public interface MoneyDao {

  void insert(Money money);


  List<Money> list();

  Money findBy(int no);

  Money findByString(String use);

  int update(Money money);

  int delete(int no);


  int delete(Money money);

}
