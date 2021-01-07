package view;

import java.util.Scanner;

import controller.ElfController;
import model.Present;
import model.Sledge;

public class Console {
	
	Scanner userInput = new Scanner(System.in);
	ElfController controller = new ElfController();
	
	public void dialog() {
		System.out.println("Please login:");
		String userName = userInput.nextLine();
		controller.setLogin(userName);
		
		displayMenu();
	}
	
	public void displayMenu() {
		String loggedUsr = controller.getLoggedUser();
		if(loggedUsr.equalsIgnoreCase("santa")) {
			dialogSanta();
		} else {
			dialogChild();
		}
	}
	
	public void dialogSanta() {
		System.out.println("[+] Hi Santa!");
		System.out.println("[+] What do you want to do?");
		System.out.println("[+] 1 = Display all Childs | 2 = Display all presents | 3 = Check sledge status");
		System.out.println("[+] Press any other key to logout.");
		int choice = userInput.nextInt();
		
		switch (choice) {
		case 1: 
			controller.printAllChilds();
			displayMenu();
		case 2: 
			controller.showStorage();
			displayMenu();
		case 3:
			controller.printSledgeStatus();
			displayMenu();
		default:
			controller.logout();
			dialog();
		}
	}
	
	public void dialogChild() {
		System.out.println("Adding a child for test purposes:\n");
		
		controller.addChild("Test", 12, "Teststadt");
		
		System.out.println();
		
		controller.printAllChilds();
		dialog();
	}
	
	public void dialogChildWIP() {
		System.out.println("[*] Hi "+controller.getLoggedUser()+"! This is Santa Clause.");
		System.out.println("[*] Please answer the following questions. This will make it easier for me to bring you a present!");
		/*
		 * Child specific questions
		 */
		String childName = controller.getLoggedUser();
		System.out.println("[*] How old are you");
		int childAge = userInput.nextInt();
		System.out.println("[*] Where do you live?");
		String livingPlace = userInput.nextLine();
		/*
		 * Present specific questions
		 */
		System.out.println("[*] What do you want for Christmas?");
		String presentName = userInput.nextLine();
		System.out.println("[*] What's the weight of your present (just estimate)?");
		double presentWeight = userInput.nextDouble();
		
//		TODO Fix Scanner => Throws exception because of double/String/int
		

//		TODO Create object => Child
		controller.addChild(childName, childAge, livingPlace);
//		TODO Create object => Present
//		controller.addPresent(presentName, presentWeight, ???);
		
		System.out.println("[*] Received your wish, "+childName);
		System.out.println("[*] Present: "+presentName+" | Weight: "+presentWeight+" | Age: "+childAge+" | Town: "+livingPlace);
	
		System.out.println("[*] Logging you out now! Thank you for using my brand new software!");
		controller.logout();
		dialog();
	}
	
	

}
