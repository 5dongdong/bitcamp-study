package bitcampPractice2.bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;

public class BoardList {

    private static final int MAX_SIZE = 100;
    private Board[] boards = new Board[MAX_SIZE];

    private int length = 0;


    public Board[] boardList() {
        Board[] bArr = new Board[length];

        for(int i = 0; i < length; i++) {
            bArr[i] = boards[i];
        }
        return bArr;
    }


    public void add(Board board) {
        if (!this.available()) {
            System.out.println("더이상 입력할 수 없습니다!");
            return;
        }
    }

    public Board get(int no) {
        for (int i = 0; i < this.length; i++) {
            Board board = this.boards[i];
            if (board.getNo() == no) {
                board.setViewCount(board.getViewCount() + 1);
                return board;
            }
        }
        return  null;
    }
    public boolean delete(int no) {
        int deletedIndex = indexOf(no);
        if (deletedIndex == -1) {
            return false;
        }
        for(int i = 0; i < length; i++) {
            this.boards[i] = this.boards[i+1];
        }
        this.boards[--this.length] = null;
        return true;
    }


    private int indexOf(int BoardNo) {
        for (int i = 0; i < this.length; i++) {
            Board board = this.boards[i];
            if (board.getNo() == BoardNo) {
                return i;
            }
        }
        return -1;
    }
    private boolean available() {
        return this.length < MAX_SIZE;
    }
}

