import java.util.*;
import java.time.LocalDateTime;


public class MyAnalyzer {
	
	public static void merge(Flight[] flights, int left, int mid, int right) {
	    // Two subarrays to be merged
	    int n1 = mid - left + 1;
	    int n2 = right - mid;

	    // temporary arrays
	    Flight[] leftArray = new Flight[n1];
	    Flight[] rightArray = new Flight[n2];

	    // Copy data to those temporary arrays
	    System.arraycopy(flights, left, leftArray, 0, n1);
	    System.arraycopy(flights, mid + 1, rightArray, 0, n2);

	    // Merge the temporary arrays back into the original array
	    int i = 0; // Initial index of the first subarray
	    int j = 0; // Initial index of the second subarray
	    int k = left; // Initial index of the merged subarray

	    while (i < n1 && j < n2) {
	        if (leftArray[i].getPassengers() >= rightArray[j].getPassengers()) {
	            flights[k++] = leftArray[i++];
	        } else {
	            flights[k++] = rightArray[j++];
	        }
	    }

	    // Copy remaining elements of leftArray[], if any
	    while (i < n1) {
	        flights[k++] = leftArray[i++];
	    }

	    // Copy remaining elements of rightArray[], if any
	    while (j < n2) {
	        flights[k++] = rightArray[j++];
	    }
	}
	
	public static void mergeSort(Flight[] flights, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(flights, left, mid);
			mergeSort(flights, mid + 1, right);
			
			merge(flights, left, mid, right);
		}
	}
	
   // a. Name of all the Airports in the state of Maine (Unique names)
   public static Set<String> getAirportsInMaine(Flight[] flights) {
       Set<String> airports = new HashSet<>();
       for (Flight flight : flights) {
           if (flight != null && flight.getOrigin().getStateName().equalsIgnoreCase("ME")) {
               airports.add(flight.getOrigin().getAirportName());
           }
           if (flight != null && flight.getDestination().getStateName().equalsIgnoreCase("ME")) {
               airports.add(flight.getDestination().getAirportName());
           }
       }
       return airports;
   }
   
   // b. The maximum number of passengers coming to PWM (Portland, Maine)
   public static int getMaxPassengersToPWM(Flight[] flights) {
       Flight[] pwmFlights = new Flight[flights.length];
       int count = 0;
       
       for (Flight flight : flights) {
    	   if (flight != null && flight.getDestination().getAirportName().equalsIgnoreCase("PWM")) {
    		   pwmFlights[count++] = flight;
    	   }
       }
       
       Flight[] filteredFlights = new Flight[count];
       for (int i = 0; i < count; i++) {
    	   filteredFlights[i] = pwmFlights[i];
       }
       mergeSort(filteredFlights, 0, filteredFlights.length - 1);
       
       return filteredFlights.length > 0 ? filteredFlights[0].getPassengers() : 0;
   }
   
   // c. The percentage of flights with no empty seats
   public static double getFlightsWithNoEmptySeatsPercentage(Flight[] flights) {
       int fullFlights = 0;
       int totalFlights = 0;
       for (Flight flight : flights) {
           if (flight != null) {
               totalFlights++;
               if (flight.getPassengers() == flight.getSeats()) {
                   fullFlights++;
               }
           }
       }
       return totalFlights == 0 ? 0 : (fullFlights * 100.0) / totalFlights;
   }
   // d. The average number of passengers on flights from PWM to Florida in 2009
   public static double getAveragePassengersFromPWMtoFLIn2009(Flight[] flights) {
       int totalPassengers = 0;
       int flightCount = 0;
       for (Flight flight : flights) {
           if (flight != null &&
               flight.getOrigin().getAirportName().equalsIgnoreCase("PWM") &&
               flight.getDestination().getStateName().equalsIgnoreCase("FL") &&
               flight.getFlightDate().getYear() == 2009) {
               totalPassengers += flight.getPassengers();
               flightCount++;
           }
       }
       return flightCount == 0 ? 0 : (double) totalPassengers / flightCount;
   }
}
