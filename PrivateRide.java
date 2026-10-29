public class PrivateRide extends Ride implements IPrivateRide {

    private IRider rider;

    public PrivateRide(int rideId, String pickupLocation, IDateTime pickupTime, String dropoffLocation, IDateTime dropoffTime, IDriver driver, IRider rider) {
        super(rideId, pickupLocation, pickupTime, dropoffLocation, dropoffTime, driver);
        this.rider = rider;
    }

    @Override
    public IRider getRider() {
        return rider;
    }

    @Override
    public void setRider(IRider rider) {
        this.rider = rider;
    }
    @Override 
    public boolean hasRider() {
        return rider != null && rider.getId() == rider.getId();
    }

    @Override 
    public String toString() {
        return super.toString() + ", Rider: " + (rider != null ? rider.getName() : "None");
    }
}
