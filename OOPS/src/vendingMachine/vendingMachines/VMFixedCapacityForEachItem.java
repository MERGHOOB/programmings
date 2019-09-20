package vendingMachine.vendingMachines;

import vendingMachine.enums.ItemType;

public class VMFixedCapacityForEachItem extends VendingMachine {



    private final int capacity;

    public VMFixedCapacityForEachItem(int capacity) {
        this.capacity = capacity;

    }

    @Override
    int getCapacityForItem(ItemType a) {
        return capacity;
    }
}
