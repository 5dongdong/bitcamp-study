package org.example;

import org.example.dao.BoardDao;
import org.example.dao.BoardListDao;
import org.example.dao.MemberDao;
import org.example.dao.MemberListDao;
import org.example.handler.*;
import org.example.util.BreadCrumbPrompt;
import org.example.util.Menu;
import org.example.util.MenuGroup;
import org.example.vo.Board;

import java.util.LinkedList;


public class App {

    MemberDao memberDao = new MemberListDao("member.json");
    BoardDao boardDao = new BoardListDao("board.json");
    BoardDao readingDao = new BoardListDao("reading.json");

    LinkedList<Board> boardList = new LinkedList<>();
    LinkedList<Board> readingList = new LinkedList<>();

    BreadCrumbPrompt prompt = new BreadCrumbPrompt();

    MenuGroup mainMenu = new MenuGroup("메인");

    public App() {
        prepareMenu();
    }

    public static void main(String[] args) {
        new App().execute();
    }

    static void printTitle() {
        System.out.println("나의 목록 관리 시스템");
        System.out.println("----------------------------------");
    }

    public void execute() {
        printTitle();
        mainMenu.execute(prompt);
        prompt.close();
    }

    private void prepareMenu() {
        MenuGroup memberMenu = new MenuGroup("회원");
        memberMenu.add(new Menu("등록", new MemberAddListener(memberDao)));
        memberMenu.add(new Menu("목록", new MemberListListener(memberDao)));
        memberMenu.add(new Menu("조회", new MemberDetailListener(memberDao)));
        memberMenu.add(new Menu("변경", new MemberUpdateListener(memberDao)));
        memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberDao)));
        mainMenu.add(memberMenu);

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

        Menu helloMenu = new Menu("안녕!");
        helloMenu.addActionListener(new HeaderListener());
        helloMenu.addActionListener(new HelloListener());
        helloMenu.addActionListener(new FooterListener());
        mainMenu.add(helloMenu);
    }
}
