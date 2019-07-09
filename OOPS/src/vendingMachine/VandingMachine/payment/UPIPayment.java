package vendingMachine.VandingMachine.payment;

import vendingMachine.VandingMachine.ifaces.IPaymentService;

public class UPIPayment implements IPaymentService {
    @Override
    public boolean pay(int money) {
        return false;
    }
}
