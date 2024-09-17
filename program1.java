import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class program1 {

	public static void main(String[] args) {
		
		String filePath = args[0];
		
		try {
			Flight[] flights = MyDataReader.readFlightsFromFile(filePath);
			int testLimit = 10000;
			for (int i = 0; i < Math.min(testLimit, flights.length); i++) {
				System.out.println(flights[i]);
			}
		}catch (FileNotFoundException e) {
			System.err.println("File not found");
		}
	}

}
