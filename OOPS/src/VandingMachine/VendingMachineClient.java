package VandingMachine;

import vendingMachine.VandingMachine.VendingMachine;
import vendingMachine.VandingMachine.constants.Item;
import vendingMachine.VandingMachine.constants.ItemType;
import vendingMachine.VandingMachine.payment.PaymentMode;

public class VendingMachineClient {


    public static void main(String[] args) {


        VendingMachine vendingMachine = new VendingMachine();

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
