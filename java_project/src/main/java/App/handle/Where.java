package App.handle;

import App.vo.Use;


import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import static App.vo.Use.*;



public class Where {

    static Scanner sc = new Scanner(System.in);
        public static void choice2() {
            String response = "y";
            while (response.equalsIgnoreCase("y")) {
                localDateTime[cnt] = LocalDateTime.now();
                System.out.println("사용한 곳을 입력하세요");
                String x = sc.next();
                System.out.println(x + "에 얼마를 사용했는지 입력하세요");
                try {
                    int expense = sc.nextInt();
                    a[cnt] = expense;
                } catch (InputMismatchException e){
                    System.out.println("잘못 입력하셨습니다.");
                    sc.nextLine();
                    choice2();
                }
                Use use = new Use();

                where[cnt] = x;
                cnt++;
                System.out.print("더 쓸 내용이 있습니까? (Y/N): ");
                response = sc.next();
                System.out.println();
                while(!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("n")){
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                    System.out.print("더 쓸 내용이 있습니까? (Y/N): ");
                    response = sc.next();
                    System.out.println();
                }
            }
            System.out.println("----------");
            Choice.Choice();
        }
    }

