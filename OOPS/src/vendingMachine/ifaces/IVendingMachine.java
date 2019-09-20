package vendingMachine.ifaces;

import vendingMachine.constants.Item;
import vendingMachine.enums.ItemType;
import vendingMachine.enums.PaymentMode;
import vendingMachine.exceptions.InvalidSlotSelectionException;

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
    consumer select the slot,
     */
    int selectSlot(ISlot slot) throws InvalidSlotSelectionException;

    /*
        pay for selected item, through selected paymentMode
     */
    boolean pay(int price, PaymentMode paymentMode);

    /*
    Dispense the item
     */
    Item dispense(ItemType itemType);




}
