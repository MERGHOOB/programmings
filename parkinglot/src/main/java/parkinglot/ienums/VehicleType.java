package parkinglot.ienums;

public enum VehicleType {

    CAR(ParkingType.DEFAULT),
    BIKE(ParkingType.DEFAULT),
    BICYCLE(ParkingType.DEFAULT);

    ParkingType parkingType;

    VehicleType(ParkingType type) {
        this.parkingType = type;

    }

}
