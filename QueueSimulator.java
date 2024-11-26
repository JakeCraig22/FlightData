package flightpack;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class QueueSimulator {
    private ArrayList<Flight> aList;
    private MyQueue<Flight> queue; 
    private int processTime; 

    /**
     * Constructor to initialize the simulator
     * @param aList ArrayList of flights for simulation
     * @param numberCounter Number of counters for simulation
     */
    public QueueSimulator(ArrayList<Flight> aList, int numberCounter) {
        this.aList = new ArrayList<>(aList); // Copy the flight list
        this.queue = new MyQueue<Flight>();
        this.processTime = numberCounter * 60 * 60; // Processing time based on counters
    }

    /**
     * Method to simulate passenger processing at the counters
     * @return true if all passengers are processed successfully
     */
    public boolean simulation() {
        if (aList.isEmpty()) {
            return true; // If no flights, consider it processed
        }

        // Start simulation from the time of the first flight
        LocalDateTime ldtStart = aList.get(0).getFlightDate().minusHours(1);
        LocalDateTime ldtEnd = aList.get(aList.size() - 1).getFlightDate();

        for (LocalDateTime ldt = ldtStart; !ldt.isAfter(ldtEnd); ldt = ldt.plusHours(1)) {
            // Add passengers to the queue for the current time step
            addPassengers(ldt);
            // Process the flights in the queue
            if (!processTheQueue()) {
                return false; // If processing fails, return false
            }
        }
        return true; // All passengers processed successfully
    }

    /**
     * Method to process the queue of flights for a given time period
     * @return true if all flights are processed within the available time
     */
    private boolean processTheQueue() {
        int currentProcessTime = processTime;

        while (currentProcessTime > 0 && !queue.isEmpty()) {
            Flight temp = queue.poll();
            currentProcessTime -= (6 * temp.getPassengers()); // Processing passengers at 6 per second
        }

        // Return false if we ran out of time, otherwise true
        return currentProcessTime >= 0;
    }

    /**
     * Adds flights arriving at the specified time to the queue
     * @param ldt LocalDateTime of the current time step in the simulation
     */
    private void addPassengers(LocalDateTime ldt) {
        // Ensure there are flights to process
        while (!aList.isEmpty() && aList.get(0).getFlightDate().isBefore(ldt.plusHours(1))) {
            queue.offer(aList.get(0));
            aList.remove(0); // Remove processed flight from the list
        }
    }
}