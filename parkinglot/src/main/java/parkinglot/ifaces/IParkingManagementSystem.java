package parkinglot.ifaces;

import parkinglot.iclasses.EntryGate;
import parkinglot.iclasses.ExitGate;
import parkinglot.ienums.ParkingType;
import parkinglot.ienums.VehicleType;

import java.util.Map;

public interface IParkingManagementSystem {

    int getAvailableSlot();

    void add_parking_lot(String parkingLotName, Map<VehicleType, Integer> parkingLotMap, int entryGates, int exitGates);

    boolean isAvaliable(String parkingLotName, VehicleType vehicleType);

    boolean park_Vehicle(String parkingLotName, VehicleType vehicleType, EntryGate entryGate);

    void print_all_available_slots(String parkingLotName);

    void print_total_in(String parkingLotName, EntryGate entryGate);

    void print_total_out(String parkingLotName, ExitGate exitGate);

    boolean unpark_vehicle(String parkingLotName, VehicleType vehicleType, ExitGate exitGate);

}
