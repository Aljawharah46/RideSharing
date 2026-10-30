
public abstract class Person implements IPerson {
	private final int Id;
	private String name;
	private String phoneNumber;
	private LinkedList<IRide> rideHistory; 
	
	public Person(int Id , String n , String pn) {
		this.Id = Id;
		name = n;
		setPhoneNumber(pn);
		rideHistory = new LinkedList<IRide>();
	}
        @Override 
	    public int getId() {
        	return Id; 
        }

	    @Override 
	    public String getName() {
	    	return name;
	    }

	    @Override 
	    public void setName(String name) {
	    	this.name = name;
	    }

	    @Override 
	    public String getPhoneNumber() {
	    	return phoneNumber;
	    }

	    
	    @Override 
	    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
	    	if ( phoneNumber != null && phoneNumber.length() == 10 ) { 
	    		
	    	for ( int i = 0 ; i < phoneNumber .length() ; i++ ) 
	    		if( !Character.isDigit( phoneNumber.charAt(i) ))
	    			 throw new IllegalArgumentException( "Phone number must contain exactly 10 digits." ); 
	    	
	    	this.phoneNumber = phoneNumber;
	    		    	
	    	}
	    	else 	
	    		throw new IllegalArgumentException( "Phone number must contain exactly 10 digits." );  
	    	}
	 

	    @Override 
	    public LinkedList<IRide> getRideHistory(){
	    	return rideHistory;
	    }

	    @Override
	    public String toString() { 
	    	return "ID : " + Id + " Name : " + name + "\nPhone number : " + phoneNumber + " Ride history : \n" + rideHistory.toString() ;
	    }
	}

