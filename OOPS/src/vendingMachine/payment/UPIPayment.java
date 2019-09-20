package vendingMachine.payment;

import vendingMachine.ifaces.IPaymentService;

public class UPIPayment implements IPaymentService {
    @Override
    public boolean pay(int money) {
        return false;
    }
}
