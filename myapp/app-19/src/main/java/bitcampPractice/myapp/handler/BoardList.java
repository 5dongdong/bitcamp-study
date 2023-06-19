package bitcampPractice.myapp.handler;

import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;

public class BoardList {

    private static final int MAX_SIZE = 100;
    private Board[] boards = new Board[MAX_SIZE];

    private int length = 0;


    public void increase(){
        Board[] bArr = new Board[boards.length + boards.length >> 1];

        for(int  i = 0; i < length; i++) {
            bArr[i] = boards[i];
            boards = bArr;
        }
    }

    public void  add(Board board) {
        if (this.length == boards.length) {
            increase();
        }
        this.boards[this.length++] = board;
    }
    public Board[] bList() {
        Board[] bArr = new Board[this.length];
        for(int i = 0; i < this.length; i++) {
            bArr[i] = this.boards[i];
        }
        return bArr;
    }

    public Board get(int no) {
        for (int i = 0; i < this.length; i++) {
            Board board = this.boards[i];
            if (board.getNo() == no) {
                return board;
            }
        }
        return null;
    }

    public boolean deleted(int no) {
        int deletedIndex = indexOf(no);
        if (deletedIndex == -1) {
            return false;
        }
        for (int i = deletedIndex; i < this.length - 1; i++) {
            this.boards[i] = this.boards[i + 1];
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
