package App.handle;

import util.Menu.MenuItem;
import util.Prompt;

import static App.handle.UsageHistory.*;

public class UsageHistoryMenu implements MenuItem {
    private Prompt prompt = new Prompt();

    @Override
    public void execute(){
        while(true) {
            System.out.println("1. 사용처 입력");
            System.out.println("2. 내역 확인");
            System.out.println("3. 내역 수정");
            System.out.println("4. 최근 내역");
            System.out.println("5. 이전 메뉴로");
try {
    String menuNo = prompt.inputString("메뉴를 선택하세요: ");
    if (menuNo.equals("1")) {
        choice2();
    } else if (menuNo.equals("2")) {
        list();
    } else if (menuNo.equals("3")) {
        update();
    } else if (menuNo.equals("4")) {
        recent();
    } else if (menuNo.equals("5")) {
        break;
    } else {
        System.out.println("잘못 입력하셨습니다.");
    }
}catch (Exception e) {
    //예외무시
}

        }
    }
}
