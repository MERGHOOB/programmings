package vendingMachine.payment;

import vendingMachine.ifaces.IPaymentService;

public class CardPayment implements IPaymentService {
    @Override
    public boolean pay(int money) {
        return true;
    }
}
