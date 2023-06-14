package App.vo;


import java.time.LocalDateTime;

public class Use {

    private static int menu = 0;
    public static int cnt = 0;

    public static String[] where = new String[10000];
    public static LocalDateTime[] localDateTime = new LocalDateTime[10000];
    public static String[] comments = new String[100000];
    public static int[] a = new int[10000];
    public static int money = 0; //처음 용돈

    private long createDate;

    public Use() {
        this.createDate = System.currentTimeMillis();
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    private int moneyToAdd;

    public int getMoneyToAdd() {
        return moneyToAdd;
    }

    public void setMoneyToAdd(int moneyToAdd) {
        this.moneyToAdd = moneyToAdd;
    }

    public static int getMenu() {
        return menu;
    }

    public static void setMenu(int menu) {
        Use.menu = menu;
    }


}