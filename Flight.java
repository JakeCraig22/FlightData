import java.time.LocalDateTime;

public class Flight {

	private Airport origin;
	private Airport destination;
	private int passengers; 
	private int seats;
	private double distance;
	private LocalDateTime flightDate;
	
	//constructor to initialize the object flight
	
	public Flight(Airport origin, Airport destination, int passengers, int seats, double distance, LocalDateTime flightDate) {
		this.origin = origin;
		this.destination = destination;
		this.passengers = passengers;
		this.seats = seats;
		this.distance = distance;
		this.flightDate = flightDate;
	}

	public Airport getOrigin() {
		return origin;
	}

	public void setOrigin(Airport origin) {
		this.origin = origin;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public LocalDateTime getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDateTime flightDate) {
		this.flightDate = flightDate;
	}

	@Override
	public String toString() {
		return origin + ", " + destination + ", " + passengers + ", "  + seats + ", " + distance + ", " + flightDate;
	}
	
	
}
