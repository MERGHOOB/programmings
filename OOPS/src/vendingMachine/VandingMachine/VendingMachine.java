package vendingMachine.VandingMachine;

import vendingMachine.VandingMachine.constants.Item;
import vendingMachine.VandingMachine.enums.ItemType;
import vendingMachine.VandingMachine.ifaces.IVendingMachine;
import vendingMachine.VandingMachine.enums.PaymentMode;
import vendingMachine.VandingMachine.payment.PaymentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine implements IVendingMachine {


    /*
        capacity for vendingMachine to hold each item.
        Considering that capacity is same for each item
     */


    private final int capacity;

    public VendingMachine(int capacity) {
        this.capacity = capacity;

    }



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

    private int getCapacityForItem(ItemType a) {
        return capacity;
    }
}
