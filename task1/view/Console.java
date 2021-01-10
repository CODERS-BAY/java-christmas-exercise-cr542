package view;

import java.util.Scanner;

import controller.ElfController;
import model.Child;
import model.Present;

/**
 * The Console is responsible for handling the views for the users.
 * Possible logins:
 * - Child (login with any name)
 * - Santa Clause (login with "santa")
 * 
 * @author Christian Reisenauer
 * @version 1.0
 * 
 */
public class Console {
	
	/**
	 * userInput is a Scanner object that takes the user input from the console.
	 */
	Scanner userInput = new Scanner(System.in);
	
	/**
	 * Loads the controller to have access to specific methods.
	 */
	ElfController controller = new ElfController();
	
	/**
	 * Shows the main application dialog which start with a login.
	 * @since 1.0
	 */
	public void dialog() {
		System.out.println("Please login:");
		String userName = userInput.next();
		controller.setLogin(userName);

		displayMenu();
	}
	
	/**
	 * Refers to the menu depending on which user is logged in.
	 * @since 1.0
	 */
	public void displayMenu() {
		String loggedUsr = controller.getLoggedUser();
		if(loggedUsr.equalsIgnoreCase("santa")) {
			dialogSanta();
		} else {
			dialogChild();
		}
	}
	
	/**
	 * Shows the dialog for the user "Santa Clause" and calls the needed function(s), according to the users choice.
	 * @since 1.0
	 */
	public void dialogSanta() {
		System.out.println("[+] Hi Santa!");
		System.out.println("[+] What do you want to do?");
		System.out.println("[+] 1 = Display all Childs | 2 = Display all presents | 3 = Check sledge status");
		System.out.println("[+] 4 = Search for a child | 5 = Get the sledge ready (auto-logout afterwards!)");
		System.out.println("[+] Press any other key to logout.");
		int choice = userInput.nextInt();
		
		switch (choice) {
		case 1: 
			controller.printAllChilds();
			System.out.println();
			displayMenu();
		case 2: 
			controller.showStorage();
			System.out.println();
			displayMenu();
		case 3:
			controller.printSledgeStatus();
			System.out.println();
			displayMenu();
		case 4:
			System.out.println();
			searchDialog();
		case 5:
			controller.loadCargo();
			controller.printSledgeStatus();
		default:
			controller.logout();
			System.out.println();
			dialog();
		}
	}
	
	/**
	 * Shows the dialog for the user "Child", takes data given by the user and stores it in the system.
	 * @since 1.0
	 */
	public void dialogChild() {
		String childName = controller.getLoggedUser();
		System.out.println("[*] Hi "+childName+"! This is Santa Clause.");
		System.out.println("[*] Please answer the following questions. This will make it easier for me to bring you a present!");
		/*
		 * Child specific questions
		 */
		System.out.println("[*] How old are you?");
		int childAge = Integer.parseInt(userInput.next());
		System.out.println("[*] Where do you live? (Please use one single word, like \"NewYork\", we are working on a patch to fix this issue.");
		String livingPlace = userInput.next();
		/*
		 * Present specific questions
		 */
		System.out.println("[*] What do you want for Christmas? (Please use one single word, like \"HouseRoboter\", we are working on a patch to fix this issue");
		String presentName = userInput.next();
		System.out.println("[*] What's the weight of your present (just estimate)?");
		double presentWeight = Double.parseDouble(userInput.next());
		
		Child child = new Child(childName, childAge, livingPlace);
		controller.addChild(child);
		Present present = new Present(presentName, presentWeight, child);
		controller.addPresent(present);
		
		System.out.println("\n[*] Received your wish, "+childName);
		System.out.println("[*] Present: "+presentName+" | Weight: "+presentWeight+" | Age: "+childAge+" | Town: "+livingPlace);
	
		System.out.println("\n[*] Logging you out now! Thank you for using my brand new software!");
		controller.logout();
		dialog();
	}
	
	/**
	 * Displays the search dialog. Only accessible for the user "Santa Clause".
	 * @since 1.0
	 */
	public void searchDialog() {
		System.out.println("[System] Which child should I search for?\n[System] Please enter the correct name below:");
		String searchName = userInput.next();
		
		controller.search(searchName);
		dialogSanta();
	}
	

}
