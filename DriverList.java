
public class DriverList implements IDriverList{
	private LinkedList<IDriver> drivers;

	public DriverList() {
		drivers = new LinkedList<>();
	}
	
    public boolean add(IDriver driver) {
    	//vehicle plate and ID unique 
    	if (findByVehiclePlate(driver.getVehiclePlate()) != null )
    		return false ;
  
    	if(drivers.empty()) {
    		drivers.insert(driver); 
        	return true ; 
    	}
    	
    	drivers.findFirst();
    	while(true) {
    		int compare = drivers.retrieve().compareTo(driver); 
    		if( compare == 0 ) //driver with the same ID exist 
    			return false; 
    		else if ( compare > 0 ) {
    		drivers.insertBefore(driver); 
    		return true; }
    		else 
    			if(drivers.last()) {
    				drivers.insert(driver);
    				return true ; }
    	    		drivers.findNext();
    			}
    		}
    		

    public IDriver findById(int driverId) {
    	if (!drivers.empty()) {
    		   
        	drivers.findFirst(); 
        	while (true) {
        		if (drivers.retrieve().getId() == driverId )
        			return drivers.retrieve();

        		if(drivers.last())
        			break;
        		
        		drivers.findNext(); }
        	}
        	
        	return null;
    }

    
    public LinkedList<IDriver> findByName(String fullName){
        	LinkedList<IDriver> LL= new LinkedList<IDriver>();

        	if(!drivers.empty()) { 
        	drivers.findFirst();
        	
        	while(true) {
        
        		if (drivers.retrieve().getName().equals(fullName)) 
        			LL.insert(drivers.retrieve());
        			
        		if (drivers.last())
        			break; 
        		
        		drivers.findNext();
        		 	}
        	}
        	return LL;
        }
    	


    public IDriver findByVehiclePlate(String vehiclePlate) {
    	if(!drivers.empty()) {
    		drivers.findFirst();
    		while(true) {
    			if(drivers.retrieve().getVehiclePlate().equals(vehiclePlate))
    				return drivers.retrieve();
    			if(drivers.last())
    				break;
    			drivers.findNext();
    			}
    	}
    		return null;	
    }

    public LinkedList<IDriver> findByVehicleType(VehicleType vehicleType){
    	LinkedList<IDriver> LL = new LinkedList<>();
    	if(!drivers.empty()) {
    		drivers.findFirst();
    		while(true) {
    			if(drivers.retrieve().getVehicleType().equals(vehicleType))
    				LL.insert(drivers.retrieve());
    			if(drivers.last())
    				break;
    			drivers.findNext();
    			}
    	}
    	return LL;
    }

    public LinkedList<IDriver> getAll(){
    	return drivers;
    }

    public boolean removeById(int driverId) {
    	if (!drivers.empty()) {
    		drivers.findFirst();
    		while (true) {
    			if(drivers.retrieve().getId() == driverId) {
    				drivers.remove();
    				return true;
    			}
  			if (drivers.last())
    				break;

  			drivers.findNext();
    		}
    	}
    	return false;
    }

    public boolean removeByVehiclePlate(String vehiclePlate) {
    	if (!drivers.empty()) {
    		drivers.findFirst();
    		while (true) {
    			if(drivers.retrieve().getVehiclePlate().equals(vehiclePlate)) {
    				drivers.remove();
    				return true;
    			}
  			if (drivers.last())
    				break;

  			drivers.findNext();
    		}
    	}
    	return false;
    }

    
    public int removeByName(String fullName) {
    	int count = 0 ;
     	if(!drivers.empty() && fullName != null) {
     		LinkedList<IDriver> remained= new LinkedList<>();
    		drivers.findFirst();
    		while(true) {
    			IDriver driver = drivers.retrieve();
    			if (driver.getName().equals(fullName))
    				count++;
    			else 
    				remained.insert(driver);
    			if(drivers.last())
    				break;
    			drivers.findNext();
    		}
    		drivers= remained;
     	}
    		return count;
    }

 
    public int removeByVehicleType(VehicleType vehicleType) {
        	int count = 0 ;
         	if(!drivers.empty() && vehicleType != null) {
         		LinkedList<IDriver> remained= new LinkedList<>();
        		drivers.findFirst();
        		while(true) {
        			IDriver driver = drivers.retrieve();
        			if (driver.getVehicleType().equals(vehicleType))
        				count++;
        			else 
        				remained.insert(driver);
        			if(drivers.last())
        				break;
        			drivers.findNext();
        		}
        		drivers= remained;
         	}
        		return count;
        }

    public int size() {
    	int count = 0 ;
    	if(!drivers.empty()) {
    		drivers.findFirst();
    	while (true) {
    		count++;
    		if (drivers.last())
				break;
			drivers.findNext();
    	}
    	}
    	return count;
    	}
    
}
