package org.example.handler;


import org.example.dao.MemberDao;
import org.example.util.BreadCrumbPrompt;
import org.example.vo.Member;

public class MemberAddListener implements MemberActionListener {

  MemberDao memberDao;

  public MemberAddListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadCrumbPrompt prompt) {
    Member m = new Member();
    m.setName(prompt.inputString("이름? "));
    m.setEmail(prompt.inputString("이메일? "));
    m.setPassword(prompt.inputString("암호? "));
    m.setGender(MemberActionListener.inputGender((char) 0, prompt));

    memberDao.insert(m);
  }
}
