package vendingMachine.constants;


import vendingMachine.enums.ItemType;

public class Item {


    private int id = 0;
    ItemType itemType;

    public Item(int price, ItemType itemType) {
        this.itemType = itemType;
    }


    public ItemType getItemType() {
        return itemType;
    }
}
