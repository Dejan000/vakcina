package UI;

import java.util.Collection;

import DAO.VakcineDAO;
import model.Vakcine;

public class VakcineUI {
	
	
	private static VakcineDAO vakcineDAO;
	
	public static void setVakcineDAO(VakcineDAO v) {
		VakcineUI.vakcineDAO = v;
	}
	
	public static void ucitajVakcine() {
		Collection <Vakcine> vakcine ;
		try {
			vakcine = vakcineDAO.getVakcine();
			for (Vakcine v: vakcine) {
				System.out.println(v);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Greska pri ucitvanju vakcina");
		}
	}

}
