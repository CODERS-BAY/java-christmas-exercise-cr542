package model;

public class Present {

	private String name;
	private double weight;
	private Child child;
	private String deliverTo;
	
	public Present() {
		name = "Lego";
		weight = 2.5;
		child = null;
		deliverTo = "";
	}
	
	public Present(Child c) {
		name = "Lego";
		weight = 2.5;
		child = c;
		deliverTo = "Test";
	}
	
	public Present(String name, double weight, Child child) {
		this.name = name;
		this.weight = weight;
		this.child = child;
		this.deliverTo = child.getCity();
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
	
	public String outPrint() {
		return "[Storage] Present for: "+getChildName()+" | Article: "+getName()+" | Weight: "+getWeight()+".";
		
	}

}
