package parkinglot.iclasses.parkings;

import parkinglot.ienums.ParkingType;
import parkinglot.ienums.VehicleType;

import java.util.Map;

public class ParkingLot {


    private String parkingLotName;
    private Map<VehicleType, Integer> parkingLotMap;
    private int entryGates;
    private int exitGates;


    private int carSlot = 0;
    private int bikeSlot = 0;
    private int bicycleSlot = 0;
    private int disabledPeopleCarSlot = 0;
    private int pregnantSlot = 0;


    public ParkingLot(String parkingLotName, Map<VehicleType, Integer> parkingLotMap, int entryGates, int exitGates) {
        this.parkingLotName = parkingLotName;

        this.parkingLotMap = parkingLotMap;
        this.entryGates = entryGates;
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


    public Map<VehicleType, Integer> getParkingLotMap() {
        return parkingLotMap;
    }

    public int getEntryGates() {
        return entryGates;
    }

    public int getExitGates() {
        return exitGates;
    }

}
