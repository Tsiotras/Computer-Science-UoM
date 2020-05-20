package Knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class GRASP {
	//��� ����� ��� ��� �� ���������� ��� �� ������
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
		
	 	
		//������� ��� �� ����������� ��� ArrayList ��� �� ������� ����������
		for(Item item : this.knapsack.getItems())
		sortedItems.add(item);
	 		
	    
	    
	   while(!sortedItems.isEmpty())
	   {
	    	 Collections.sort(sortedItems);	
	    		   			
	    	
	   	  /*������ �� ������ ����������� ��� 5 ��������. � ����� ����� � ����: �� ������ �������� ��� 5 �����������, 
	   	 ��� ���������� �� ������� ���������� ��� �� ������� �� 5 ��������� �����������. */
	   	  
	  
	  	  
	   		if(sortedItems.size()>5) {
	   			randomIndex = StdRandom.uniform(sortedItems.size()-5, sortedItems.size());
	   		}
	   		else {
	   			randomIndex= StdRandom.uniform(sortedItems.size());
	   		}
	   	//��������� �� 5 ���������� �����������, �� ���� �� ratio  	
	   	//��������� ��� ������ ����������� 

	  
	     randomItem= sortedItems.get(randomIndex);	
		
		//������������ � ������ ���� value , � ������ ���� weight ��� �� valueSolution
	
		//�� ������� ��� arrayList �� ������	
		
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