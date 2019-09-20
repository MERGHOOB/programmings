package parkinglot.iclasses;

import parkinglot.iclasses.parkings.ParkingLot;

public class EntryGate {
    private final int gateNumber;
    private final ParkingLot parkingLot;
    private int in;
    public EntryGate(int gateNumber, ParkingLot parkingLot) {
        this.gateNumber = gateNumber;
        this.parkingLot = parkingLot;
    }

    public boolean park() {
        in++;
        return true;
    }

    public int getIN() {
        return in;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
