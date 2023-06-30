package App;


import java.io.*;
import java.util.ArrayList;

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
//        saveHistory("History.data", whereList);
//        saveBoard("Board.data", commentsList);
    }

    private static void loadData() {
        loadMoney();
//        loadHistory("History.data", whereList);
//        loadBoard("Board.data", commentsList);
    }

    private void loadBoard(String filename, ArrayList<String> commentsList) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            BufferedInputStream bufferedIn = new BufferedInputStream(fileIn);
            DataInputStream dataIn = new DataInputStream(bufferedIn);

            int size = dataIn.readShort();

            for (int i = 0; i < size; i++) {
                String comment = dataIn.readUTF();
                commentsList.add(comment);
            }

            dataIn.close();
            bufferedIn.close();
            fileIn.close();

            System.out.println("게시판 정보를 성공적으로 로드했습니다.");
        } catch (IOException e) {
            System.out.println("게시판 정보를 로드하는 중 오류 발생: " + e.getMessage());
        }
    }

    private void loadHistory(String filename, ArrayList<String> whereList) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            BufferedInputStream bufferedIn = new BufferedInputStream(fileIn);
            DataInputStream dataIn = new DataInputStream(bufferedIn);

            int size = dataIn.readShort();

            for (int i = 0; i < size; i++) {
                String location = dataIn.readUTF();
                whereList.add(location);
            }

            dataIn.close();
            bufferedIn.close();
            fileIn.close();

            System.out.println("내역 정보를 성공적으로 로드했습니다.");
        } catch (IOException e) {
            System.out.println("내역 정보를 로드하는 중 오류 발생: " + e.getMessage());
        }
    }

    private static void loadMoney() {
        try {
            FileInputStream in0 = new FileInputStream("money.data");
            BufferedInputStream in1 = new BufferedInputStream(in0);
            DataInputStream in = new DataInputStream(in1);

            money = in.readInt();

        }catch (Exception e){
            System.out.println("용돈 정보를 불러오는 중 오류 발생!");
        }
    }

//    private void saveHistory(String filename, ArrayList<String> whereList) {
//        try {
//            FileOutputStream out0 = new FileOutputStream(filename);
//            BufferedOutputStream out1 = new BufferedOutputStream(out0);
//            DataOutputStream out = new DataOutputStream(out1);
//
//            out.writeShort(whereList.size());
//
//            for(int i = 0; i < whereList.size(); i++) {
//                out.writeUTF(whereList.get(i));
//            }
//            out.close();
//
//        } catch (Exception e) {
//            System.out.println("내역 정보를 저장하는 중 오류 발생");
//        }
//    }

//    private void saveBoard(String filename, ArrayList<String> commentsList) {
//        try {
//            FileOutputStream out0 = new FileOutputStream(filename);
//            BufferedOutputStream out1 = new BufferedOutputStream(out0);
//            DataOutputStream out = new DataOutputStream(out1);
//
//            out.writeShort(commentsList.size());
//
//            for(int i = 0; i < commentsList.size(); i++) {
//                out.writeUTF(commentsList.get(i));
//            }
//            out.close();
//
//        } catch (Exception e) {
//            System.out.println("내역 정보를 저장하는 중 오류 발생");
//        }
//    }

    private static void saveMoney() {
        try {
            FileOutputStream out0 = new FileOutputStream("money.data");
            BufferedOutputStream out1 = new BufferedOutputStream(out0);
            DataOutputStream out = new DataOutputStream(out1);


            out.writeInt(money);

            out.close();
            out1.close();
            out0.close();


        } catch (Exception e) {
            System.out.println("용돈 정보를 저장하는 중 오류 발생!");
            e.printStackTrace(); // 오류 메시지 출력
        }
    }
}


