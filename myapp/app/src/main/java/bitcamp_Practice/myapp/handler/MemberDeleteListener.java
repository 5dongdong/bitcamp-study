package bitcamp_Practice.myapp.handler;

import bitcamp_Practice.myapp.vo.Member;
import bitcamp_Practice.util.BreadCrumbPrompt;
import bitcamp_Practice.util.List;

public class MemberDeleteListener extends AbstractMemberListener {

  public MemberDeleteListener(List list) {
    super(list);
  }

  @Override
  public void service(BreadCrumbPrompt prompt) {
    if (!list.remove(new Member(prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 회원이 없습니다!");
    }
  }
}
