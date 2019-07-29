package vendingMachine.exceptions;

public class InvalidSlotSelectionException extends Throwable {
    public InvalidSlotSelectionException(String message) {
        System.out.println(message);
    }
}
