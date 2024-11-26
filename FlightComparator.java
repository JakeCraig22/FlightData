/**
 * @author jacob craig
 * @version 9/23/2024
 * 
 * implements comparator to compare flights from the flight.csv file
 */

package flightpack;
import java.util.Comparator;

public class FlightComparator implements Comparator<Flight> {

	public int compare(Flight flight1, Flight flight2) {
		String origin1 = flight1.getOrigin().getAirportName();
		String origin2 = flight2.getOrigin().getAirportName();
		return origin1.compareTo(origin2);
	}
}
