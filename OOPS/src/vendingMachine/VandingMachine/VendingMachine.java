package vendingMachine.VandingMachine;

import vendingMachine.VandingMachine.constants.Item;
import vendingMachine.VandingMachine.constants.ItemType;
import vendingMachine.VandingMachine.ifaces.IVendingMachine;
import vendingMachine.VandingMachine.payment.PaymentMode;
import vendingMachine.VandingMachine.payment.PaymentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine implements IVendingMachine {


    /*
    consider vending machine supports 5 item of type: a, b, c, d, e
    capacity for each; 10,10,10,10,10



     */

    private Map<ItemType, List<Item>> items = new HashMap<>();

    public boolean selectItem(ItemType itemType) {
        return items.get(itemType).size() > 0;
    }

    public boolean pay(int price, PaymentMode paymentMode) {
        return new PaymentService(paymentMode).pay(price);
    }


    public Item dispense(ItemType itemType) {
        return items.get(itemType).remove(0);
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
        return 10;
    }
}
