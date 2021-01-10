package controller;

import java.util.ArrayList;
import java.util.Collections;

import model.Child;
import model.Present;
import model.Sledge;

public class ElfController {
	private boolean loggedSanta = false;
	private boolean loggedChild = false;
	private String usernameLogged = "";
	
	Sledge s = new Sledge();
	
	ArrayList<Present> storage = new ArrayList<Present>();
	ArrayList<Child> children = new ArrayList<Child>();
	
	public ElfController() {
		System.out.println("[System] Loading components...");
		System.out.println("[System] Storage is being initialised (3 Slots)");
		System.out.println("[System] Sledge is being initialised (3 Slots)");
		System.out.println("[System] .... please wait ....\n");
		System.out.println("[System] Controller loaded successfully.");
	}
	
	public void addChild(Child c) {
		try {
			children.add(c);
			System.out.println("[System] Child has been successfully added.");
		} catch(Exception e) {
			System.out.println("[System] Something went wrong adding a child. Please retry");
		}

	}
	
	public void addPresent(Present p) {
		try {
			storage.add(p);
			System.out.println("[System] Present has been successfully added to storage.");
		} catch(Exception e) {
			System.out.println("[System] Something went wrong adding a present. Please retry");
		}
		
	}
	
	public void loadCargo() {
		System.out.println("[Elf] Loading procedure started.");
		System.out.println("[Elf] ... please wait ...");
		sortPresents();
		
		for (int i = 0; i < storage.size(); i++) {
			Present p = storage.get(i);
			s.loadPresent(p);
			System.out.println("[Elf] Present successfully loaded and secured at cargo place: "+i);
		}
		
		System.out.println("[Elf] Loading procedure completed successfully.");
		s.setReady(true);
		System.out.println("[Elf] Displaying loaded cargo below for final approvement:\n");
		
		s.showLoadedCargo();
	}
	
	public void sortPresents() {
		System.out.println("[Elf] We are now sorting the presents in storage for fast delivery ...");
		Collections.sort(storage);
		System.out.println("[Elf] Finished sorting. Presents are now sorted and ready to load on sledge.\n");
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
		System.out.println("[System] Session closed.\n");
	}
	
	public String getLoggedUser() {
		if(loggedSanta == true) {
			return "santa";
		} else if(loggedChild == true) {
			return usernameLogged;
		} else {
			return "[System] No active login.\n";
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
				System.out.println(storage.get(i).outPrint());
			}
		} catch(Exception e) {
			System.out.println("[System] No Presents found in storage. Going back to menu ....\n");
		}

	}
	
	public void printAllChilds() {
		try {
			for (int i = 0; i < children.size(); i++) {
				System.out.println(children.get(i).outPrint());
			}	
		} catch(Exception e) {
			System.out.println("[System] No Childs found in database. Going back to menu ....\n");
		}

	}
	
	public void printChild(int index) {
			System.out.println(children.get(index).outPrint());
	}
	
	public void printSledgeStatus() {
		if(s.isReady()) {
			System.out.println("[System] Sledge is ready for takeoff.\n");
		} else {
			System.out.println("[System] Sledge is not ready, please standby.\n");
		}
	}
	

	public void search(String name) {
		try {
			boolean success = false;
			for (int i = 0; i < children.size(); i++) {
				String cName = children.get(i).getName();
				if(cName.equalsIgnoreCase(name)) {
					success = true;
					System.out.println("[System] Search successful. Displaying details below: ");
					printChild(i);
					System.out.println();
					break;
				}
			}
			if(!success) {
				System.out.println("[System] No child found. Please check spelling of name and retry!");
			}
		} catch(Exception e) {
			System.out.println("[System] Error while trying to search child. Going back to menu ....\n");
		}

	}
	
}
