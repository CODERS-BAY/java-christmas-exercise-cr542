package model;

public class Present {

	private String name;
	private double weight;
	private Child child;
	private int deliveryCode;	// 1 = Entenhausen, 2 = Los Angeles, 3 = NY
	
	public Present() {
		this.name = "Lego";
		this.weight = 2.5;
	}
	
	public Present(String name, double weight, Child child, int deliveryCode) {
		this.name = name;
		this.weight = weight;
		this.child = child;
		this.deliveryCode = deliveryCode;
	}

}
