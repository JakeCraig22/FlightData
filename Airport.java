
public class Airport {
	
	private String name;
	private String city;
	private String state;
	
	//Constructor to initialize the object Airport with values. 
	public Airport(String name, String city, String state) {
		this.name = name;
		this.city = city;
		this.state = state; 
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getAirportName() {
		return name;
	}
	public String getCityName() {
		return city;
	}
	public String getStateName() {
		return state;
	}
	
	 @Override
	    public String toString() {
	        return name + ", " + city + ", " + state;
	    }
	
}
