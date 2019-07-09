package vendingMachine.payment;

import vendingMachine.enums.PaymentMode;
import vendingMachine.ifaces.IPaymentService;

public class PaymentService {

    IPaymentService paymentService;

    public PaymentService(PaymentMode paymentMode) {

        if(PaymentMode.CARD == paymentMode) {
                paymentService = new CardPayment();
        }
        else if(PaymentMode.UPI == paymentMode) {
            paymentService = new UPIPayment();
        }
        else if(PaymentMode.CASH == paymentMode) {
            paymentService = new CASHPayment();
        }
        else {
            throw new RuntimeException("Please select one of the supported payment mode");
        }


    }

    public boolean pay(int money) {
        return paymentService.pay(money);
    }
}
