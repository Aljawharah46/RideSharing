public class PrivateRide extends Ride implements IPrivateRide {

    private IRider rider;

    //constructor
    public PrivateRide(int rideId, String pickupLocation, IDateTime pickupTime, String dropoffLocation, IDateTime dropoffTime, IDriver driver, IRider rider) {
        super(rideId, pickupLocation, pickupTime, dropoffLocation, dropoffTime, driver);
        this.rider = rider;
    }

    //setter and getter
    @Override
    public IRider getRider() {
        return rider;
    }

    @Override
    public void setRider(IRider rider) {
        this.rider = rider;
    }

    //checks if the rider's id matches
    @Override
    public boolean hasRider(int riderId) {
        return rider != null && rider.getId() == riderId;
    }

    //returns private ride's info
    @Override 
    public String toString() {
        return super.toString() + ", Rider: " + (rider != null ? rider.getName() : "None");
    }
}
