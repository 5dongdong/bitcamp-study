package App.handle;

import App.print.Title;

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
            System.out.println(where[i]);
            System.out.println(a[i]);
            System.out.println("남은 용돈: " + (remainingMoney - a[i]));
            remainingMoney -= a[i]; // 지출액을 차감합니다.
        }
        Title.menu();
    }

}
