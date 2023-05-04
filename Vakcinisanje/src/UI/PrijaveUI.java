package UI;

import java.util.Collection;

import DAO.PrijaveDAO;
import model.Prijave;

public class PrijaveUI {
	
	private static PrijaveDAO prijaveDAO;

	public static void setPrijaveUI(PrijaveDAO prijaveDAO) {

		PrijaveUI.prijaveDAO = prijaveDAO;
	}
	
	
	public static void addPrijava() {
		try {
			prijaveDAO.dodajPrijavu();
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Greska pri dodavanju vakcine");
		}
	}
	public static void prikaziPrijave() {
		try {
			Collection <Prijave> prijave = prijaveDAO.getPrijave();
			for(Prijave p:prijave) {
				System.out.println(p);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Greska pri ucitavanju vakcina");
			
			
		}
	}

}
