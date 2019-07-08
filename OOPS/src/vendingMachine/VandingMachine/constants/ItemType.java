package vendingMachine.VandingMachine.constants;

public enum ItemType {
    A(1),
    B(2),
    C(3),
    ;

    private final int price;

    private ItemType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


}
