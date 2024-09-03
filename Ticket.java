import java.time.LocalTime;

public class Ticket {
    private LocalTime start;
    private LocalTime end;
    private int rateApplied;
    private ParkingInfo.VehicleType type;

    public Ticket(LocalTime start, int rate, ParkingInfo.VehicleType type){
        this.start=start;
        this.rateApplied=rate;
        this.end=null;
        this.type=type;
    }

    public LocalTime getStart(){
        return this.start;
    }

    public LocalTime getEnd(){
        return this.end;
    }

    public int getRate(){
        return this.rateApplied;
    }

    public void addExitTime(LocalTime time){
        this.end=time;
    }

    public ParkingInfo.VehicleType getType(){
        return this.type;
    }
}
