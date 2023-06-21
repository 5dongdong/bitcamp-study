package bitcamp_Practice.myapp.handler;

import bitcamp_Practice.util.ActionListener;
import bitcamp_Practice.util.List;

public abstract class AbstractMemberListener implements ActionListener {

  protected List list;

  public AbstractMemberListener(List list) {
    this.list = list;
  }

}
