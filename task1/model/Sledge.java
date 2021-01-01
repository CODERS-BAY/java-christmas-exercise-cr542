package model;
// Sledge = Schlitten
public class Sledge {
	
	private boolean isReady = false;
	
	private Present[] presents;
	
	public Sledge() {
	}
	
	public Sledge(Present[] presents) {
		this.presents = presents;
		this.isReady = true;
	}
	
	public boolean isReady() {
		return isReady;
	}
}
