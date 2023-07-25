package bitcamp.test2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;

public class CalcServer_test1 {

  static HashMap<String, Integer> resultMap = new HashMap<>();

  public static void main(String[] args) throws Exception {

    class RequestAgent extends Thread {
      Socket socket;

      public RequestAgent(Socket socket) {
        this.socket = socket;
      }

      @Override
      public void run() {
        processRequest(socket);
      }
    }

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행!");

      while (true) {
        System.out.println("클라이언트 요청을 기다리는 중");
        new RequestAgent(serverSocket.accept()).start();
        System.out.println("클라이언트 요청을 RequestAgent에게 위임");
      }
    }
  }

  static void processRequest(Socket socket) {
    InetSocketAddress sockAddr = (InetSocketAddress) socket.getRemoteSocketAddress();
    System.out.printf("%s(%d) 클라이언트 접속!\n", sockAddr.getHostString(), sockAddr.getPort());

    try (Socket s = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

      int result = 0;
      String uuid = in.readUTF();

      if (uuid.length() == 0) {
        uuid = UUID.randomUUID().toString();
      } else {
        result = resultMap.get(uuid);
      }

      String op = in.readUTF();
      if (op.equals("quit")) {
        return;
      }

      int value = in.readInt();

      switch (op) {
        case "+":
          result += value;
          break;
        case "-":
          result -= value;
          break;
        case "*":
          result *= value;
          try {
            FileInputStream temp = new FileInputStream("temp/jls17.pdf");
            int b;
            while ((b = temp.read()) != -1) {
              Math.random();
              Math.random();
              Math.random();
              Math.random();
              Math.random();
            }
            temp.close();
          } catch (Exception e) {
            e.printStackTrace();
          }
          break;
        case "/":
          result /= value;
          break;
        case "%":
          result %= value;
          break;
        default:
          out.writeUTF("지원하지 않는 연산자입니다!");
      }

      resultMap.put(uuid, result);

      out.writeUTF(uuid);
      out.writeUTF(String.format("%d", result));
    } catch (Exception e) {
      System.out.printf("%s(%d) 클라이언트 통신 오류!\n", sockAddr.getHostName(), sockAddr.getPort());
    }
  }
}
