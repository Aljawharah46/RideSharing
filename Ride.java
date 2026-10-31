public abstract class Ride implements IRide {
    private int rideId;
    private String pickupLocation;
    private IDateTime pickupTime;
    private String dropoffLocation;
    private IDateTime dropoffTime;
    private IDriver driver;

    //constructor
    public Ride(int rideId, String pickupLocation, IDateTime pickupTime, String dropoffLocation, IDateTime dropoffTime, IDriver driver) {
        this.rideId = rideId;
        this.pickupLocation = pickupLocation;
        this.pickupTime = pickupTime;
        this.dropoffLocation = dropoffLocation;
        this.dropoffTime = dropoffTime;
        this.driver = driver;
    }

    //setters and getters
    @Override
    public int getRideId() {
        return rideId;
    }

    @Override
    public String getPickupLocation() {
        return pickupLocation;
    }

    @Override
    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    @Override
    public IDateTime getPickupTime() {
        return pickupTime;
    }

    @Override
    public String getDropoffLocation() {
        return dropoffLocation;
    }

    @Override
    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    @Override
    public IDateTime getDropoffTime() {
        return dropoffTime;
    }

    @Override
    public IDriver getDriver() {
        return driver;
    }

    @Override
    public void setDriver(IDriver driver) {
        this.driver = driver;
    }


    //checks if a rider is part of the ride
    @Override
    public abstract boolean hasRider(int riderId);
    
    //compares rides by pickup location
    @Override
    public int compareTo(IRide other) {
        return this.pickupLocation.compareToIgnoreCase(other.getPickupLocation());
    }

    //returns ride info
    @Override
    public String toString() {
        return String.format("Ride ID: %d, Pickup: %s at %s, Dropoff: %s at %s, Driver: %s",
                rideId, pickupLocation, pickupTime.format(), dropoffLocation, dropoffTime.format(),
                driver != null ? driver.getName() : "No driver assigned");
    }

}
