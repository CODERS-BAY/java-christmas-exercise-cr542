package model;
/**
 * The Present class models a Present object and offers specific methods to work with.
 * Implements Interface "Comparable" which makes it possible to sort the presents according to their destination.
 * @author Christian Reisenauer
 * @version 1.0
 *
 */
public class Present implements Comparable<Present> {

	private String name;
	private double weight;
	private Child child;
	private String destination;
	
	/**
	 * Constructor for a Present object.
	 * @param name The name of the present.
	 * @param weight The (approximate) weight of the present.
	 * @param child The reference to the Child object that gets the present.
	 */
	public Present(String name, double weight, Child child) {
		this.name = name;
		this.weight = weight;
		this.child = child;
		this.destination = child.getCity();
	}
	
	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public Child getChild() {
		return child;
	}

	public String getChildName() {
		return child.getName();
	}
	
	public String getDestination() {
		return destination;
	}
	
	/**
	 * Returns a String that describes the present.
	 * @since 1.0
	 * @return String that describes the present.
	 */
	public String outPrint() {
		return "[Storage] Present for: "+getChildName()+" | Article: "+getName()+" | Weight: "+getWeight()+" | Destination: "+getDestination();	
	}
	
	/**
	 * Returns a String that describes the present already loaded on the sledge.
	 * @since 1.0
	 * @return String that describes the present already loaded on the sledge.
	 */
	public String outPrintSledge() {
		return "[Sledge] DESTINATION: "+getDestination()+" || Present for: "+getChildName()+" | Article: "+getName()+" | Weight: "+getWeight();
	}

	@Override
	/**
	 * Implementing compareTo() method for the Interface "Compareable" which makes it possible to sort the presents.
	 * @since 1.0
	 */
	public int compareTo(Present p) {
		return this.destination.compareTo(p.getDestination());
	}

}
