package Knapsack;

import java.util.ArrayList;

public class Main {

	public static ArrayList<Item> items = new ArrayList<Item>();
	 
	public static void main(String[] args) {
		int totalItems;
		int capacity;
		
		do {
		System.out.println("Please enter the bag capacity: ");
		  capacity = StdIn.readInt();
		}while(capacity<=0);
		
		  do {
		  System.out.println("Please enter the number of items (>= 5):");
		  totalItems = StdIn.readInt();
		  }while(totalItems<5);
		  
		  //δημιουργία αντικειμένων με τυχαίες τιμές
			for (int i=1; i<=totalItems; i++) {
				Item item = new Item(StdRandom.uniform(100), StdRandom.uniform(capacity) + 1);
				items.add(item);
			}
			//εκτυπώνει ό,τι έχουμε μέχρι στιγμής
			System.out.println("Bag Capacity: " +capacity);
			System.out.println("Total Items: " +totalItems);	
			
			for(Item item : items)
				System.out.println(item.toString());
			
			
		  Knapsack knapsack = new Knapsack(items, capacity);
		  GRASP grasp = new GRASP(knapsack, totalItems);
		  
		  grasp.solution();
		  grasp.display();
	}
		
		
			
	}

