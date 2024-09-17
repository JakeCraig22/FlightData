import java.io.FileNotFoundException;
import java.util.*;
public class Program2 {
   public static void main(String[] args) throws FileNotFoundException {
       
	   // File path to the CSV file
       String filePath = "resources/flights.csv";
       
       // Use MyDataReader to read the CSV file and get the array of Flight objects
       Flight[] flights = MyDataReader.readFlightsFromFile(filePath);

       // Test Method A: Get Airports in Maine
       Set<String> airportsInMaine = MyAnalyzer.getAirportsInMaine(flights);
       System.out.println("Airports in Maine:");
       for (String airport : airportsInMaine) {
           System.out.println(airport);
       }
       
       // Test Method B: Get Max Passengers to PWM
       int maxPassengersToPWM = MyAnalyzer.getMaxPassengersToPWM(flights);
       System.out.println("Maximum passengers to PWM: " + maxPassengersToPWM);
       
       // Test Method C: Get Flights with No Empty Seats Percentage
       double noEmptySeatsPercentage = MyAnalyzer.getFlightsWithNoEmptySeatsPercentage(flights);
       System.out.println("Percentage of flights with no empty seats: " + noEmptySeatsPercentage + "%");
       
       // Test Method D: Get Average Passengers from PWM to Florida in 2009
       double averagePassengersToFL = MyAnalyzer.getAveragePassengersFromPWMtoFLIn2009(flights);
       System.out.println("Average passengers from PWM to Florida in 2009: " + averagePassengersToFL);

   }
}
