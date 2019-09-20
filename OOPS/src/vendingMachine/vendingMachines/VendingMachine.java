package vendingMachine.vendingMachines;

import vendingMachine.constants.Item;
import vendingMachine.enums.ItemType;
import vendingMachine.exceptions.InvalidSlotSelectionException;
import vendingMachine.ifaces.ISlot;
import vendingMachine.ifaces.IVendingMachine;
import vendingMachine.enums.PaymentMode;
import vendingMachine.payment.PaymentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class VendingMachine implements IVendingMachine {


    private Map<ItemType, List<Item>> items = new HashMap<>();

    public boolean selectItem(ItemType itemType) {
        return items.get(itemType).size() > 0;
    }

    public boolean pay(int price, PaymentMode paymentMode) {
        return new PaymentService(paymentMode).pay(price);
    }


    public Item dispense(ItemType itemType) {
        return items.get(itemType).remove(items.get(itemType).size()-1);
    }


    public boolean addItem(ItemType itemType) {
        items.computeIfAbsent(itemType, k -> new ArrayList<>());

        if(items.get(itemType).size() < getCapacityForItem(itemType)) {
            items.get(itemType).add(new Item(itemType.getPrice(), itemType));
            return true;
        }

        return false;
    }

    @Override
    public void refill() {

        ItemType[] values = ItemType.values();

        for(ItemType itemType : values) {
            while( addItem(itemType));
        }
    }

    public int selectSlot(ISlot slot) throws InvalidSlotSelectionException {
        if(slot.isEmpty()) {
            throw new InvalidSlotSelectionException("InvalidSlotSelectionException");
        }

        slot.setSelected(true);

        return slot.getItem().getItemType().getPrice();
    }

    abstract int getCapacityForItem(ItemType a);
}
