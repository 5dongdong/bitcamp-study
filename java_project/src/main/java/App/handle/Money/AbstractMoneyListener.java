package App.handle.Money;

import util.ActionListener;
import util.List;

public abstract class AbstractMoneyListener implements ActionListener {

    protected List list;

    public AbstractMoneyListener(List list) {
        this.list = list;
    }

}
