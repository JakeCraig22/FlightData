package flightpack;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MyArrayList<T extends Comparable<T>> {
	private T[] elements;
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	
	public MyArrayList() {
		elements = (T[]) new Comparable [DEFAULT_CAPACITY];
	}
	
	public void add(T element){
		if(size==elements.length) {
			elements = ensureCapacity();
		}
		elements[size++] = element;
	}
	
	private T[] ensureCapacity() {
		int capacity = elements.length;
		capacity*=2;
		return Arrays.copyOf(elements, capacity);
	}
	
	public T get(int index) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		return elements[index];
	}
	
	public int size() {
		return size;
	}
	
	public void sort() {
		for(int i = 1; i < this.size; i++) 
			for(int j = i; j > 0 && (elements[j-1]).compareTo(elements[j]) > 0; j--){
				T temp = elements[j];
				elements[j] = elements[j-1];
				elements[j-1] = temp;
		}
	}
	
	public String toString() {
		return Arrays.toString(elements);
	}
	
	public void sort(Comparator<? super T> comparator) {
		for(int i = 1; i < this.size; i++) 
			for (int j = i; j > 0 && comparator.compare(elements[j - 1], elements[j]) > 0; j--) {
				T temp = elements[j];
				elements[j] = elements[j-1];
				elements[j-1] = temp;
			}
	}
	
	
	public void sortWithoutComparator() {
		for (int i = 1; i < this.size; i++) 
			for(int j = i; j > 0 && elements[j-1].compareTo(elements[j]) > 0; j--) {
				T temp = elements[j];
				elements[j] = elements[j-1];
				elements[j-1] = temp;
			}
		
	}
	//test sort
	public static void main(String[] args) {
		MyArrayList<Integer> myList = new MyArrayList<>();
        
		Random random = new Random();
		for(int i = 0; i < 100; i++) {
			myList.add(random.nextInt(100));
		}
		
		myList.sort(Comparator.naturalOrder());
		for(int i = 0; i < myList.size(); i++) {
			System.out.print(myList.get(i) + " ");
		}
		System.out.println();
	}
	
	
}
