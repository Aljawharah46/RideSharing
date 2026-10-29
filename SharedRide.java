import java.util.LinkedList;

public class SharedRide extends Ride implements ISharedRide {

    private LinkedList<IRider> participants;

    public SharedRide(int rideId, String pickupLocation, IDateTime pickupTime, String dropoffLocation, IDateTime dropoffTime, IDriver driver) {
        super(rideId, pickupLocation, pickupTime, dropoffLocation, dropoffTime, driver);
        this.participants = new LinkedList<IRider>();
    }

    @Override 
    public LinkedList<IRider> getParticipants() {
        return participants;
    }

    @Override
    public boolean isEmpty(){
        return participants.empty();
    }

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
    @Override 
    public boolean addParticipant(IRider rider){

        if((rider == null) || hasRider(rider.getId()))
            return false;

        participants.insert(rider);
        return true;

    }

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
} 