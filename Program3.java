/*
 * @author jacob craig
 * @version 10/1/2024
 */
/*
package flightpack;

import java.time.LocalDateTime;
import java.util.Iterator;

public class Program3 {
    public static void main(String[] args) throws Exception {
        String filePath = args[0]; // flights.csv
        String state = args[1]; // ME
        String[] airports = {args[2], args[3], args[4]}; // PWM, BGR, AUG
        
        
        long startTime = System.currentTimeMillis();
        // Read the flights from the file for the given state
        MyLinkedList flightsList = MyDataReader.readFlightsByOriginState(filePath, state);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms to read file");
        
        startTime = System.currentTimeMillis();
        flightsList.updateSameOriginPointers();
        endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " ms to fix sameOrigin pointers");
        
        // Print passenger numbers for each airport
        for (String airport : airports) {
            System.out.println("Printing the number of passengers from [" + airport + "]:");
            startTime = System.currentTimeMillis();
            for (int year = 1994; year <= 2009; year++) {
                LocalDateTime start = LocalDateTime.of(year, 1, 1, 0, 0);
                LocalDateTime end = LocalDateTime.of(year, 12, 31, 23, 59);
                Iterator<Flight> itr = flightsList.iterator(airport, start, end);
                
                int totalPassengers = 0;
                while (itr.hasNext()) {
                    Flight flight = itr.next();
                    totalPassengers += flight.getPassengers();
                }
                
                System.out.println(year + ", " + totalPassengers);
            }
            endTime = System.currentTimeMillis();
            System.out.println((endTime - startTime) + " ms to count passengers for [" + airport + "]");
        }
    }
} */