package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberHandler implements Handler {

  private static final int MAX_SIZE = 100; // variable initializer(변수초기화 문장)
  // variable initializer(변수 초기화 문장) => static 블록으로 이동
  // 단 final 변수는 static 블록에서 값을 할당하지 않고 그냥 상수로 취급한다.

  private Prompt prompt; // 외부에서 생성자를 통해 주입
  private Member[] members = new Member[MAX_SIZE]; // variable initializer(변수초기화 문장)
  private int length;
  private String title;

  // 생성자 : 인스턴스를 사용할 수 있도록 유효한 값으로 초기화시키는 일을 한다.
  // => 필요한 값을 외부에서 받고 싶으면 파라미터를 선언하라.
  public MemberHandler(Prompt prompt, String title) {
    this.prompt = prompt;
    this.title = title;
  }


  // Handler 인터페이스에 선언된 대로 메서드를 정의했다.
  // => "Handler 인터페이스를 구현했다"라고 표현한다.
  public void execute() {
    printMenu();

    while (true) {
      String menuNo = prompt.inputString("%s > ", this.title);
      if (menuNo.equals("0")) {
        return;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        this.inputMember();
      } else if (menuNo.equals("2")) {
        this.printMembers();
      } else if (menuNo.equals("3")) {
        this.viewMember();
      } else if (menuNo.equals("4")) {
        this.updateMember();
      } else if (menuNo.equals("5")) {
        this.deleteMember();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }

  private static void printMenu() {
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 조회");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
    System.out.println("0. 메인");
  }

  private void inputMember() {
    if (!this.available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();
    m.setName(prompt.inputString("이름? "));
    m.setEmail(prompt.inputString("이메일? "));
    m.setPassword(prompt.inputString("암호? "));
    m.setGender(inputGender((char) 0));

    this.members[this.length++] = m;
  }

  private void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          toGenderString(m.getGender()));
    }
  }

  private void viewMember() {
    String memberNo = prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("이메일: %s\n", m.getEmail());
        System.out.printf("성별: %s\n", toGenderString(m.getGender()));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  private static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  private void updateMember() {
    String memberNo = this.prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        m.setName(this.prompt.inputString("이름(%s)? ", m.getName()));
        m.setEmail(this.prompt.inputString("이메일(%s)? ", m.getEmail()));
        System.out.printf("새암호? ");
        m.setPassword(this.prompt.inputString(""));
        m.setGender(inputGender(m.getGender()));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  private char inputGender(char gender) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }

    while (true) {
      String menuNo = this.prompt.inputString(label + "  1. 남자\n" + "  2. 여자\n" + "> ");

      switch (menuNo) {
        case "1":
          return Member.MALE;
        case "2":
          return Member.FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  private void deleteMember() {
    int memberNo = this.prompt.inputInt("번호? ");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      members[i] = this.members[i + 1];
    }

    members[--this.length] = null;
  }

  private int indexOf(int memberNo) {
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private boolean available() {
    return this.length < MAX_SIZE;
  }
}