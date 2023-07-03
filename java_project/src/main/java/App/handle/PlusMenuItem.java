package App.handle;


import App.handle.Money.PocketMoney2;
import App.handle.Usage.UsageHistory;
import util.Menu.MenuItem;

public class PlusMenuItem implements MenuItem {
    private PocketMoney2 pocketMoney;
    private UsageHistory usageHistory;

    public PlusMenuItem(PocketMoney2 pocketMoney) {
        this.pocketMoney = pocketMoney;
    }

    public PlusMenuItem(UsageHistory usageHistory) {
        this.usageHistory = usageHistory;
    }

@Override
    public void execute(){
        pocketMoney.plusMoney();
    }
}

