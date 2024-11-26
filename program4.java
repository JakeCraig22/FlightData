package flightpack;
import java.time.LocalDateTime;
import java.util.*;

public class program4 {
	
	public static void main(String[] args) throws Exception{
		String filePath = args[0];
		String state = args[1];
		String airport = args[2];
		
		long startTime = System.currentTimeMillis();
		Flight[] allFlights = MyDataReader.readFlightsFromFile(filePath);
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + " ms to read flights from file");
		
		startTime = System.currentTimeMillis();
		ArrayList<Flight> airportFlights = MyDataReader.FlightSorted(airport, allFlights);
		endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + " ms to filter and sort flights for " + airport);
		
		startTime = System.currentTimeMillis();
		int minCounters = calculateMinimumCounters(airportFlights);
		endTime = System.currentTimeMillis();
	    System.out.println((endTime - startTime) + " ms to find the minimum number of counters");
	    
	    System.out.println("Minimum number of counters for " + airport + ": " + minCounters);
	}
	
	private static int calculateMinimumCounters(ArrayList<Flight> airportFlights) {
		int counters = 1;
		boolean processedSuccessfully = false;
		
		while(!processedSuccessfully) {
			QueueSimulator simulator = new QueueSimulator(airportFlights, counters);
			processedSuccessfully = simulator.simulation();
			
			if(!processedSuccessfully) {
				counters++;
			}
		}
		return counters;
	}
	
}
