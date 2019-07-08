package vendingMachine.VandingMachine.constants;



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
