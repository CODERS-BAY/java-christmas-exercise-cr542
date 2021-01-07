package controller;

import java.util.ArrayList;

import model.Child;
import model.Present;
import model.Sledge;
import view.Console;

public class ElfController {
	private boolean loggedSanta = false;
	private boolean loggedChild = false;
	private String usernameLogged = "";
	
	Sledge s = new Sledge();
//	Present[] storage = new Present[3];
//	Child[] childs = new Child[3];
	
	ArrayList<Present> storage = new ArrayList<Present>();
	ArrayList<Child> childs = new ArrayList<Child>();
	
	public ElfController() {
		System.out.println("[System] Loading components...");
		System.out.println("[System] Storage is being initialised (3 Slots)");
		System.out.println("[System] Sledge is being initialised (3 Slots)");
		System.out.println("[System] .... please wait ....\n");
		System.out.println("[System] Controller loaded successfully.");
	}
	
//	TODO Overhauling method addChild() => parameter = Child object?
	public void addChild(String name, int age, String city) {
		try {
			Child c = new Child(name, age, city);
			childs.add(c);
			System.out.println("[System] Child has been successfully added.");
		} catch(Exception e) {
			System.out.println("[System] Something went wrong adding a child. Please retry");
		}

	}
	
//	TODO Overhauling method addPresent() => parameter = Present object?
	public void addPresent(String name, double weight, Child child) {
		try {
			Present p = new Present(name, weight, child);
			storage.add(p);
			System.out.println("[System] Present has been successfully added to storage.");
		} catch(Exception e) {
			System.out.println("[System] Something went wrong adding a present. Please retry");
		}
		
	}
	
	public void loadCargo() {
		System.out.println("[Elf] Loading procedure started.");
		System.out.println("[Elf] ... please wait ...");
		
		for (int i = 0; i < storage.size(); i++) {
			Present p = storage.get(i);
			s.loadPresent(p);
			System.out.println("[Elf] Present successfully loaded and secured at cargo place: "+i);
		}
		
		System.out.println("[Elf] Loading procedure completed successfully.");
	}
	
	public void sort() {
		// TODO Sort the presents
	}

	/*
	 * =======================
	 * ======= Session =======
	 * =======================
	 */
	
	public void setLogin(String user) {
		if(user.equalsIgnoreCase("santa")) {
			loggedSanta = true;
			usernameLogged = "santa";
		} else {
			loggedChild = true;
			usernameLogged = user;
		}
	}
	
	public void logout() {
		loggedChild = false;
		loggedSanta = false;
		System.out.println("[System] Session closed.");
	}
	
	public String getLoggedUser() {
		if(loggedSanta == true) {
			return "santa";
		} else if(loggedChild == true) {
			return usernameLogged;
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
		try {
			for (int i = 0; i < storage.size(); i++) {
				storage.get(i).outPrint();
			}
		} catch(NullPointerException e) {
			System.out.println("[System] No Presents found in storage. Going back to menu ....\n");
		}

	}
	
	public void printAllChilds() {
		try {
			for (int i = 0; i < childs.size(); i++) {
				childs.get(i).outPrint();
			}	
		} catch(NullPointerException e) {
			System.out.println("[System] No Childs found. Going back to menu ....\n");
		}

	}
	
	public void printSledgeStatus() {
		if(s.isReady()) {
			System.out.println("[System] Sledge is ready for takeoff.");
		} else {
			System.out.println("[System] Sledge is not ready, please standby.");
		}
	}
	
	
}
