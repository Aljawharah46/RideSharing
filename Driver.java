
public class Driver extends Person implements IDriver{
	private String vehiclePlate;
	private VehicleType vehicleType;
	
	public Driver (int Id, String n , String pn , String vp , VehicleType vt )
	{
		super(Id, n , pn);
		setVehiclePlate(vp);
		vehicleType = vt;
	}
	

    public String getVehiclePlate() {
    	return vehiclePlate;
    }

  
    public void setVehiclePlate(String vehiclePlate) throws IllegalArgumentException {
    	boolean valid = true; 
    	if (vehiclePlate != null && vehiclePlate.length() == 7 ) {
    		for ( int i = 0 ; i < 3 ; i++ )
    		if ( 'A' > vehiclePlate.charAt(i) || 'Z' < vehiclePlate.charAt(i))
    				valid = false;
    		for ( int i = 3 ; i < 7 ; i++ )
    		if ('0' > vehiclePlate.charAt(i) || vehiclePlate.charAt(i) > '9' )
    				valid = false;
    		if(!valid)
        		throw new IllegalArgumentException( "Vehicle plate is not valid" );  
    		else
    			this.vehiclePlate = vehiclePlate;
    				
    				}
    	else 
    		throw new IllegalArgumentException( "Vehicle plate is not valid" );  
    	}

    public VehicleType getVehicleType() {
    	return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
    	this.vehicleType = vehicleType;
    }

   
    @Override
    public int compareTo(IDriver other) {
    	if ( other.getId() > this.getId() )
    		return -1;
    	else if ( other.getId() == this.getId() )
    		return 0;
    	else
    		return 1; }
    
    public String toString() {
    	return "Driver " + super.toString() + "\nVehicle plate  : " + vehiclePlate + "\nVehicle type : " + vehicleType;
    }

    
}


