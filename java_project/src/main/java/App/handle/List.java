package App.handle;

import App.print.Title;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static App.vo.Use.*;


public class List {

    public static void list() {
        if (cnt == 0) {
            System.out.println();
            System.out.println("사용 내역이 없습니다.");
            System.out.println();
            Title.menu();
            return;
        }

        int remainingMoney = money; // 용돈의 초기값으로 remainingMoney를 초기화합니다.

        for (int i = 0; i < cnt; i++) {
            System.out.println("==========================");
            System.out.printf("등록일: %tY-%tm-%td%n", localDateTime[i], localDateTime[i], localDateTime[i]);
            System.out.println("사용한곳 : " + where[i]);
            System.out.println("사용금액 : " +a[i]);
            System.out.println("남은 용돈: " + (remainingMoney - a[i]));
            System.out.println("==========================");
            remainingMoney -= a[i]; // 지출액을 차감합니다.
        }
        Title.menu();
    }
}
