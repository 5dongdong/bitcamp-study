package bitcamp.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import bitcamp.dao.mySQLBoardDao;
import bitcamp.dao.mySQLMemberDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.MoneyDao;
import bitcamp.myapp.handler.BoardAddListener;
import bitcamp.myapp.handler.BoardDeleteListener;
import bitcamp.myapp.handler.BoardDetailListener;
import bitcamp.myapp.handler.BoardListListener;
import bitcamp.myapp.handler.BoardUpdateListener;
import bitcamp.myapp.handler.FooterListener;
import bitcamp.myapp.handler.HeaderListener;
import bitcamp.myapp.handler.HelloListener;
import bitcamp.myapp.handler.LoginListener;
import bitcamp.myapp.handler.MemberAddListener;
import bitcamp.myapp.handler.MemberDeleteListener;
import bitcamp.myapp.handler.MemberDetailListener;
import bitcamp.myapp.handler.MemberListListener;
import bitcamp.myapp.handler.MemberUpdateListener;
import bitcamp.myapp.handler.MoneyAddListener;
import bitcamp.myapp.handler.MoneyListListener;
import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;

public class ClientApp {

  public static Member loginUser;

  MemberDao memberDao;
  BoardDao boardDao;
  BoardDao readingDao;
  MoneyDao moneyDao;

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public ClientApp(String ip, int port) throws Exception {

    Connection con = DriverManager.getConnection("jdbc:mysql://study:11111111@localhost:3306/studydb" // JDBC
                                                                                                  // URL
    );

    this.memberDao = new mySQLMemberDao(con);
    this.boardDao = new mySQLBoardDao(con, 1);
    this.readingDao = new mySQLBoardDao(con, 2);

    prepareMenu();
  }

  public void close() throws Exception {
    prompt.close();
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 2) {
      System.out.println("실행 예) java ... bitcamp.myapp.ClientApp 서버주소 포트번호");
      return;
    }

    ClientApp app = new ClientApp(args[0], Integer.parseInt(args[1]));
    app.execute();
    app.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }

  public void execute() {
    printTitle();

    new LoginListener(memberDao).service(prompt);

    mainMenu.execute(prompt);
  }

  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberDao)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberDao)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberDao)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberDao)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberDao)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("일기장");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardDao)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardDao)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardDao)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardDao)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardDao)));
    mainMenu.add(boardMenu);
    
    MenuGroup moneyMenu = new MenuGroup("가계부");
    moneyMenu.add(new Menu("등록", new MoneyAddListener(moneyDao)));
    moneyMenu.add(new Menu("목록", new MoneyListListener(moneyDao)));
//    boardMenu.add(new Menu("조회", new MonetDetailListener(monryDao)));
//    boardMenu.add(new Menu("변경", new MonetUpdateListener(moneyDao)));
//    boardMenu.add(new Menu("삭제", new MonetDeleteListener(moneyDao)));
    mainMenu.add(moneyMenu);


    
    
  }
}
