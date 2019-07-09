package vendingMachine.exceptions;

public class CapacityException extends Exception {
    public CapacityException(String message) {
        System.out.println(message);
    }
}
