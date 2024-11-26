/*
 * @author Jake craig
 * @version 10/1/2024
 * 
 * Stores object off the flight class. Makes a singly linked list where each
 * node contains two pointers, one to the next chronological flight and one to
 * the next flight with the same origin. Goes in asccending order. 
 */

package flightpack;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList {
    
    private class Node {
        Flight flight;
        Node next;
        Node sameOriginNext;

        Node(Flight flight) {
            this.flight = flight;
        }
    }

    private Node head;

    // Method to add flights to the list, maintaining the order based on flight date
    public void add(Flight flight) {
        Node newNode = new Node(flight);
        
        if (head == null || flight.compareTo(head.flight) < 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && flight.compareTo(current.next.flight) > 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        
    }

    /**
     * used StackOverflow as a reference
     * Reference: https://tinyurl.com/mwswwmhb
     */
    void updateSameOriginPointers() {
        if (head == null) return;

        // Iterate over the list for each node and set sameOriginNext
        for (Node current = head; current != null; current = current.next) {
            Node temp = current.next;
            while (temp != null) {
                if (temp.flight.getOrigin().getAirportName().equals(current.flight.getOrigin().getAirportName())) {
                    current.sameOriginNext = temp;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    // Iterator method to return flights from a specific airport within a date range
    public Iterator<Flight> iterator(String airport, LocalDateTime start, LocalDateTime end) {
        return new MyItr(airport, start, end);
    }

    // Inner class MyItr to handle iteration over the list
    private class MyItr implements Iterator<Flight> {
        private Node current;
        private String airport;
        private LocalDateTime start;
        private LocalDateTime end;

        MyItr(String airport, LocalDateTime start, LocalDateTime end) {
            this.airport = airport;
            this.start = start;
            this.end = end;
            this.current = head;
            
            // Move the current pointer to the first relevant flight
            while (current != null && 
                   (!current.flight.getOrigin().getAirportName().equals(airport) ||
                    current.flight.getFlightDate().isBefore(start) ||
                    current.flight.getFlightDate().isAfter(end))) {
            		current = current.next;
            }
        }

        @Override
        public boolean hasNext() {
        	 while (current != null && 
        	           (!current.flight.getOrigin().getAirportName().equals(airport) ||
        	            current.flight.getFlightDate().toLocalDate().isBefore(start.toLocalDate()) ||
        	            current.flight.getFlightDate().toLocalDate().isAfter(end.toLocalDate()))) {
        	        current = current.next;
        	    }
        	    return current != null;
        }

        @Override
        public Flight next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Flight flight = current.flight;
            
            // Move to the next relevant flight
            
            current = current.sameOriginNext != null ? current.sameOriginNext : current.next;

            return flight;
        }
    }
}