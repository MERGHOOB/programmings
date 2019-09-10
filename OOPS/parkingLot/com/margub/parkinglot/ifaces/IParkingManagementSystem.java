package com.margub.parkinglot.ifaces;

import com.margub.parkinglot.iclasses.EntryGate;
import com.margub.parkinglot.iclasses.ExitGate;
import com.margub.parkinglot.ienums.ParkingType;

import java.util.Map;

public interface IParkingManagementSystem {

    int getAvailableSlot(ParkingType parkingType);

    void add_parking_lot(String parkingLotName, Map<ParkingType, Integer> parkingLotMap, int entryGates, int exitGates);

    boolean isAvaliable(String parkingLotName, VehicleType vehicleType);

    boolean park_Vehicle(String parkingLotName, VehicleType vehicleType, EntryGate entryGate);

    void print_all_available_slots(String parkingLotName);

    void print_total_in(String parkingLotName, EntryGate entryGate);

    void print_total_out(String parkingLotName, ExitGate exitGate);

    boolean unpark_vehicle(String parkingLotName, VehicleType vehicleType, ExitGate exitGate);

}
