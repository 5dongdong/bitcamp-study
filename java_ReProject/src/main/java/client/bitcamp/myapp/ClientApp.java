package client.bitcamp.myapp;


import client.bitcamp.dao.DaoBuilder;
import client.bitcamp.myapp.handler.*;
import client.bitcamp.util.BreadcrumbPrompt;
import client.bitcamp.util.Menu;
import client.bitcamp.util.MenuGroup;
import common.bitcamp.myapp.dao.BoardDao;
import common.bitcamp.myapp.dao.MemberDao;
import common.bitcamp.myapp.dao.MoneyDao;

public class ClientApp {


  MemberDao memberDao;
  BoardDao boardDao;
  BoardDao readingDao;

  MoneyDao moneyDao;

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public ClientApp(String ip, int port) throws Exception {


    DaoBuilder daoBuilder = new DaoBuilder(ip, port);

    this.memberDao = daoBuilder.build("member", MemberDao.class);
    this.boardDao = daoBuilder.build("board", BoardDao.class);
    this.readingDao = daoBuilder.build("reading", BoardDao.class);
    this.moneyDao = daoBuilder.build("money", MoneyDao.class);


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
    mainMenu.execute(prompt);
  }

  private void prepareMenu() {
//    MenuGroup memberMenu = new MenuGroup("회원");
//    memberMenu.add(new Menu("등록", new MemberAddListener(memberDao)));
//    memberMenu.add(new Menu("목록", new MemberListListener(memberDao)));
//    memberMenu.add(new Menu("조회", new MemberDetailListener(memberDao)));
//    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberDao)));
//    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberDao)));
//    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardDao)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardDao)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardDao)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardDao)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardDao)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("독서록");
    readingMenu.add(new Menu("등록", new BoardAddListener(readingDao)));
    readingMenu.add(new Menu("목록", new BoardListListener(readingDao)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(readingDao)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(readingDao)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(readingDao)));
    mainMenu.add(readingMenu);

    MenuGroup moneyMenu = new MenuGroup("용돈");
    moneyMenu.add(new Menu("등록", new MoneyAddListener(moneyDao)));
    moneyMenu.add(new Menu("목록", new MoneyListListener(moneyDao)));
    moneyMenu.add(new Menu("조회", new MoneyDetailListener(moneyDao)));
    moneyMenu.add(new Menu("변경", new MoneyUpdateListener(moneyDao)));
    moneyMenu.add(new Menu("삭제", new MoneyDeleteListener(moneyDao)));
    mainMenu.add(moneyMenu);

  }
}
