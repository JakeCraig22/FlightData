# FlightData
Takes Flight Data between 1994-2009 from a CSV file and reads them into an arraylist (a little over 1 million entries.) 

Airport.java - initializes variables name, city, and state. Each has a getter and setter as well as a public toString to return the three objects. 

Flight.java - initializes variables origin, destination, passengers, seats, distance, flightDate. Each has a getter and settr as well as a public toString to return the six objects. 

MyAnalyzer.java - Has four tasks
  - Reads through the file to find all of the airports in the state of Maine
  - Finds the maximum number of passengers that came to Portland Maine within a flight
  - Finds the percentage of flights with no empty seats
  - Finds the average number of passengers on flights from PWM to Florida in 2009.

MyDataReader - Reads the CSV file and uses lineToReport method to set elements of an array

Program 1 - Testing of myDataReader to print out the first 10000 entries in the CSV file. 

Program 2 - Testing of MyAnalyzer tasks 
