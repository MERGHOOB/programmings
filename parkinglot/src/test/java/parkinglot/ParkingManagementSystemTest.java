//package parkinglot;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import parkinglot.iclasses.ParkingType;
//import parkinglot.ienums.RESERVATION_STATUS;
//import parkinglot.ienums.VehicleType;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ParkingManagementSystemTest {
//
//    private static final String PVR_KORAMANGALA = "PVR Koramangala";
//    private ParkingManagementSystem parkingManagementSystem = new ParkingManagementSystem();
//
//    @Before
//    public void setUP() {
//
//        Map<ParkingType, Integer> parkingLotMap = new HashMap<>();
//        parkingLotMap.put(new ParkingType(VehicleType.CAR), 1);
//        parkingLotMap.put(new ParkingType(VehicleType.BIKE), 1);
//        parkingLotMap.put(new ParkingType(VehicleType.BICYCLE), 1);
//        parkingLotMap.put(new ParkingType(VehicleType.CAR, RESERVATION_STATUS.DISABLED), 1);
//        parkingLotMap.put(new ParkingType(VehicleType.CAR, RESERVATION_STATUS.PREGNANT), 1);
//        parkingManagementSystem.add_parking_lot(PVR_KORAMANGALA, parkingLotMap, 2, 2);
//    }
//
//    @Test
//    public void testIsAvailable() {
//
//        Assert.assertTrue(parkingManagementSystem.getParkingLotHashMap().get(PVR_KORAMANGALA).getEntryGate(1).getParkingLot().isAvailable(VehicleType.BIKE));
//
//        Assert.assertTrue(parkingManagementSystem.isAvailable(PVR_KORAMANGALA, VehicleType.CAR));
//        Assert.assertTrue(parkingManagementSystem.getParkingLotHashMap().get(PVR_KORAMANGALA).getEntryGate(2).getParkingLot().isAvailable(VehicleType.BIKE));
//
//    }
//}
//
////
////5.	park_vehicle(“PVR Koramangala”, “Car”, “Entry Gate 1”) -> True
////6.	park_vehicle(“PVR Koramangala”, “Bike”, “Entry Gate 2”) -> True
////7.	park_vehicle(“PVR Koramangala”, “Bike”, “Entry Gate 1”) -> False (This will fail because the spot was taken in the previous step)
////8.	is_available(“PVR Koramangala”, “Car”) -> False
////9.	is_available(“PVR Koramangala”, “Car”, “Disabled”) -> True (queried from Entry Gate 2)
////10.	park_vehicle(“PVR Koramangala”, “Car”, “Disabled”) -> True
////11.	print_all_available_slots(“PVR Koramangala”)
////
////    Total Available:	2
////    Car	1
////    Bike	0
////    Bicycle	1
////
////            12.	print_total_in(“PVR Koramangala”, “Entry Gate 1”)
////
////    Car	1
////    Bike	0
////    Bicycle	0
////
////            13. print_total_out(“PVR Koramangala”, “Exit Gate 1”)
////
////    Car	0
////    Bike	0
////    Bicycle	0
////
////            14.	unpark_vehicle(“PVR Koramangala”, “Bike”, “Exit Gate 1”)
////15.	print_total_out(“PVR Koramangala”, “Exit Gate 1”)
////
////    Car	0
////    Bike	1
////
////
////}
