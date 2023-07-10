package org.example.handler;


import org.example.dao.MemberDao;
import org.example.util.ActionListener;
import org.example.util.BreadCrumbPrompt;

public class MemberDeleteListener implements ActionListener {

  MemberDao memberDao;

  public MemberDeleteListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadCrumbPrompt prompt) {
    if (memberDao.delete(prompt.inputInt("번호? ")) == 0) {
      System.out.println("해당 번호의 회원이 없습니다!");
    }
  }

}
