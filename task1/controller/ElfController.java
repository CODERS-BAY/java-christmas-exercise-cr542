package controller;

import model.Present;
import model.Sledge;

public class ElfController {
	private boolean loggedSanta = false;
	private boolean loggedChild = false;
	private String usernameLogged = "";
	
	Present[] storage;	// Test purposes
	Sledge s;	// Test purposes
	
	public ElfController() {
		System.out.println("[System] Lade Komponenten ...");
		storage = new Present[3];
		System.out.println("[System] Lager wird initialisiert (3 Speicherplätze)");
		s = new Sledge(3);
		System.out.println("[System] Schlitten initialisiert (3 Cargoplätze)");
		System.out.println("[System] .... bitte warten ....\n");
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
	 * =======================
	 * ======= Session =======
	 * =======================
	 */
	
	public void setLogin(String user) {
		if(user.equalsIgnoreCase("santa")) {
			this.loggedSanta = true;
			this.usernameLogged = "santa";
		} else {
			this.loggedChild = true;
			this.usernameLogged = user;
		}
	}
	
	public void logout() {
		this.loggedChild = false;
		this.loggedSanta = false;
	}
	
	public String getLoggedUser() {
		if(this.loggedSanta == true) {
			return "santa";
		} else if(this.loggedChild == true) {
			return this.usernameLogged;
		} else {
			return "[System] No active login.";
		}
	}

	/*
	 * =======================
	 * == Santa's Functions ==
	 * =======================
	 */
	
	public void showStorage() {

	}
	
	public void showCargoOverview() {
		this.s.showLoadedCargo();
	}
	
	public void printAllChilds() {
		
	}
	
	public void printSledgeStatus() {
		
	}
	
	
}
