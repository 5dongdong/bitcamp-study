package util.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuGroup implements MenuItem {
    private  String name;
    private List<MenuItem> menuItems;

    public MenuGroup(String name) {
        this.name = name;
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem menuItem){
        menuItems.add(menuItem);
    }


    public List<MenuItem> getMoneyMenuItems() {
        return menuItems;
    }

    public List<MenuItem> getMenuItems(){
        return menuItems;
    }

    @Override
    public void execute() {
        System.out.println("===" +name+ "===");
        for(MenuItem menuItem : menuItems) {
            menuItem.execute();
        }
        System.out.println();
    }
}
