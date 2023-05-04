package UI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import model.Izvestaj;

import DAO.IzvestavanjeDAO;
import model.Izvestaj;

public class IzvestavanjeUI {

	private static IzvestavanjeDAO izvestavanjeDAO;
	
	public static void setIzvestavanjeUI(IzvestavanjeDAO I) {
		IzvestavanjeUI.izvestavanjeDAO = I;
	}
	public static void izvestavanje() {
		try {
			Collection <Izvestaj> izvestaj = izvestavanjeDAO.getIzvestaj();
			izvestaj = Izvestaj.IzvestajSort(izvestaj);
			for(Izvestaj iz:izvestaj) {
				System.out.println(iz);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Greska pri dobavljanju izvestaja");
		}
	}
}
