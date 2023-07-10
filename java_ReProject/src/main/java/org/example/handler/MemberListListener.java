package org.example.handler;


import org.example.dao.MemberDao;
import org.example.util.ActionListener;
import org.example.util.BreadCrumbPrompt;
import org.example.vo.Member;

import java.util.List;

public class MemberListListener implements ActionListener {

  MemberDao memberDao;

  public MemberListListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadCrumbPrompt prompt) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------------------");

    List<Member> list = memberDao.list();
    for (Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          m.getGender() == 'M' ? "남성" : "여성");
    }
  }

}
