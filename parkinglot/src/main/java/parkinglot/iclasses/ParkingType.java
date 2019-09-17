package parkinglot.iclasses;

import parkinglot.ienums.RESERVATION_STATUS;
import parkinglot.ienums.VehicleType;

public class ParkingType {


    private final VehicleType vehicleType;
    private final RESERVATION_STATUS reservation_status;

    ParkingType(VehicleType vehicleType, RESERVATION_STATUS reservation_status) {
        this.vehicleType = vehicleType;
        this.reservation_status = reservation_status;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public RESERVATION_STATUS getReservation_status() {
        return reservation_status;
    }
}
