package vendingMachine.classez;

import vendingMachine.constants.Item;
import vendingMachine.enums.ItemType;
import vendingMachine.ifaces.ISlot;

public class Slot implements ISlot {

    Item item = null;
    boolean isSelected = false;

    @Override
    public boolean isEmpty() {
        return item != null;
    }

    @Override
    public void setSelected(boolean b) {
        isSelected = true;
    }

    @Override
    public Item getItem() {
        return item;
    }
}
