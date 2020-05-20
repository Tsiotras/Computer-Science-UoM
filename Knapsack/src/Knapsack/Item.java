package Knapsack;

public class Item implements Comparable<Item>{
	
	private Integer value;
	private Integer weight;
	
	public Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public int getWeight() {
		return weight;
	}
	
	public double getRatio() {
		return (value/weight);
	}
	
	public String toString() {
	return " Value: " + value + "  Weight: " + weight ;
	}

	@Override
	public int compareTo(Item aItem) {
		return  Double.compare(getRatio(), aItem.getRatio());
	}

}
