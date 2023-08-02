package bitcamp.myapp.handler;

import java.io.IOException;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Servlet;

public interface MemberActionListener extends Servlet {

  static char inputGender(char gender) throws IOException {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", gender == 'M' ? "남성" : "여성");
    }

    while (true) {
      String menuNo = inputString(label + "  1. 남자\n" + "  2. 여자\n" + "> ");

      switch (menuNo) {
        case "1":
          return Member.MALE;
        case "2":
          return Member.FEMALE;
        default:
          println("무효한 번호입니다.");
      }
    }
  }

  static String inputString(String string) {
    // TODO Auto-generated method stub
    return null;
  }

}
