package Knapsack;

import java.util.ArrayList;

public class Knapsack {
	
	 private  ArrayList<Item> items = new ArrayList<Item>();
	 private int capacity;
	 private int totalValue=0;
	 private int totalWeight=0;
	 
	 public Knapsack(ArrayList<Item> items, int capacity) {
		    this.items = items;
		    this.capacity = capacity;
		  }
	
	public  ArrayList<Item> getItems() {
		return items;
	}

	public int getCapacity() {
		return capacity;
	}
	
	public int getTotalValue() {
		return totalValue;
	}

	public int getTotalWeight() {
		return totalWeight;
	}


	
 }
