package parkinglot.iclasses;

public class ExitGate {
    private final int gateNumber;

    private int out = 0;

    public ExitGate(int gateNumber) {

        this.gateNumber = gateNumber;
    }

    public boolean exit() {
        out++;
        return true;
    }


    public int getOUT() {

        return out;
    }
}
