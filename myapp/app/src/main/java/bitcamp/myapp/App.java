package bitcamp.myapp;

import bitcamp.myapp.handler.BoardHandler;
import bitcamp.myapp.handler.MemberHandler;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {

    BoardHandler boardHandler = new BoardHandler();
    BoardHandler readingHandler = new BoardHandler();

    printTitle();
    printMenu();


    while (true) {
      String menuNo = Prompt.inputString("메인 > ");
      if (menuNo.equals("99")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        MemberHandler.inputMember();
      } else if (menuNo.equals("2")) {
        MemberHandler.printMembers();
      } else if (menuNo.equals("3")) {
        MemberHandler.viewMember();
      } else if (menuNo.equals("4")) {
        MemberHandler.updateMember();
      } else if (menuNo.equals("5")) {
        MemberHandler.deleteMember();
      } else if (menuNo.equals("6")) {
        boardHandler.inputBoard();
      } else if (menuNo.equals("7")) {
        boardHandler.printBoards();
      } else if (menuNo.equals("8")) {
        boardHandler.viewBoard();
      } else if (menuNo.equals("9")) {
        boardHandler.updateBoard();
      } else if (menuNo.equals("10")) {
        boardHandler.deleteBoard();
      } else if (menuNo.equals("11")) {
        readingHandler.inputBoard();
      } else if (menuNo.equals("12")) {
        readingHandler.printBoards();
      } else if (menuNo.equals("13")) {
        readingHandler.viewBoard();
      } else if (menuNo.equals("14")) {
        readingHandler.updateBoard();
      } else if (menuNo.equals("15")) {
        readingHandler.deleteBoard();
      } else {
        System.out.println(menuNo);
      }
    }

    Prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 회원 등록");
    System.out.println("2. 회원 목록");
    System.out.println("3. 회원 조회");
    System.out.println("4. 회원 변경");
    System.out.println("5. 회원 삭제");
    System.out.println("6. 게시글 등록");
    System.out.println("7. 게시글 목록");
    System.out.println("8. 게시글 조회");
    System.out.println("9. 게시글 변경");
    System.out.println("10. 게시글 삭제");
    System.out.println("11. 독서록 등록");
    System.out.println("12. 독서록 목록");
    System.out.println("13. 독서록 조회");
    System.out.println("14. 독서록 변경");
    System.out.println("15. 독서록 삭제");
    System.out.println("99. 종료");
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }

}
