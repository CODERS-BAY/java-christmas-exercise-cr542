package model;

public class Sledge {
	
	private boolean isReady = false;
	private Present[] cargoArea;

	public Sledge() {
	}
	
	public Sledge(int capacity) {
		cargoArea = new Present[capacity];
	}
	
	public void setReady(boolean ready) {
		this.isReady = ready;
	}
	
	public boolean isReady() {
		return isReady;
	}
	
	public Present[] getCargoArea() {
		return this.cargoArea;
	}
	
	public void showLoadedCargo() {
		for (int i = 0; i < cargoArea.length; i++) {
			cargoArea[i].outPrint();
		}
	}
}
