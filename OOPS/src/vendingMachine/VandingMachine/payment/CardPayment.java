package vendingMachine.VandingMachine.payment;

import vendingMachine.VandingMachine.ifaces.IPaymentService;

public class CardPayment implements IPaymentService {
    @Override
    public boolean pay(int money) {
        return true;
    }
}
