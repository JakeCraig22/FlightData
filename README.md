# FlightData
Takes Flight Data between 1994-2009 from a CSV file and reads them into an arraylist (a little over 1 million entries.) 

Airport.java - initializes variables name, city, and state. Each has a getter and setter as well as a public toString to return the three objects. 

Flight.java - initializes variables origin, destination, passengers, seats, distance, flightDate. Each has a getter and settr as well as a public toString to return the six objects. 

FlightComparator.java - compares two flights based on their origin properties

MyArrayList - A dynamic array-based list that uses elements of type T with the comparable interface
-Adds elements to a list and gets elements from the list.
-Has a sorting (insertion sort) method for the arraylist

MyAnalyzer.java - Has four tasks
  - Reads through the file to find all of the airports in the state of Maine
  - Finds the maximum number of passengers that came to Portland Maine within a flight
  - Finds the percentage of flights with no empty seats
  - Finds the average number of passengers on flights from PWM to Florida in 2009.

MyDataReader - Reads the CSV file and uses lineToReport method to set elements of an array
Cite: https://www.baeldung.com/java-csv-file-array 

MyLinkedList - Singly linked list for the flight objects. Each node has two pointers (one for the enxt flight chronologically and another for the flights of same origins) Methods include adding flights to the list, updating the pointers after insetion and iterating. 

MyQueue - Uses An arraylist to put flights in a queue

QueueSimulator - A class that simulates an airport security check queue. Determines if passengers can be admitted within a time frame based on flight schedules. Uses the MyQueue class for flight processing 
- initializes list of flights and num of counters
- simulates passengers processing based on arrival/counter capacity
- processes passengers at a fixed rate

Program 1 - Testing of myDataReader to print out the first 10000 entries in the CSV file. 

Program 2 - Testing of MyAnalyzer tasks 

Program 3 - Testing of mylinkedlist

Program 4 - Testing of QueueSimulator
