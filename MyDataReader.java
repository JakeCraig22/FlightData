import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
    
public class MyDataReader {
	
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH");
	
	public static LocalDateTime dateConvert(String dateTimeString) {
		return LocalDateTime.parse(dateTimeString, formatter);
	}
	
	
	private static Flight lineToReport(String inputLine) {
		String[]items = inputLine.split(",");
		String originName = items[0];
		String originCity = items[1];
		String originState = items[2];
		
		Airport origin = new Airport(originName, originCity, originState);
		Airport destination = new Airport(items[3], items[4], items[5]);
		int passenger = Integer.parseInt(items[6]);
		int seats = Integer.parseInt(items[7]);
		int distance = Integer.parseInt(items[8]);
	 	LocalDateTime flightDate = dateConvert(items[9]);
		return new Flight(origin, destination, passenger, seats, distance, flightDate);
	}
	

	public static Flight[] readFlightsFromFile(String filePath) throws FileNotFoundException{
		int numFlights = 3000000; 
		Flight[] flights = new Flight[numFlights];
		int index = 0; 
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			
			String line;
			br.readLine();
			
			while((line = br.readLine()) != null && index < numFlights) {
				Flight flight = lineToReport(line);
				flights[index++] = flight;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Arrays.copyOf(flights, index);
	}
	
}
	