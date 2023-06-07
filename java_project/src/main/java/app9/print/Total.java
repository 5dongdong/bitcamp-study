package app9.print;


import static app9.handle.Use.*;

public class Total {

    public static void total() {
        int foodExpense = 0;
        int clothExpense = 0;
        int etcExpense = 0;


				for (int i = 0; i < cnt; i++) {
					if (where[i].equals("식비")) {
							foodExpense += a[i];
					} else if (where[i].equals("옷")) {
							clothExpense += a[i];
					} else if (where[i].equals("기타")) {
							etcExpense += a[i];
					}
					
					sum += a[i];
			}

        System.out.println("----------");
        System.out.println("식비 비용: " + foodExpense);
        System.out.println("옷 비용: " + clothExpense);
        System.out.println("기타 비용: " + etcExpense);
        System.out.println("----------");
        System.out.println("사용한 용돈: " + sum);
        System.out.println("남은 용돈: " + (money - sum));
    }
}
