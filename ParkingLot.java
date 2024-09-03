import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;

public class ParkingLot {
    private int free_motor_spots;
    private int free_compact_spots;
    private int free_large_spots;
    private int motor_rate;
    private int compact_rate;
    private int large_rate;
    private int seed;
    HashMap<Integer, Ticket> map;

    public ParkingLot(int capacity){
        this.free_compact_spots=(int)Math.ceil(capacity * ParkingInfo.MAX_COMPACT_RATIO);
        this.free_large_spots=(int)Math.ceil(capacity * ParkingInfo.MAX_LARGE_RATIO);
        free_motor_spots = capacity - free_compact_spots - free_large_spots;
        this.motor_rate = ParkingInfo.MOTORCYCLE_RATE;
        this.compact_rate = ParkingInfo.COMPACT_RATE;
        this.large_rate = ParkingInfo.LARGE_RATE;
        this.seed=10000;
        this.map=new HashMap<>();
    }

    public int getFreeMotorSpot(){
        return this.free_motor_spots;
    }

    public int getFreeCompactSpot(){
        return this.free_compact_spots;
    }

    public int getFreeLargeSpot(){
        return this.free_large_spots;
    }

    public void disPlayFreeSpots(){
        int free_motor = getFreeMotorSpot();
        int free_compact = getFreeCompactSpot();
        int free_large = getFreeLargeSpot();
        System.out.println(free_motor + " free motor spots " + free_compact + " free compact spots " + free_large + " free large spots ");
    }

    public Ticket getTicket(int id){
        return map.get(id);
    }

    private boolean canPark(ParkingInfo.VehicleType type){
        if(type==ParkingInfo.VehicleType.MOTORCYCLE){
            return free_motor_spots>0;
        }
        else if(type==ParkingInfo.VehicleType.CAR){
            return free_compact_spots>0;
        }
        else{
            return free_large_spots>0;
        }
    }

    public Ticket park(ParkingInfo.VehicleType type, LocalTime time){
        if(!canPark(type)){
            System.out.println("Sorry, there is no more spots");
            return null;
        }
        seed++;

        System.out.println("Your parking id is " + seed);

        if(type==ParkingInfo.VehicleType.MOTORCYCLE && free_motor_spots>0){
            free_motor_spots--;
            Ticket ticket = new Ticket(time, this.motor_rate, type);
            map.put(seed, ticket);
            return ticket;
        }
        if(type==ParkingInfo.VehicleType.CAR && free_compact_spots>0){
            free_compact_spots--;
            Ticket ticket = new Ticket(time, this.compact_rate, type);
            map.put(seed, ticket);
            return ticket;
        }
        else{
            free_large_spots--;
            Ticket ticket = new Ticket(time, this.large_rate, type);
            map.put(seed, ticket);
            return ticket;
        }
    }

    private int calculateFee(Ticket ticket){
        LocalTime start = ticket.getStart();
        LocalTime end = ticket.getEnd();
        int rate = ticket.getRate();
        long durations = Duration.between(start, end).getSeconds();
        int toHours = (int)((durations + 3599)/3600);
        return toHours*rate;
    }

    public int unPark(int ticketID, LocalTime time){
        Ticket ticket = getTicket(ticketID);
        ticket.addExitTime(time);
        ParkingInfo.VehicleType type = ticket.getType();
        if(type==ParkingInfo.VehicleType.MOTORCYCLE){
            free_motor_spots++;
        }
        else if(type==ParkingInfo.VehicleType.CAR){
            free_compact_spots++;
        }
        else if(type==ParkingInfo.VehicleType.TRUCK){
            free_large_spots++;
        }
        int fee = calculateFee(ticket);
        System.out.println("You need to pay " + fee + " dollars");
        return fee;
    }
}
