package parkinglot.ifaces;

import parkinglot.iclasses.ExitGate;
import parkinglot.iclasses.ParkingType;
import parkinglot.ienums.VehicleType;

import java.util.Map;

public interface IParkingManagementSystem {

    int getAvailableSlot();

    void add_parking_lot(String parkingLotName, Map<ParkingType, Integer> parkingLotMap, int entryGates, int exitGates);

    boolean isAvailable(String parkingLotName, VehicleType vehicleType);

    boolean park_Vehicle(String parkingLotName, VehicleType vehicleType, int entryGate);

    void print_all_available_slots(String parkingLotName);

    void print_total_in(String parkingLotName, int entryGate);

    void print_total_out(String parkingLotName, int exitGate);

    boolean unpark_vehicle(String parkingLotName, VehicleType vehicleType, int exitGate);

}
