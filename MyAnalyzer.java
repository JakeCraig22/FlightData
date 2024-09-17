import java.util.*;
import java.time.LocalDateTime;

/**
 * @author Jacob Craig & Troy Moscatelli
 * @version 9/16/2024
 * Takes the arraylist from MyDataReader and uses it for four methods. 
 */
public class MyAnalyzer {
	
	/**
	 * @param flights - array of the flight object
	 * @param left - the start index of the first subarray
	 * @param mid - the ending index of the first subarray
	 * @param right - the ending index of the second subarray
	 */
	public static void merge(Flight[] flights, int left, int mid, int right) {

	    int n1 = mid - left + 1; //the size of the first subarray
	    int n2 = right - mid;  //the size of the second subarray

	    // temporary arrays that hold elements from the two subarrays
	    Flight[] leftArray = new Flight[n1];
	    Flight[] rightArray = new Flight[n2];

	    // Copy data from flights to temp arrays
	    System.arraycopy(flights, left, leftArray, 0, n1);
	    System.arraycopy(flights, mid + 1, rightArray, 0, n2);
	    
	    int i = 0; // Initial index of the first subarray
	    int j = 0; // Initial index of the second subarray
	    int k = left; // Initial index of the merged subarray

	    /*
	     * The loop merges elements from both left and right arrays into 
	     * the flights array. The condition goes until there are no elements
	     * in both.
	     */
	    while (i < n1 && j < n2) {
	        if (leftArray[i].getPassengers() >= rightArray[j].getPassengers()) {
	            flights[k++] = leftArray[i++];
	        } else {
	            flights[k++] = rightArray[j++];
	        }
	    }

	    // Copy remaining elements of leftArray[]
	    while (i < n1) {
	        flights[k++] = leftArray[i++];
	    }

	    // Copy remaining elements of rightArray[]
	    while (j < n2) {
	        flights[k++] = rightArray[j++];
	    }
	}
	
	
	/**
	 * @param flights - the array of flights
	 * @param left - starting index of the array
	 * @param right - ending index of the array 
	 */
	public static void mergeSort(Flight[] flights, int left, int right) {
		
		if (left < right) { //base case if a file had 1 or 0 elements
			int mid = (left + right) / 2; // finds mid point of the array
			mergeSort(flights, left, mid); // sort first half
			mergeSort(flights, mid + 1, right); // sort second half
			
			merge(flights, left, mid, right); // sort into a single segment
		}
	}
	

   /**
 * @param flights
 * @return all airports in the state of maine that are on the list
 */
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
   
   
   /**
 * @param flights - array
 * @return max amount of passengers that came to PWM
 */
	public static int getMaxPassengersToPWM(Flight[] flights) {
       Flight[] pwmFlights = new Flight[flights.length];
       int count = 0;
       
     //filters out flights where the destination is PWM and stores them in a new pwmFlights array
       for (Flight flight : flights) { 
    	   if (flight != null && flight.getDestination().getAirportName().equalsIgnoreCase("PWM")) {
    		   pwmFlights[count++] = flight;
    	   }
       }
       
       //creates a new array with the exact size 
       Flight[] filteredFlights = new Flight[count];
       for (int i = 0; i < count; i++) {
    	   filteredFlights[i] = pwmFlights[i];
       }
       
       /*
        * calls mergesort method to recursively divide the array 
        * into smaller subarrays where they are sorted.
        */
       mergeSort(filteredFlights, 0, filteredFlights.length - 1);
       
       /*
        *  After sorting, the first element in filteredFlights
        *   is the flight with the max passengers
        */
       return filteredFlights.length > 0 ? filteredFlights[0].getPassengers() : 0;
   }
   
   /**
 * @param flights - flights array
 * @return - the percentage of flights with no empty seats
 */
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

   /**
 * @param flights - flights array
 * @return the average number of passengers on flights from PWM to Florida in 2009
 */
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
