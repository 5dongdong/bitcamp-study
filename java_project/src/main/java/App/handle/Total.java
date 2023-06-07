package App.handle;


import static App.handle.Use.*;
import static App.handle.Where.sc;
import static App.print.Title.menu;

public class Total {

    public static void total() {
        int foodExpense = 0;
        int clothExpense = 0;
        int etcExpense = 0;


        for (int i = 0; i < cnt; i++) {
            if (where[i].equals("식비")) {
                updatedFoodExpense += a[i];
            } else if (where[i].equals("옷")) {
                updateClothExpense += a[i];
            } else if (where[i].equals("기타")) {
                updateEtcExpense += a[i];
            }

            sum += a[i];
        }

        System.out.println("----------");
        System.out.println("식비 비용: " + updatedFoodExpense);
        System.out.println("옷 비용: " + updateClothExpense);
        System.out.println("기타 비용: " + updateEtcExpense);
        System.out.println("----------");
        System.out.println("사용한 용돈: " + sum);
        System.out.println("남은 용돈: " + (money - sum));

        System.out.println("종료 하시겠습니까?");
        System.out.println("1. 네");
        System.out.println("2. 아니요");
        int choice3 = sc.nextInt();
        if(choice3 == 1){
            return;
        }else{
            menu();
        }
    }
}
