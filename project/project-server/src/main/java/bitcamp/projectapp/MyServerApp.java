package bitcamp.projectapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import bitcamp.dao.mySQLMoneyDao;
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
import bitcamp.myapp.handler.MoneyDeleteListener;
import bitcamp.myapp.handler.MoneyDetailListener;
import bitcamp.myapp.handler.MoneyListListener;
import bitcamp.myapp.handler.MoneyUpdateListener;
import bitcamp.net.NetProtocol;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;
import bitcamp.util.SqlSessionFactoryProxy;

public class MyServerApp {

  // 자바 스레드풀 준비
  ExecutorService threadPool = Executors.newFixedThreadPool(10);

  SqlSessionFactory sqlSessionFactory;

  MemberDao memberDao;
  BoardDao boardDao;
  BoardDao readingDao;
  MoneyDao moneyDao;

  MenuGroup mainMenu = new MenuGroup("메인");

  int port;

  public MyServerApp(int port) throws Exception {

    this.port = port;

    // 1) mybatis 설정 파일을 읽어들일 도구 준비

    InputStream mybatisConfigIn =
        Resources.getResourceAsStream("bitcamp/project/config/mybatis-config.xml");

    // 2) SqlSessionFactory를 만들어줄 빌더 객체 준비
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

    // 3) 빌더 객체를 통해 SqlSessionFactory를 생성
    sqlSessionFactory = new SqlSessionFactoryProxy(builder.build(mybatisConfigIn));

    // this.memberDao = new mySQLMemberDao(sqlSessionFactory);
    // this.boardDao = new mySQLBoardDao(ds, 1);
    this.moneyDao = new mySQLMoneyDao(sqlSessionFactory);

    prepareMenu();
  }

  public void close() throws Exception {}

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
    } finally {
      ((SqlSessionFactoryProxy) sqlSessionFactory).clean();
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
    moneyMenu.add(new Menu("등록", new MoneyAddListener(moneyDao, sqlSessionFactory)));
    moneyMenu.add(new Menu("목록", new MoneyListListener(moneyDao)));
    moneyMenu.add(new Menu("조회", new MoneyDetailListener(moneyDao)));
    moneyMenu.add(new Menu("변경", new MoneyUpdateListener(moneyDao, sqlSessionFactory)));
    moneyMenu.add(new Menu("삭제", new MoneyDeleteListener(moneyDao)));

    mainMenu.add(moneyMenu);


  }
}
