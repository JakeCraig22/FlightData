/**
 * class to provide the basic queue operations for 
 * MyQueue implemented with array lists
 */
package flightpack;
import java.util.ArrayList;

public class MyQueue<T> {
	ArrayList<T> queue;
	
	/**
	 * constructor for MyQueue
	 */
	public MyQueue() {
		queue = new ArrayList<T>();
	}
	
	/**
	 * method to add element to queue
	 * @param input
	 * @return true if element successfully added
	 */
	public boolean offer(T input) {
		return queue.add(input);
	}
	/**
	 * method to return and remove top item
	 * @return top item of queue
	 */
	public T poll() {
		T item = queue.remove(0);
		return item;
	}
	/**
	 * method to see if the queue is currently empty
	 * 
	 * @return true if queue is empty
	 */
	public boolean isEmpty() {
		return queue.isEmpty(); //?
	}
	/**
	 * method to see the size of the queue
	 * @return size of queue
	 */
	public int size() {
		return queue.size();
	}
	
	
	/**
	 * method to peek at the top of queue
	 * @return return first item in the queue
	 */
	public T peek() {
		if(queue.isEmpty()) {
			return null;
		}
		return queue.get(0);
	}

}

