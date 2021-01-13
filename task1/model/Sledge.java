package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Sledge class models a Sledge object and offers specific methods to work with.
 * @author Christian Reisenauer
 * @version 1.0
 */
public class Sledge {
	
	/**
	 * Boolean variable that represents the status of the sledge.
	 */
	private boolean isReady = false;
	
	/**
	 * This ArrayList represents the cargo area of the sledge. 
	 * I have chosen to implement an ArrayList because it is a big advantage that it's size doesn't need to be assigned in advance.
	 * Also it is very easy to sort the data stored in the ArrayList.
	 */
	private List<Present> cargoArea = new ArrayList<Present>();
	
	/**
	 * Set the status of the sledge to "ready".
	 * @param ready Use "true" if the sledge is ready. Otherwise, use "false". Standard value for isReady is "false".
	 */
	public void setReady(boolean ready) {
		this.isReady = ready;
	}
	
	/**
	 * Gets the sledge readiness status.
	 * @return "True" if the sledge is ready, otherwise it returns "false".
	 */
	public boolean isReady() {
		return isReady;
	}
	
	/**
	 * This method is used for load a Present object into the cargo area of the sledge.
	 * @param p The Present object to be loaded.
	 */
	public void loadPresent(Present p) {
		cargoArea.add(p);
	}
	
	/**
	 * Returns the cargo area as an ArrayList to work with.
	 * @return An ArrayList with all the stored cargo.
	 */
	public List<Present> getCargoArea() {
		return this.cargoArea;
	}
	
	/**
	 * Prints out the whole content of the cargo area.
	 */
	public void showLoadedCargo() {
		for (int i = 0; i < cargoArea.size(); i++) {
			System.out.println(cargoArea.get(i).toStringSledge());
		}
	}
}
