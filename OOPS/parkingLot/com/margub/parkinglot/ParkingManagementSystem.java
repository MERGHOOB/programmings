package com.margub.parkinglot;

import com.margub.parkinglot.iclasses.EntryGate;
import com.margub.parkinglot.iclasses.ExitGate;
import com.margub.parkinglot.iclasses.parkings.ParkingLot;
import com.margub.parkinglot.ienums.ParkingType;
import com.margub.parkinglot.ifaces.IParkingManagementSystem;
import com.margub.parkinglot.ifaces.VehicleType;
import jdk.jfr.FlightRecorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManagementSystem implements IParkingManagementSystem {

    private List<ParkingLot> parkingLots = new ArrayList<>();
    private Map<String, ParkingLot> NameToParkingLotMap = new HashMap<>();

    @Override
    public int getAvailableSlot(ParkingType parkingType) {
        return 1; //TODO
    }

    @Override
    public void add_parking_lot(String parkingLotName, Map<ParkingType, Integer> parkingLotMap, int entryGates, int exitGates) {
        parkingLots.add(new ParkingLot(parkingLotName, parkingLotMap, entryGates, exitGates));

    }

    @Override
    public boolean isAvaliable(String parkingLotName, VehicleType vehicleType) {

        return getParkingLotByName(parkingLotName).isAvailable(vehicleType);
    }

    private ParkingLot getParkingLotByName(String parkingLotName) {
        return NameToParkingLotMap.get(parkingLotName); //considering no failure
    }

    @Override
    public boolean park_Vehicle(String parkingLotName, VehicleType vehicleType, EntryGate entryGate) {
        return false;
    }

    @Override
    public void print_all_available_slots(String parkingLotName) {

    }

    @Override
    public void print_total_in(String parkingLotName, EntryGate entryGate) {

    }

    @Override
    public void print_total_out(String parkingLotName, ExitGate exitGate) {

    }

    @Override
    public boolean unpark_vehicle(String parkingLotName, VehicleType vehicleType, ExitGate exitGate) {
        return false;
    }
}
