package Knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class GRASP {
	//εδώ είναι όλα μας οι μεταβλητές και οι λίστες
	private Knapsack knapsack;
	private int totalItems;
	private int value;
	private ArrayList<Item> sortedItems = new ArrayList<>();
	private Item randomItem;
	private ArrayList<Item> itemsSolution = new ArrayList<>();
	private int valueSolution = 0;
	int currentWeight=0;
	int currentValue=0;

	
	public GRASP(Knapsack knapsack, int totalItems)
	{
		this.knapsack = knapsack;
		this.totalItems = totalItems;
	}
	
	
	public Knapsack getKnapsack() {
		return knapsack;
	}

	public int getValue() {
		return value;
	}
	
	
	public ArrayList<Item> getItemsSolution() {
		return itemsSolution;
	}


	public int getValueSolution() {
		return valueSolution;
	}


	public void solution() {
		
		int capacity = this.knapsack.getCapacity();
		int randomIndex;
		
	 	
		//βάζουμε όλα τα αντικέιμενα στο ArrayList για να κάνουμε ταξινόμηση
		for(Item item : this.knapsack.getItems())
		sortedItems.add(item);
	 		
	    
	    
	   while(!sortedItems.isEmpty())
	   {
	    	 Collections.sort(sortedItems);	
	    		   			
	    	
	   	  /*ελέγχω αν έχουμε περισσότερα από 5 στοιχεία. Ο λόγος είναι ο εξής: αν έχουμε λιγότερα από 5 αντικέιμενα, 
	   	 δεν χρειάζεται να βάλουμε περιορισμό για να πάρουμε τα 5 τελευταία αντικείμενα. */
	   	  
	  
	  	  
	   		if(sortedItems.size()>5) {
	   			randomIndex = StdRandom.uniform(sortedItems.size()-5, sortedItems.size());
	   		}
	   		else {
	   			randomIndex= StdRandom.uniform(sortedItems.size());
	   		}
	   	//παίρνουμε τα 5 μεγαλύτερα αντικείμενα, με βάση το ratio  	
	   	//παίρνουμε ένα τυχαίο αντικείμενο 

	  
	     randomItem= sortedItems.get(randomIndex);	
		
		//υπολογίζεται η τωρινή τιμή value , η τωρινή τιμή weight και το valueSolution
	
		//το βάζουμε στο arrayList το τελικό	
		
		itemsSolution.add(randomItem);
		sortedItems.remove(randomItem);
		currentValue += randomItem.getValue();
		currentWeight +=randomItem.getWeight();
		valueSolution = currentValue;	
			
			Collections.sort(sortedItems);
	
			ListIterator<Item> iter = sortedItems.listIterator();
			while(iter.hasNext()) {
				if(iter.next().getWeight() > capacity - currentWeight) {
					iter.remove();
				}
			}
	   }
	}
	
	
			   
	public void display() {
			
			System.out.println("\nGRASP solution by best ratio (value/weight)");
			System.out.println("Value: " + valueSolution);
			System.out.println("Weight: " + currentWeight);
			System.out.println("Items to pick :");
			
			for (Item item : itemsSolution) {
				System.out.println("-" + item.toString());
			} 
			
		
	}
}