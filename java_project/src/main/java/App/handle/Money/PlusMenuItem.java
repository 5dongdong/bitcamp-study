package App.handle.Money;


import App.handle.PocketMoney2;
import util.Menu.MenuItem;

public class PlusMenuItem implements MenuItem {
    private PocketMoney2 pocketMoney;

    public PlusMenuItem(PocketMoney2 pocketMoney) {
        this.pocketMoney = pocketMoney;
    }

@Override
    public void execute(){
        pocketMoney.plusMoney();
    }
}

