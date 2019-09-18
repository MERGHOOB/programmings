package parkinglot.iclasses.parkings;

import parkinglot.iclasses.EntryGate;
import parkinglot.iclasses.ExitGate;
import parkinglot.iclasses.ParkingType;
import parkinglot.ienums.RESERVATION_STATUS;
import parkinglot.ienums.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {


    private String parkingLotName;
    private Map<ParkingType, Integer> parkingLotMap; // parking type with number of seats  present
    private Map<Integer, EntryGate> entryGates = new HashMap<>();
    private Map<Integer, ExitGate> exitGates = new HashMap<>();


    int carDefaultCount = 0;
    int carPregnantCount = 0;
    int carDisabledCount = 0;
    int bikeCount = 0;
    int bicycleCount = 0;


    public ParkingLot(String parkingLotName, Map<ParkingType, Integer> parkingLotMap, int numOfEntryGates, int exitGates) {
        this.parkingLotName = parkingLotName;

        this.parkingLotMap = parkingLotMap;
        fillCounters(parkingLotMap);
//        this.entryGates = entryGates;
        fillEntryGates(numOfEntryGates);
        fillExitGates(exitGates);
    }

    private void fillEntryGates(int numOfEntryGates) {
        for (int i = 1; i <= numOfEntryGates; i++) {

            entryGates.put(i, new EntryGate(i));
        }
    }

    private void fillExitGates(int numOfExitGates) {
        for (int i = 1; i <= numOfExitGates; i++) {

            exitGates.put(i, new ExitGate(i));
        }
    }

    private void fillCounters(Map<ParkingType, Integer> parkingLotMap) {
        for (ParkingType parkingType : parkingLotMap.keySet()) {
            if (parkingType.getVehicleType() == VehicleType.CAR) {
                if (parkingType.getReservation_status() == RESERVATION_STATUS.DISABLED) {
                    carDisabledCount += parkingLotMap.get(parkingType);
                } else if (parkingType.getReservation_status() == RESERVATION_STATUS.PREGNANT) {
                    carPregnantCount += parkingLotMap.get(parkingType);
                } else {
                    carDefaultCount += parkingLotMap.get(parkingType);
                }
            } else if (parkingType.getVehicleType() == VehicleType.BIKE) {
                bikeCount += parkingLotMap.get(parkingType);
            } else {
                bicycleCount += parkingLotMap.get(parkingType);
            }
        }
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


    public EntryGate getEntryGate(int entryGate) {
        return entryGates.get(entryGate);
    }

    public void getAvailableSlots() {


    }

    public ExitGate getExitGate(int exitGate) {
        return exitGates.get(exitGate);
    }
}
