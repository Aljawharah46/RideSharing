
public class Rider extends Person implements IRider {
	private String email;
	private String homeCity;
	
	public Rider( int Id , String name , String phoneNumber , String email , String homeCity ) {
		super(Id, name , phoneNumber);
		this.email = email;
		this.homeCity = homeCity;
	}
	
	
    public String getEmail() {
    	return email; 
    }

    public void setEmail(String email) {
    	this.email = email;
    }

    public String getHomeCity() {
    	return homeCity;
    }

    public void setHomeCity(String homeCity) {
    	this.homeCity = homeCity; 
    	}
    
   
    @Override
    public int compareTo(IRider other) {
    	if ( other.getId() > this.getId() )
    		return -1;
    	else if ( other.getId() == this.getId() )
    		return 0;
    	else
    		return 1; }
    
    public String toString() {
    	return "Rider " + super.toString() + "\nEmail : " + email + "\nHome city address : " + homeCity;
    }

}
