package flightpack;
import java.io.FileNotFoundException;
import java.util.*;
public class Program1 {
   public static void main(String[] args) throws FileNotFoundException {
       
	   // File path to the CSV file
       	String filePath = args[0];
       	long fileReaderStart = System.currentTimeMillis();
       	
        Flight[] flights = MyDataReader.readFlightsFromFile(filePath);
       	
		long fileReaderEnd = System.currentTimeMillis();
		System.out.println((fileReaderEnd - fileReaderStart) + " milliseconds to read the file");
     
       // Test Method A: Get Airports in Maine
       long AirportsInMaineStart = System.currentTimeMillis();
       Set<String> airportsInMaine = MyAnalyzer.getAirportsInMaine(flights);
       int count = 0;
       int size = airportsInMaine.size();
       System.out.print("Name of all of the airports in Maine: ");
       for (String airport : airportsInMaine) {
           System.out.print(airport);
           if (count < size - 1) {
        	   System.out.print(", ");
           }
           count++;
       }
       long AirportsInMaineEnd = System.currentTimeMillis();
       System.out.println("");
       System.out.println((AirportsInMaineEnd - AirportsInMaineStart) + " milliseconds for task 4.a");
       
       // Test Method B: Get Max Passengers to PWM
		long maxPassengersStart = System.currentTimeMillis();
       int maxPassengersToPWM = MyAnalyzer.getMaxPassengersToPWM(flights);
       System.out.println("The maximum passengers coming PWM with one flight: " + maxPassengersToPWM);
       long MaxPassengersEnd = System.currentTimeMillis();
       System.out.println((MaxPassengersEnd - maxPassengersStart) + " Milliseconds for task 4.b");
       
       // Test Method C: Get Flights with No Empty Seats Percentage
       long noEmptySeatsPercStart = System.currentTimeMillis();
       double noEmptySeatsPercentage = MyAnalyzer.getFlightsWithNoEmptySeatsPercentage(flights);
       System.out.println("The percentage of flights with no empty seats: " + noEmptySeatsPercentage + "%");
       long noEmptySeatsPercEnd = System.currentTimeMillis();
       System.out.println((noEmptySeatsPercEnd - noEmptySeatsPercStart) + " Milliseconds for task 4.c");
       
       // Test Method D: Get Average Passengers from PWM to Florida in 2009
       long avgPasToFlStart = System.currentTimeMillis();
       double averagePassengersToFL = MyAnalyzer.getAveragePassengersFromPWMtoFLIn2009(flights);
       System.out.println("The average number of passengers from PWM to FL in 2009: " + averagePassengersToFL);
       long avgPasToFlEnd = System.currentTimeMillis();
       System.out.println((avgPasToFlEnd - avgPasToFlStart) + " Milliseconds for ask 4.d");
   }
}
