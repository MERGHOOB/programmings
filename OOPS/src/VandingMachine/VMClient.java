package VandingMachine;

import vendingMachine.constants.Item;
import vendingMachine.enums.ItemType;
import vendingMachine.enums.PaymentMode;
import vendingMachine.vendingMachines.VMFixedCapacityForEachItem;

public class VMClient {


    public static void main(String[] args) {


        VMFixedCapacityForEachItem vendingMachine = new VMFixedCapacityForEachItem(10);

        // adding items until capacity
     vendingMachine.refill();

        ItemType itemType = ItemType.A;
        PaymentMode paymentMode = PaymentMode.CASH;


        boolean isSelected = vendingMachine.selectItem(itemType);
        if(isSelected) {
            boolean isPaid = vendingMachine.pay(itemType.getPrice(), paymentMode);
            if(isPaid)
            {
                Item item = vendingMachine.dispense(itemType);
                System.out.println(item.getItemType().name());
            }
        }

    }

}
