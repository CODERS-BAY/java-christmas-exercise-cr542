package controller;

import model.Present;
import model.Sledge;

public class ElfUtil {
	
	private Present[] presents = new Present[10];
	private Sledge sledge;
	
	public ElfUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public void storePresent(Present p, int index) {
		presents[index] = p;
	}

	public void prepareSledge(Present[] presents) {
		sledge = new Sledge(presents);
		if(sledge.isReady()) {
			System.out.println("[+] Sledge has been prepared successfully.");
		}
	}
	
	public void sort(Present[] presents) {
		// sort the presents
	}
	
	/*
	 * 
	 * sledge should be prepared here
	 */
}
