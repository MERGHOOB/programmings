package parkinglot;

import parkinglot.iclasses.EntryGate;
import parkinglot.iclasses.ExitGate;
import parkinglot.iclasses.parkings.ParkingLot;
import parkinglot.ienums.VehicleType;
import parkinglot.ifaces.IParkingManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManagementSystem implements IParkingManagementSystem {

    private List<ParkingLot> parkingLots = new ArrayList<>();
    private Map<String, ParkingLot> NameToParkingLotMap = new HashMap<>();

    @Override
    public int getAvailableSlot() {
        parkingLots.forEach(
                parkingLot -> {
                    print(parkingLot.getParkingLotMap());
                }
        );

        return 1; //TODO
    }

    private void print(Map<VehicleType, Integer> parkingLotMap) {
        System.out.println(parkingLotMap);
    }

    @Override
    public void add_parking_lot(String parkingLotName, Map<VehicleType, Integer> parkingLotMap, int entryGates, int exitGates) {
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