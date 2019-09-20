package vendingMachine.ifaces;

import vendingMachine.constants.Item;

public interface ISlot {


    boolean isEmpty();

    void setSelected(boolean b);

    Item getItem();
}
