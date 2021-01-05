package model;

public class Present {

	private String name;
	private double weight;
	private Child child;
	
	public Present() {
		this.name = "Lego";
		this.weight = 2.5;
	}
	
	public Present(String name, double weight, Child child) {
		this.name = name;
		this.weight = weight;
		this.child = child;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Child getChild() {
		return child;
	}

	public String getChildName() {
		return child.getName();
	}
	
	public void setChild(Child child) {
		this.child = child;
	}
	
	public void outPrint() {
		System.out.println("[Storage] Present for: "+this.getChildName()+" | Article: "+this.getName()+" | Weight: "+this.getWeight()+".");
		
	}

}
