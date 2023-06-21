package App.vo;


import java.time.LocalDateTime;

public class Use {

    public static int cnt = 0;


    public static java.util.ArrayList<Integer> expenseList  = new java.util.ArrayList<>();
    public static java.util.ArrayList<String> whereList = new java.util.ArrayList<>();



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




}