package App.handle;

import java.util.Scanner;

import static App.vo.Use.*;



public class Where {

    static Scanner sc = new Scanner(System.in);
        public static void choice2() {
            String response = "y";
            while (response.equalsIgnoreCase("y")) {
                System.out.println("사용한 곳을 입력하세요");
                String x = sc.next();
                System.out.println(x + "에 얼마를 사용했는지 입력하세요");
                int expense = sc.nextInt();
                a[cnt] = expense;
                where[cnt] = x;
                cnt++;
                System.out.print("더 쓸 내용이 있습니까? (Y/N): ");
                response = sc.next();
                System.out.println();
            }
            System.out.println("----------");
            Choice.Choice();
        }
    }

