package Knapsack;


public class Knapsack {
		
	public static void main(String[] args) {
		
	  System.out.println("Please enter the bag capacity: ");
	  int capacity = StdIn.readInt();
	  System.out.println("Please enter the number of items: ");
	  int totalItems = StdIn.readInt();
		
		int[] value = new int[totalItems+1];
		int[] weight = new int[totalItems+1];
		
		for (int i=1; i<=totalItems; i++) {
			value[i] = StdRandom.uniform(100);
			weight[i] = StdRandom.uniform(capacity) + 1;
		}
		
		System.out.println("Bag Capacity: " +capacity);
		System.out.println("Total Items: " +totalItems);	
	    System.out.println("Weight    Value ");
	    for(int i=1; i<=totalItems; i++) {
	    	System.out.println(+i+ ")" +weight[i]+ "        " +value[i]);	
	    }	    	  
    }
}