

public class SharedRide extends Ride implements ISharedRide {

    private LinkedList<IRider> participants;

    //constructor
    public SharedRide(int rideId, String pickupLocation, IDateTime pickupTime, String dropoffLocation, IDateTime dropoffTime, IDriver driver) {
        super(rideId, pickupLocation, pickupTime, dropoffLocation, dropoffTime, driver);
        this.participants = new LinkedList<IRider>();
    }

    //returns participants list
    @Override 
    public LinkedList<IRider> getParticipants() {
        return participants;
    }

    //checks if list is empty
    @Override
    public boolean isEmpty(){
        return participants.empty();
    }

    //searches for a rider by id
    @Override 
    public boolean hasRider(int riderId){

        if(participants.empty())
            return false;
        participants.findFirst();

        while(!participants.last()){
            if(participants.retrieve().getId() == riderId)
                return true;
            participants.findNext();    
        }

        return participants.retrieve().getId() == riderId; //to check last element
    }

    //adds a rider if not already in the ride
    @Override 
    public boolean addParticipant(IRider rider){

        if((rider == null) || hasRider(rider.getId()))
            return false;

        participants.insert(rider);
        return true;

    }

    //removes a particpant by their id
    @Override
    public boolean removeParticipantById(int riderId){

        if(participants.empty())
            return false;

        participants.findFirst();

        while(!participants.last()){

            if(participants.retrieve().getId() == riderId){
                participants.remove();
                return true;
            }

            participants.findNext();
        }

        if(participants.retrieve().getId() == riderId){
                participants.remove();
                return true;
        }
        return false;
    }
    
    //returns ride details and participants 
    @Override
    public String toString() {
        String result = super.toString() + ", Participants: ";

        if (participants.empty()) {
            return result + "None";
        }

        participants.findFirst();

        while (!participants.last()) {
            result += participants.retrieve().getName() + ", ";
            participants.findNext();
        }

        result += participants.retrieve().getName();

        return result;
    }
} 