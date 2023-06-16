package App.handle;



import static App.handle.UsageHistory.sc;
import static App.print.Title.menu;
import static App.vo.Use.*;

public class Total {

    public static void total2() {
        int sum = 0;
        for (int i = 0; i < cnt; i++) {
            sum += a[i];
            
        }

        System.out.println("----------");
        System.out.println("사용한 용돈: " + sum);
        System.out.println("남은 용돈: " + (money - sum));

        System.out.println("종료 하시겠습니까?");
        System.out.println("1. 네");
        System.out.println("2. 아니요");
        int choice3 = sc.nextInt();
        if (choice3 == 1) {
            return;
        } else {
            menu();
        }
    }
}
