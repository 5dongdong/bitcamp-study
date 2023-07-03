package App.handle;

import App.handle.Money.PocketMoney2;
import util.Menu.MenuItem;

public class ShowMenuItemItem implements MenuItem {
    private PocketMoney2 pocketMoney;

    public ShowMenuItemItem(PocketMoney2 pocketMoney) {
        this.pocketMoney = pocketMoney;
    }


    @Override
    public void execute() {
        pocketMoney.showMoney();
    }
}
