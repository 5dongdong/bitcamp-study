package App;


import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static App.handle.UsageHistory.localDateTimeArrayList;
import static App.handle.board.Board.commentsList;
import static App.print.Title.menu;
import static App.print.Title.title;
import static App.vo.Use.*;

public class Main {


    public static void main(String[] args) {
        loadData();
        title();
        menu();
        saveData();

    }

    private static void saveData() {
        saveMoney();
        saveHistory();
        saveBoard();
    }

    private static void loadData() {
        loadMoney();
        loadHistory();
        loadBoard();
    }

    private static void loadBoard() {
        try {
            FileInputStream in0 = new FileInputStream("Board.data");
            BufferedInputStream in1 = new BufferedInputStream(in0);
            DataInputStream in = new DataInputStream(in1);

            int size = in.readShort();
            cnt = size;

            for (int i = 0; i < size; i++) {
                String comment = in.readUTF();
                commentsList.add(comment);
            }

            in.close();

            System.out.println("게시판 정보를 성공적으로 로드했습니다.");
        } catch (IOException e) {
            System.out.println("게시판 정보를 로드하는 중 오류 발생");
        }
    }

    private static void loadHistory() {
        try {
            FileInputStream in0 = new FileInputStream("History.data");
            BufferedInputStream in1 = new BufferedInputStream(in0);
            DataInputStream in = new DataInputStream(in1);


            int size = in.readInt();
            cnt = size;

            whereList.clear(); // 기존 내역 초기화
            expenseList.clear();


            for(int i = 0; i < size; i++) {
                String where = in.readUTF();
                int expense = in.readInt();
                String dataTime = in.readUTF();

                whereList.add(where);
                expenseList.add(expense);
                localDateTimeArrayList.add(LocalDateTime.parse(dataTime));
            }

            in.close();

            System.out.println("내역 정보를 성공적으로 로드했습니다.");
        } catch (IOException e) {
            System.out.println("내역 정보를 로드하는 중 오류 발생. " );
        }
    }

    private static void loadMoney() {
        try {
            FileInputStream in0 = new FileInputStream("money.data");
            BufferedInputStream in1 = new BufferedInputStream(in0);
            DataInputStream in = new DataInputStream(in1);

            money = in.readInt();

            System.out.println("내역 정보를 성공적으로 로드했습니다.");
        }catch (Exception e){
            System.out.println("용돈 정보를 불러오는 중 오류 발생!");
        }
    }

    private static void saveHistory() {
        try {
            FileOutputStream out0 = new FileOutputStream("History.data");
            BufferedOutputStream out1 = new BufferedOutputStream(out0);
            DataOutputStream out = new DataOutputStream(out1);

            int size = whereList.size();
            out.writeInt(size);

            for(int i = 0; i < size; i++) {
                out.writeUTF(whereList.get(i));
                out.writeInt(expenseList.get(i));
                out.writeUTF(localDateTimeArrayList.get(i).toString());
            }
            out.close();

            System.out.println("내역 정보를 성공적으로 저장했습니다.");
        } catch (Exception e) {
            System.out.println("내역 정보를 저장하는 중 오류 발생");
        }
    }

    private static void saveBoard() {
        try {
            FileOutputStream out0 = new FileOutputStream("Board.data");
            BufferedOutputStream out1 = new BufferedOutputStream(out0);
            DataOutputStream out = new DataOutputStream(out1);

            int size = commentsList.size();
            out.writeInt(size);


            for(int i = 0; i < size; i++) {
                out.writeUTF(commentsList.get(i));
            }
            out.close();
            System.out.println("내역 정보를 성공적으로 저장했습니다.");
        } catch (Exception e) {
            System.out.println("내역 정보를 저장하는 중 오류 발생");
        }
    }

    private static void saveMoney() {
        try {
            FileOutputStream out0 = new FileOutputStream("money.data");
            BufferedOutputStream out1 = new BufferedOutputStream(out0);
            DataOutputStream out = new DataOutputStream(out1);


            out.writeInt(money);

            out.close();
            out1.close();
            out0.close();

            System.out.println("내역 정보를 성공적으로 저장했습니다.");
        } catch (Exception e) {
            System.out.println("용돈 정보를 저장하는 중 오류 발생!");
        }
    }
}


