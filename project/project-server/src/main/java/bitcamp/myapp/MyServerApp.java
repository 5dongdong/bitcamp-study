package bitcamp.myapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import bitcamp.dao.MySQLMoneyDao;
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
import bitcamp.myapp.handler.MemberAddListener;
import bitcamp.myapp.handler.MemberDeleteListener;
import bitcamp.myapp.handler.MemberDetailListener;
import bitcamp.myapp.handler.MemberListListener;
import bitcamp.myapp.handler.MemberUpdateListener;
import bitcamp.myapp.handler.MoneyAddListener;
import bitcamp.myapp.handler.MoneyDetailListener;
import bitcamp.myapp.handler.MoneyListListener;
import bitcamp.net.NetProtocol;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;

public class MyServerApp {

  // 자바 스레드풀 준비
  ExecutorService threadPool = Executors.newFixedThreadPool(10);

  Connection con;
  MemberDao memberDao;
  BoardDao boardDao;
  BoardDao readingDao;
  MoneyDao moneyDao;

  MenuGroup mainMenu = new MenuGroup("메인");

  int port;

  public MyServerApp(int port) throws Exception {

    this.port = port;

    con = DriverManager.getConnection("jdbc:mysql://study:11111111@localhost:3306/studydb" // JDBC URL
    );

    this.memberDao = new mySQLMemberDao(con);
    this.boardDao = new mySQLBoardDao(con, 1);
    this.moneyDao = new MySQLMoneyDao(con, 2);

    prepareMenu();
  }

  public void close() throws Exception {
    con.close();
  }

  public static void main(String[] args) throws Exception {
    MyServerApp app = new MyServerApp(8888);
    app.execute();
    app.close();
  }

  public void execute() {
    try (ServerSocket serverSocket = new ServerSocket(this.port)) {
      System.out.println("서버 실행 중...");

      while (true) {
        Socket socket = serverSocket.accept();
        threadPool.execute(() -> processRequest(socket));
      }
    } catch (Exception e) {
      System.out.println("서버 실행 오류!");
      e.printStackTrace();
    }
  }

  private void processRequest(Socket socket) {
    try (Socket s = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

      BreadcrumbPrompt prompt = new BreadcrumbPrompt(in, out);

      InetSocketAddress clientAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
      System.out.printf("%s 클라이언트 접속함!\n", clientAddress.getHostString());

      out.writeUTF("[개인 시스템]\n" + "-----------------------------------------");

      // new LoginListener(memberDao).service(prompt);

      mainMenu.execute(prompt);
      out.writeUTF(NetProtocol.NET_END);

    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!");
      e.printStackTrace();
    }
  }

  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("멤버");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberDao)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberDao)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberDao)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberDao)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberDao)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("일기");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardDao)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardDao)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardDao)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardDao)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardDao)));
    mainMenu.add(boardMenu);


    MenuGroup moneyMenu = new MenuGroup("가계부");
    moneyMenu.add(new Menu("등록", new MoneyAddListener(moneyDao)));
    moneyMenu.add(new Menu("목록", new MoneyListListener(moneyDao)));
    moneyMenu.add(new Menu("조회", new MoneyDetailListener(moneyDao)));
    mainMenu.add(moneyMenu);


    // MenuGroup readingMenu = new MenuGroup("가계부");
    // readingMenu.add(new Menu("등록", new BoardAddListener(readingDao)));
    // readingMenu.add(new Menu("목록", new BoardListListener(readingDao)));
    // readingMenu.add(new Menu("조회", new BoardDetailListener(readingDao)));
    // readingMenu.add(new Menu("변경", new BoardUpdateListener(readingDao)));
    // readingMenu.add(new Menu("삭제", new BoardDeleteListener(readingDao)));
    // mainMenu.add(readingMenu);

  }
}
