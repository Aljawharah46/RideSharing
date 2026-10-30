
public class RiderList implements IRiderList {
	private LinkedList<IRider> riders;
	
	public RiderList() {
		riders = new LinkedList<>(); 
	}
	
    public boolean add(IRider rider) {
    	//Email and ID unique 
    	if (findByEmail(rider.getEmail()) != null )
    		return false ;
    	if(riders.empty()) {
    		riders.insert(rider); 
        	return true ; 
    	}
    	riders.findFirst();
    	
    	while(true) {
    		int compare = riders.retrieve().compareTo(rider); 
    		if( compare == 0 ) //Rider with the same ID exist 
    			return false; 
    		else if ( compare > 0 ) {
    		riders.insertBefore(rider); 
    		return true; }
    		else 
    			if(riders.last()) {
    	    		riders.insert(rider);
    	    	return true ;  }
    		
    		riders.findNext();
    		} 
    		}
    
       
    public IRider findById(int riderId) {
    	if (!riders.empty()) {
   
    	riders.findFirst(); 
    	while (true) {
    		if (riders.retrieve().getId() == riderId )
    			return riders.retrieve();

    		if(riders.last())
    			break;
    		
    		riders.findNext(); }
    	}
    	
    	return null;
    	
    	}

    
    public LinkedList<IRider> findByName(String fullName){
    	LinkedList<IRider> LL= new LinkedList<IRider>();

    	if(!riders.empty()) { 
    	riders.findFirst();
    	
    	while(true) {
    
    		if (riders.retrieve().getName().equals(fullName)) 
    			LL.insert(riders.retrieve());
    			
    		if (riders.last())
    			break; 
    		
    		riders.findNext();
    		 	}
    	}
    	return LL;
    	}
    
    

    public IRider findByEmail(String email) {  	
    	if (!riders.empty()) {
   
    	riders.findFirst(); 
    	while (true) {
    		if (riders.retrieve().getEmail().equals(email) )
    			return riders.retrieve();

    		if(riders.last())
    			break;
    		
    		riders.findNext(); }
    	}
    	
    	return null;
    	}


    public LinkedList<IRider> findByHomeCity(String homeCity){
      	LinkedList<IRider> LL= new LinkedList<>();

    	if(!riders.empty()) { 
    	riders.findFirst();
    	
    	while(true) {
    
    		if (riders.retrieve().getHomeCity().equals(homeCity)) 
    			LL.insert(riders.retrieve());
    			
    		if (riders.last())
    			break; 
    		
    		riders.findNext();
    		 	}
    	}
    	return LL;
    	}

    public LinkedList<IRider> getAll(){
    	return riders; 
    }

    public boolean removeById(int riderId) {
    	if (!riders.empty()) {
    		riders.findFirst();
    		while (true) {
    			if(riders.retrieve().getId() == riderId) {
    				riders.remove();
    				return true;
    			}
  			if (riders.last())
    				break;

  			riders.findNext();
    		}

    	}
    	return false;
    }

    public boolean removeByEmail(String email) {
    	if (!riders.empty()) {
    		riders.findFirst();
    		while (true) {
    			if(riders.retrieve().getEmail().equals(email)) {
    				riders.remove();
    				return true;
    			}
  			if (riders.last())
    				break;

  			riders.findNext();
    		}

    	}
    	return false;
    
    }


    
    public int removeByName(String fullName) {
    	int count = 0 ;
     	if(!riders.empty() && fullName != null) {
     		LinkedList<IRider> remained= new LinkedList<>();
    		riders.findFirst();
    		while(true) {
    			IRider rider = riders.retrieve();
    			if (rider.getName().equals(fullName))
    				count++;
    			else 
    				remained.insert(rider);
    			if(riders.last())
    				break;
    			riders.findNext();
    		}
    		riders= remained;
     	}
    		return count;
    		}


    	
    

    
    public int removeByHomeCity(String homeCity) {
    	int count = 0 ;
     	if(!riders.empty() && homeCity != null) {
     		LinkedList<IRider> remained= new LinkedList<>();
    		riders.findFirst();
    		while(true) {
    			IRider rider = riders.retrieve();
    			if (rider.getHomeCity().equals(homeCity))
    				count++;
    			else 
    				remained.insert(rider);
    			if(riders.last())
    				break;
    			riders.findNext();
    		}
    		riders= remained;
     	}
    		return count;
    }

    public int size() {
    	int count = 0 ;
    	riders.findFirst();
    	if ( !riders.empty() )
    	while (true) {
    		count++;
    		if(riders.last())
    			break;
    		
    		riders.findNext();
    	}
    	return count;
    }
    
    }