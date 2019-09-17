package parkinglot.iclasses.parkings;

import parkinglot.iclasses.EntryGate;
import parkinglot.iclasses.ParkingType;
import parkinglot.ienums.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {


    private String parkingLotName;
    private Map<ParkingType, Integer> parkingLotMap;
    private Map<Integer, EntryGate> entryGates = new HashMap<>();
    private int exitGates;


    private int carSlot = 0;
    private int bikeSlot = 0;
    private int bicycleSlot = 0;
    private int disabledPeopleCarSlot = 0;
    private int pregnantSlot = 0;

    public ParkingLot(String parkingLotName, Map<ParkingType, Integer> parkingLotMap, int numOfEntryGates, int exitGates) {
        this.parkingLotName = parkingLotName;

        this.parkingLotMap = parkingLotMap;
//        this.entryGates = entryGates;
        for (int i = 1; i <= numOfEntryGates; i++) {

            entryGates.put(i, new EntryGate(i));
        }
        this.exitGates = exitGates;
    }


    /*
    To check whether given vehicle is present or not
     */
    public boolean isAvailable(VehicleType vehicleType) {

        return false;
    }

    public boolean isAvailable(VehicleType vehicleType, ParkingType parkingType) {

        return parkingLotMap.get(vehicleType) != 0;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }


    public Map<ParkingType, Integer> getParkingLotMap() {
        return parkingLotMap;
    }


    public int getExitGates() {
        return exitGates;
    }

    public EntryGate getEntryGate(int entryGate) {
        return entryGates.get(entryGate);
    }

    public void getAvailableSlots() {

    }
}
