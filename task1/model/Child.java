package model;

public class Child {

	private String name;
	private int age;
	private Present present;
	private String city;
	
	public Child() {
		this.name = "Tom";
		this.age = 7;
		this.present = new Present();
		this.city = "Entenhausen";
	}
	
	public Child(String name, int age, Present present, String city) {
		this.name = name;
		this.age = age;
		this.present = present;
		this.city = city;
	}

}
