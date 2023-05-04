package util;

import UI.IzvestavanjeUI;
import UI.PrijaveUI;
import UI.VakcineUI;

public class Meni {

	
	public static void MeniInit() {
		int option = -1;
		do {
			System.out.println("0. EXIT");
			System.out.println("1. izvestavanje");
			System.out.println("2. addPrijava");
			System.out.println("3. prikaziPrijave");
			System.out.println("4. ucitajVakcine");
			option = Konzola.ocitajInt("izaberi opciju: ");
			
			switch(option) {
				case 1:IzvestavanjeUI.izvestavanje();
					break;
				case 2:PrijaveUI.addPrijava();
					break;
				case 3:PrijaveUI.prikaziPrijave();
					break;
				case 4: VakcineUI.ucitajVakcine();
					break;
			}
			
		}while(option !=0);
		
		
	}
	
	
}
