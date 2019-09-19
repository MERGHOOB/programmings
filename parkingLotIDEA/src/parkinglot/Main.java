package parkinglot;

import parkinglot.iclasses.ParkingType;
import parkinglot.ienums.RESERVATION_STATUS;
import parkinglot.ienums.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String PVR_KORAMANGALA = "PVR Koramangala";
    public static void main(String[] args) {

        ParkingManagementSystem parkingManagementSystem = new ParkingManagementSystem();

        Map<ParkingType, Integer> parkingLotMap = new HashMap<>();
        parkingLotMap.put(new ParkingType(VehicleType.CAR), 1);
        parkingLotMap.put(new ParkingType(VehicleType.BIKE), 1);
        parkingLotMap.put(new ParkingType(VehicleType.BICYCLE), 1);
        parkingLotMap.put(new ParkingType(VehicleType.CAR, RESERVATION_STATUS.DISABLED), 1);
        parkingLotMap.put(new ParkingType(VehicleType.CAR, RESERVATION_STATUS.PREGNANT), 1);


        parkingManagementSystem.add_parking_lot(PVR_KORAMANGALA, parkingLotMap, 2, 2);


        assertTrue(parkingManagementSystem.getParkingLotHashMap().get(PVR_KORAMANGALA).getEntryGate(1).getParkingLot().isAvailable(VehicleType.BIKE));

        assertTrue(parkingManagementSystem.isAvailable(PVR_KORAMANGALA, VehicleType.CAR));
        assertTrue(parkingManagementSystem.getParkingLotHashMap().get(PVR_KORAMANGALA).getEntryGate(2).getParkingLot().isAvailable(VehicleType.BIKE));



    }

    private static void assertTrue(boolean available) {
        if(!available) {
            throw  new RuntimeException("Failure");
        }
    }

}
