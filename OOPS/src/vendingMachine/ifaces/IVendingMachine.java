package vendingMachine.ifaces;

import vendingMachine.constants.Item;
import vendingMachine.enums.ItemType;
import vendingMachine.enums.PaymentMode;

public interface IVendingMachine {



    boolean addItem(ItemType itemType) ;

    /**
     * It will all the items at anytime
     */
    void refill();

    /*
    Selection of item to buy
     */
    boolean selectItem(ItemType itemType);

    /*
        pay for selected item, through selected paymentMode
     */
    boolean pay(int price, PaymentMode paymentMode);

    /*
    Dispense the item
     */
    Item dispense(ItemType itemType);




}
