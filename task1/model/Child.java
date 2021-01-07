package model;

public class Child {

	private String name;
	private int age;
	private String city;
	
	public Child() {
		name = "Tom";
		age = 7;
		city = "Entenhausen";
	}
	
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
	
	public String outPrint() {
		return "Name: "+name+" | Age: "+age+" | City: "+city+".";
	}

}
