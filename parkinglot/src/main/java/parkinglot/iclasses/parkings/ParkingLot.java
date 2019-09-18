package parkinglot.iclasses.parkings;

import parkinglot.iclasses.EntryGate;
import parkinglot.iclasses.ExitGate;
import parkinglot.iclasses.ParkingType;
import parkinglot.ienums.RESERVATION_STATUS;
import parkinglot.ienums.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    // Name;
    // number of entry Gates
    // number of exit Gates
    // Parking type:
    //supported vehicle Type:


    private String parkingLotName;
    private Map<ParkingType, Integer> parkingLotMap; // parking type with number of seats  present

    private Map<Integer, EntryGate> entryGates = new HashMap<>();
    private Map<Integer, ExitGate> exitGates = new HashMap<>();
    private Map<String, Integer> counterMap = new HashMap<>();


    private int carDefaultCount = 0;
    private int carPregnantCount = 0;
    private int carDisabledCount = 0;
    private int bikeCount = 0;
    private int bicycleCount = 0;


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
                    counterMap.put(getUIDForSlot(parkingType, RESERVATION_STATUS.DISABLED), carDisabledCount);

                } else if (parkingType.getReservation_status() == RESERVATION_STATUS.PREGNANT) {
                    carPregnantCount += parkingLotMap.get(parkingType);
                    counterMap.put(getUIDForSlot(parkingType, RESERVATION_STATUS.PREGNANT), carPregnantCount);
                } else {
                    carDefaultCount += parkingLotMap.get(parkingType);
                    counterMap.put(getUIDForSlot(parkingType), carDefaultCount);
                }
            } else if (parkingType.getVehicleType() == VehicleType.BIKE) {
                bikeCount += parkingLotMap.get(parkingType);
                counterMap.put(getUIDForSlot(parkingType), bikeCount);
            } else {
                bicycleCount += parkingLotMap.get(parkingType);
                counterMap.put(getUIDForSlot(parkingType), bicycleCount);
            }
        }
    }

    private String getUIDForSlot(ParkingType parkingType) {
        return getUIDForSlot(parkingType.getVehicleType());
    }

    private String getUIDForSlot(ParkingType parkingType, RESERVATION_STATUS reservationStatus) {

        return getUIDForSlot(parkingType.getVehicleType(), reservationStatus);
    }

    private String getUIDForSlot(VehicleType vehicleType) {
        return getUIDForSlot(vehicleType, RESERVATION_STATUS.DEFAULT);
    }

    private String getUIDForSlot(VehicleType vehicleType, RESERVATION_STATUS reservationStatus) {
        return vehicleType.name() + "|" + reservationStatus.name();
    }


    /*
    To check whether given vehicle is present or not
     */
    public boolean isAvailable(VehicleType vehicleType) {

        return counterMap.get(getUIDForSlot(vehicleType)) != 0;
    }

    public boolean isAvailable(VehicleType vehicleType, ParkingType parkingType) {

        return counterMap.get(getUIDForSlot(vehicleType)) != 0;
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
        System.out.println("Car         "
                + counterMap.get(getUIDForSlot(VehicleType.CAR))
                + counterMap.get(getUIDForSlot(VehicleType.CAR, RESERVATION_STATUS.PREGNANT))
                + counterMap.get(getUIDForSlot(VehicleType.CAR, RESERVATION_STATUS.DISABLED)));

        System.out.println("Bike        " + counterMap.get(getUIDForSlot(VehicleType.BIKE)));
        System.out.println("Bicycle     " + counterMap.get(getUIDForSlot(VehicleType.BICYCLE)));

    }

    public ExitGate getExitGate(int exitGate) {
        return exitGates.get(exitGate);
    }

    public boolean unpark(VehicleType vehicleType, int exitGate) {
        counterMap.put(getUIDForSlot(vehicleType), counterMap.get(getUIDForSlot(vehicleType)) - 1);
        return getExitGate(exitGate).exit();
    }
}
