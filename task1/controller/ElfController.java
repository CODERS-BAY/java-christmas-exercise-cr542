package controller;

import model.Child;
import model.Present;
import model.Sledge;
import view.Console;

public class ElfController {
	private boolean loggedSanta = false;
	private boolean loggedChild = false;
	private String usernameLogged = "";
	
	Sledge s = new Sledge(3);
	Present[] storage = new Present[3];
	Child[] childs = new Child[3];
	
	public ElfController() {
		System.out.println("[System] Loading components...");
		System.out.println("[System] Storage is being initialised (3 Slots)");
		System.out.println("[System] Sledge is being initialised (3 Slots)");
		System.out.println("[System] .... please wait ....\n");
		System.out.println("[System] Controller loaded successfully.");
	}
	
	public void addChild(Child c, int index) {
		this.childs[index] = c;
	}
	
	public void addPresent(Present p, int index) {
		this.storage[index] = p;
	}
	
	public void loadCargo() {
		System.out.println("[ElfMessage] Loading procedure started.");
		if(this.storage.length == this.s.getCargoArea().length) {
			System.arraycopy(this.storage, 0, s.getCargoArea(), 0, this.storage.length);
			System.out.println("[ElfMessage] Sledge has been loaded successfully!\n");
			this.s.setReady(true);
		} else {
			System.out.println("[ElfMessage] Sledge could not be loaded - to less space (Storage > Sledge)!\n");
		}
		
	}
	
	public void sort() {
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
		for (int i = 0; i < this.storage.length; i++) {
			this.storage[i].outPrint();
			System.out.println();
		}
		// TODO back to main menu
	}
	
	public void printAllChilds() {
		for (int i = 0; i < childs.length; i++) {
			this.childs[i].outPrint();
			System.out.println();
		}
		// TODO back to main menu
	}
	
	public void printSledgeStatus() {
		if(this.s.isReady()) {
			System.out.println("[Elf] Sledge is ready for takeoff.");
		} else {
			System.out.println("[Elf] Sledge is not ready, please standby.");
			// TODO back to main menu
		}
	}
	
	
}
