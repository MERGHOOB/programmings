package vendingMachine.VandingMachine.payment;

import vendingMachine.VandingMachine.ifaces.IPaymentService;

public class CASHPayment implements IPaymentService {
    @Override
    public boolean pay(int money) {
        return false;
    }
}
