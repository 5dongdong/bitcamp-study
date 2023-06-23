package App.handle.Money;

import App.handle.PocketMoney;
import App.handle.PocketMoney2;
import util.MoneyMenuItem;

public class PlusMoneyMenuItemItem implements MoneyMenuItem {
    private PocketMoney pocketMoney;

    public PlusMoneyMenuItemItem(PocketMoney2 pocketMoney) {
        this.pocketMoney = pocketMoney;
    }

@Override
    public void execute(){
        pocketMoney.plusMoney();
    }
}

public class ShowMoneyMenuItemItem implements MoneyMenuItem {
    private PocketMoney pocketMoney;

    public ShowMoneyMenuItemItem(PocketMoney2 pocketMoney) {
        this.pocketMoney = pocketMoney;
    }


    @Override
    public void execute(){
        pocketMoney.ShowMoney();
    }
}
