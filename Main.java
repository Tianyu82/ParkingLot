import java.time.LocalTime;

public class Main {
    public static void main(String[] args){
        ParkingLot lot = new ParkingLot(10);
        lot.disPlayFreeSpots();

        lot.park(ParkingInfo.VehicleType.TRUCK, LocalTime.of(9, 30));
        lot.disPlayFreeSpots();

        lot.park(ParkingInfo.VehicleType.TRUCK, LocalTime.of(9, 40));
        lot.disPlayFreeSpots();

        lot.park(ParkingInfo.VehicleType.CAR, LocalTime.of(9, 50));
        lot.disPlayFreeSpots();

        lot.park(ParkingInfo.VehicleType.MOTORCYCLE, LocalTime.of(10, 00));
        lot.disPlayFreeSpots();

        lot.unPark(10004, LocalTime.of(10, 40));
        lot.disPlayFreeSpots();
    }
}
