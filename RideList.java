import java.util.LinkedList;

public class RideList implements IRideList{

    private LinkedList<IRide> rides;
    private int count;

    public RideList() {
        rides = new LinkedList<IRide>();
        count = 0;
    }

    @Override
    public boolean addRide(IRide ride){

        if(ride == null)
            return false;

        LinkedList<IRide> sorted = new LinkedList<IRide>();

        if(rides.empty()){
            rides.insert(ride);
            count++;
            return true;
        }

        rides.findFirst();
        boolean added=false;

        while(!rides.last()){
            if(!added && ride.compareTo(ride.retrieve())<0){
                sorted.insert(ride);
                added=true;
            }

            sorted.insert(rides.retrieve());
            rides.findNext();
        }

        if(!added && ride.compareTo(ride.retrieve())<0){
                sorted.insert(ride);
                added=true;
        }
        sorted.insert(rides.retrieve());

        if(!added){
            sorted.insert(ride);
        }
        rides = sorted;
        count++;

        return true;

    } 

    @Override
    public boolean removeRideById(int rideId){

        if(rides.empty())
            return false;

        rides.findFirst();

        while(!rides.last()){
            
            if(rides.retrieve().getRideId() == rideId){
                rides.remove();
                count--;
                return true;
            }

            rides.findNext();
        }

        if(rides.retrieve().getRideId() == rideId){
                rides.remove();
                count--;
                return true;
        }
        return false;

    }

    @Override 
    public LinkedList<IRide> getAllAlphabetically(){
        return rides;
    }

    @Override 
    public LinkedList<IRide> findByPickupLocation(String pickupLocation){

        LinkedList<IRide> result = new LinkedList<IRide>;

        if(rides.empty())
            return result;

        rides.findFirst();

        while(!rides.last()){

            if(rides.retrieve().getPickupLocation().equals(pickupLocation)){
                result.insert(rides.retrieve());
            }

            rides.findNext();
        }

         if(rides.retrieve().getPickupLocation().equals(pickupLocation)){
                result.insert(rides.retrieve());
            }

            return result;
    }

    @Override 
    public LinkedList<IRide> findByRiderName(String riderFullName){

        LinkedList<IRide> result = new LinkedList<IRide>();

        if(rides.empty())
            return result;

        rides.findFirst();

        while(true){

            IRide ride= rides.retrieve();
            boolean found=false;

            if(ride instanceof IPrivateRide){

                IRider rider= ((IPrivateRide) ride).getRider();

                if(rider != null && rider.getName().equalsIgnoreCase(riderFullName))
                    found=true;
            }

            else if(ride instanceof ISharedRide){

                LinkedList<IRider> participants= ((ISharedRide) ride).getParticipants();

                if(!participants.empty()){

                    participants.findFirst();

                    while(!participants.last() && !found){

                        if(participants.retrieve().getName().equalsIgnoreCase(riderFullName))
                            found=true;

                        participants.findNext();
                    }

                    if(participants.retrieve().getName().equalsIgnoreCase(riderFullName))
                        found=true;
                }


            }

            if(found)
                result.insert(ride);

            if(rides.last())
                break;

            rides.findNext();

        }

        return result;

    }

    @Override 
    public int size(){
        return count;
    }

}
