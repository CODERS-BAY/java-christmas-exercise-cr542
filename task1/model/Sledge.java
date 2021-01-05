package model;

public class Sledge {
	
	private boolean isReady = false;
	private Present[] cargoArea;

	public Sledge() {
	}
	
	public Sledge(int capacity) {
		cargoArea = new Present[capacity];
//		System.out.println();
//		System.out.println("[Elf] Schlitten wird aufgebaut ...");
//		System.out.println("[Elf] Füttere die Rentiere ...");
//		System.out.println("[Elf] Noselight = ON ...");
//		System.out.println("[Elf] Schlitten ist einsatzbereit!");
//		System.out.println();
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
