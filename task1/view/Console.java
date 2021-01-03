package view;

import java.util.Scanner;

import controller.ElfController;

public class Console {

	Scanner userInput = new Scanner(System.in);
	ElfController controller = new ElfController();
	
	public void dialog() {
		System.out.println("Please login:");
		String userName = userInput.nextLine();
		controller.setLogin(userName);
		
		this.displayMenu();
	}
	
	public void displayMenu() {
		String loggedUsr = controller.getLoggedUser();
		if(loggedUsr.equalsIgnoreCase("santa")) {
			this.dialogSanta();
		} else {
			this.dialogChild();
		}
	}
	
	public void dialogSanta() {
		System.out.println("[+] Hi Santa!");
		System.out.println("[+] What do you want to do?");
		System.out.println("[+] 1 = Display all Childs | 2 = Display all presents | 3 = Check sledge status");
	}
	
	public void dialogChild() {
		System.out.println("[*] Hi "+controller.getLoggedUser()+"! This is Santa Clause speaking.");
		System.out.println("[*] Please answer the following questions. This will make it easier for me to bring you a present!");
		System.out.println("[*] What do you want?");
		String presentName = userInput.nextLine();
		System.out.println("[*] What's the weight of your present (just estimate)?");
		double presentWeight = userInput.nextDouble();
		
		// TODO fix Scanner here => Throws exception because of double/String/int
		
		System.out.println("[*] How old are you?");
		userInput.nextLine();
		int childAge = userInput.nextInt();
		System.out.println("[*] Where do you live?");
		String livingPlace = userInput.nextLine();
		
		System.out.println("[*] Received your wish, "+controller.getLoggedUser());
		System.out.println("[*] Present: "+presentName+" | Weight: "+presentWeight+" | Age: "+childAge+" | Town: "+livingPlace);
	}
	
	

}
