package com.margub.parkinglot.iclasses.parkings;

import com.margub.parkinglot.ienums.ParkingType;
import com.margub.parkinglot.ifaces.VehicleType;

import java.util.Map;

public class ParkingLot {


    private String parkingLotName;
    private Map<ParkingType, Integer> parkingLotMap;
    private int entryGates;
    private int exitGates;


    public ParkingLot(String parkingLotName, Map<ParkingType, Integer> parkingLotMap, int entryGates, int exitGates) {
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

    public String getParkingLotName() {
        return parkingLotName;
    }


    public Map<ParkingType, Integer> getParkingLotMap() {
        return parkingLotMap;
    }

    public int getEntryGates() {
        return entryGates;
    }

    public int getExitGates() {
        return exitGates;
    }

}
