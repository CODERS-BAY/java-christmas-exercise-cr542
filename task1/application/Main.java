package application;

import model.Child;
import model.Present;
import view.Console;

public class Main {
	public static void main(String[] args) {
//		new Console().dialog();
		
		Child child1 = new Child();
		Child child2 = new Child("Hansi", 12, present2, "New York");
		Present present1 = new Present("Duplo", 3.4, child1, 1);
		Present present2 = new Present("Playmobil", 2.3, child2, 3); 

	}
}
