package util;

import java.util.ArrayList;
import java.util.List;

public class MoneyMenuItemGroup implements MoneyMenuItem {
    private  String name;
    private List<MoneyMenuItem> moneyMenuItems;

    public MoneyMenuItemGroup(String name) {
        this.name = name;
        this.moneyMenuItems = new ArrayList<>();
    }

    public void addMenuItem(MoneyMenuItem moneyMenuItem){
        moneyMenuItems.add(moneyMenuItem);
    }

    public void removeItem(MoneyMenuItem moneyMenuItem){
        moneyMenuItems.remove(moneyMenuItem);
    }

    public List<MoneyMenuItem> getMoneyMenuItems() {
        return moneyMenuItems;
    }

    @Override
    public void execute() {
        System.out.println("===" +name+ "===");
        for(MoneyMenuItem moneyMenuItem : moneyMenuItems) {
            moneyMenuItem.execute();
        }
        System.out.println();
    }
}
