package parkinglot;

import parkinglot.iclasses.ExitGate;
import parkinglot.iclasses.ParkingType;
import parkinglot.iclasses.parkings.ParkingLot;
import parkinglot.ienums.VehicleType;
import parkinglot.ifaces.IParkingManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManagementSystem implements IParkingManagementSystem {

    private List<ParkingLot> parkingLots = new ArrayList<>();
    private Map<String, ParkingLot> parkingLotHashMap = new HashMap<>();

    @Override
    public int getAvailableSlot() {

        for(String parkingLot: parkingLotHashMap.keySet()) {

            parkingLotHashMap.get(parkingLot).getAvailableSlots();
        }


        return 1; //TODO
    }

    private void print(Map<VehicleType, Integer> parkingLotMap) {
        System.out.println(parkingLotMap);
    }

    @Override
    public void add_parking_lot(String parkingLotName, Map<ParkingType, Integer> parkingLotMap, int entryGates, int exitGates) {
        parkingLots.add(new ParkingLot(parkingLotName, parkingLotMap, entryGates, exitGates));

    }

    @Override
    public boolean isAvailable(String parkingLotName, VehicleType vehicleType) {

        return getParkingLotByName(parkingLotName).isAvailable(vehicleType);
    }

    private ParkingLot getParkingLotByName(String parkingLotName) {
        return parkingLotHashMap.get(parkingLotName); //considering no failure
    }

    @Override
    public boolean park_Vehicle(String parkingLotName, VehicleType vehicleType, int entryGate) {

        return parkingLotHashMap.get(parkingLotName).getEntryGate(entryGate).park();
    }

    @Override
    public void print_all_available_slots(String parkingLotName) {

        parkingLotHashMap.get(parkingLotName).getAvailableSlots();


    }

    @Override
    public void print_total_in(String parkingLotName, int entryGate) {

        parkingLotHashMap.get(parkingLotName).getEntryGate(entryGate).getIN();
    }

    @Override
    public void print_total_out(String parkingLotName, int exitGate) {
        parkingLotHashMap.get(parkingLotName).getExitGate(exitGate).getOUT();
    }

    @Override
    public boolean unpark_vehicle(String parkingLotName, VehicleType vehicleType, int exitGate) {
        ParkingLot parkingLot = parkingLotHashMap.get(parkingLotName);
        return parkingLot.unpark(vehicleType, exitGate);
    }
}
