package controller;

import java.util.ArrayList;
import java.util.Collections;

import model.Child;
import model.Present;
import model.Sledge;

/**
 * The ElfController class provides the logic for the application and is the interface between model and view.
 * @author Christian Reisenauer
 * @version 1.0
 *
 */
public class ElfController {
	/**
	 * Variables for login operations. 
	 */
	private boolean loggedSanta = false;
	private boolean loggedChild = false;
	private String usernameLogged = "";
	/**
	 * Generates a Sledge object that will be loaded with presents.
	 */
	Sledge s = new Sledge();
	
	/**
	 * Represents the storage where all the presents are stored until the delivery process starts.
	 */
	ArrayList<Present> storage = new ArrayList<Present>();
	/**
	 * The "database" where all the childs and their data are stored.
	 */
	ArrayList<Child> children = new ArrayList<Child>();
	
	public ElfController() {
		System.out.println("[System] Loading components...");
		System.out.println("[System] .... please wait ....\n");
		System.out.println("[System] Controller loaded successfully.");
	}
	
	/**
	 * Adds a child to the child database.
	 * @param c The Child object to be stored.
	 * @since 1.0
	 */
	public void addChild(Child c) {
		try {
			children.add(c);
			System.out.println("[System] Child has been successfully added.");
		} catch(Exception e) {
			System.out.println("[System] Something went wrong adding a child. Please retry");
		}

	}
	
	/**
	 * Adds a present to the present storage.
	 * @param p The Present object to be stored.
	 * @since 1.0
	 */
	public void addPresent(Present p) {
		try {
			storage.add(p);
			System.out.println("[System] Present has been successfully added to storage.");
		} catch(Exception e) {
			System.out.println("[System] Something went wrong adding a present. Please retry");
		}
		
	}
	
	/**
	 * The loadCargo() method initialises the loading procedure.
	 * Presents in storage will be sorted according to their destination and then be loaded into the sledge.
	 * The presents are sorted in the cargo area of the sledge which makes delivery more efficient.
	 * @since 1.0
	 */
	public void loadCargo() {
		if(storage.size() != 0) {
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
			System.out.println("\n[System] Have a good flight, Santa! Logging you out now.\n");

		} else {
			System.out.println("[Elf] Our storage is empty. Nothing to load onto the sledge. Sorry!");
			System.out.println("\n[System] Logging you out now.\n");
		}
	}
	
	/**
	 * Sorting method for the presents in storage.
	 * @since 1.0
	 */
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
	
	/**
	 * Sets the login boolean according to the given username.
	 * Makes it possible to difference between Santa and other users (childs).
	 * @param user The username to check.
	 * @since 1.0
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
	
	/**
	 * Simple logout method for the UI.
	 * @since 1.0
	 */
	public void logout() {
		loggedChild = false;
		loggedSanta = false;
		System.out.println("[System] Session closed.\n");
	}
	
	/**
	 * A method that gets the currently logged user.
	 * @return String with the currently logged username.
	 * @since 1.0
	 */
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
	
	/**
	 * Prints out the content of the storage.
	 * @since 1.0
	 */
	public void showStorage() {
		if(storage.size() != 0) {
			try {
				for (int i = 0; i < storage.size(); i++) {
					System.out.println(storage.get(i).outPrint());
				}
			} catch(Exception e) {
				System.out.println("[System] Error while searching. Please retry.\n");
			}
		} else {
			System.out.println("[System] No presents found in storage. Going back to menu.\n");
		}
	}
	
	/**
	 * Prints out a list of all registered children.
	 * @since 1.0
	 */
	public void printAllChilds() {
		if(children.size() != 0) {
			try {
				for (int i = 0; i < children.size(); i++) {
					System.out.println(children.get(i).outPrint());
				}	
			} catch(Exception e) {
				System.out.println("[System] Error while searching. Please retry.\\n");
			}
		} else {
			System.out.println("[System] No childs found in database. Going back to menu.\n");
		}
	}
	
	/**
	 * Prints out a specific child in the ArrayList according to the given index value.
	 * @param index The index of the specific Child object in the ArrayList children.
	 * @since 1.0
	 */
	public void printChild(int index) {
			System.out.println(children.get(index).outPrint());
	}
	
	/**
	 * Prints out sledge status.
	 * @since 1.0
	 */
	public void printSledgeStatus() {
		if(s.isReady()) {
			System.out.println("[System] Sledge is ready for takeoff.\n");
		} else {
			System.out.println("[System] Sledge is not ready, please standby.\n");
		}
	}
	
	/** 
	 * Simple search algorithm to find a registered child in the child database.
	 * @param name The name of the child to be searched for (no case sensitivity).
	 * @since 1.0
	 */
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
				System.out.println("[System] No child found. Please check spelling of name and retry!\n");
			}
		} catch(Exception e) {
			System.out.println("[System] Error while trying to search child. Going back to menu ....\n");
		}

	}
	
}
