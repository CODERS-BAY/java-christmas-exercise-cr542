package model;
import java.util.ArrayList;

public class Sledge {
	
	private boolean isReady = false;
	private ArrayList<Present> cargoArea = new ArrayList<Present>();
	
	public Sledge() {
	}
	
	public void setReady(boolean ready) {
		this.isReady = ready;
	}
	
	public boolean isReady() {
		return isReady;
	}
	
	public void loadPresent(Present p) {
		cargoArea.add(p);
	}
	
	public ArrayList<Present> getCargoArea() {
		return this.cargoArea;
	}
	
	public void showLoadedCargo() {
		for (int i = 0; i < cargoArea.size(); i++) {
			cargoArea.get(i).outPrint();
		}
	}
}
