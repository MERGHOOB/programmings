package parkinglot.iclasses;

public class EntryGate {
    private final int gateNumber;
    private int in;
    public EntryGate(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public boolean park() {
        in++;
        return true;
    }

    public int getIN() {
        return in;
    }
}
