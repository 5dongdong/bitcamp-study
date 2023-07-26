package bitcamp.myapp.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Money implements Serializable {
  private static final long serialVersionUID = 1L;


  // 가계부에 필요한거 순서?, 가격, 사용한곳, 사용 날짜 , 의식주.
  private int no;
  private int price;
  private String wheres;
  private Timestamp useDate;

  @Override
  public int hashCode() {
    return Objects.hash(no);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Money other = (Money) obj;
    return no == other.no;
  }



  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getwheres() {
    return wheres;
  }

  public void setwheres(String wheres) {
    this.wheres = wheres;
  }

  public Timestamp getUseDate() {
    return useDate;
  }

  public void setUseDate(Timestamp useDate) {
    this.useDate = useDate;
  }



}
