package client.bitcamp.myapp.handler;


import client.bitcamp.util.ActionListener;
import client.bitcamp.util.BreadcrumbPrompt;
import common.bitcamp.myapp.dao.MemberDao;

public class MemberDeleteListener implements ActionListener {

  MemberDao memberDao;

  public MemberDeleteListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (memberDao.delete(prompt.inputInt("번호? ")) == 0) {
      System.out.println("해당 번호의 회원이 없습니다!");
    }
  }

}
