package controller;

import model.Present;
import model.Sledge;

public class ElfController {
	
	public ElfController() {
		System.out.println("[System] Controller geladen.");
	}
	
	/*
	 * Methoden:
	 * - sortieren
	 * 
	 */
	
	public void addPresent(Present[] storage, Present p, int index) {
		storage[index] = p;
	}
	
	public void loadCargo(Present[] storage, Sledge s) {
		System.out.println("[ElfMessage] Die Beladung des Schlittens wurde gestartet.");
		if(storage.length == s.getCargoArea().length) {
			System.arraycopy(storage, 0, s.getCargoArea(), 0, storage.length);
			System.out.println("[ElfMessage] Der Schlitten wurde erfolgreich beladen!\n");
			s.setReady(true);
		} else {
			System.out.println("[ElfMessage] Schlitten wurde nicht beladen - Lager übersteigt Kapazität des Schlittens!\n");
		}
		
	}
	
	public void sort(Present[] storage) {
		// sort the presents
	}
	
	/*
	 * 
	 * sledge should be prepared here
	 */
}
