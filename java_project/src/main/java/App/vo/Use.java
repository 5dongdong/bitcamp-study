package App.vo;


public class Use {

    private static int menu = 0;
    public static int cnt = 0;

    public static String[] where = new String[10000];
    public static int[] a = new int[10000];
    public static int money = 0; //처음 용돈

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