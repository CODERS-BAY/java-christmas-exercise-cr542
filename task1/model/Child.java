package model;
/**
 * The Child class models a Child object and offers specific methods to work with.
 * @author Christian Reisenauer
 * @version 1.0
 *
 */
public class Child {

	private String name;
	private int age;
	private String city;
	
	/**
	 * Constructor for a new Child object.
	 * @param name The name of the child.
	 * @param age The age of the child.
	 * @param city The city where the child lives.
	 */
	public Child(String name, int age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	/**
	 * Returns a String that describes the Child.
	 * @return String that describes the Child.
	 */
	public String outPrint() {
		return "Name: "+name+" | Age: "+age+" | City: "+city+".";
	}

}
