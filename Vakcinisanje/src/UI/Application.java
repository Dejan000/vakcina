package UI;

import java.sql.Connection;
import util.Meni;
import java.sql.DriverManager;

import DAO.IzvestavanjeDAO;
import DAO.PrijaveDAO;
import DAO.VakcineDAO;
import DAOImpl.IzvestavanjeDAOImpl;
import DAOImpl.PrijaveDAOImpl;
import DAOImpl.VakcineDAOImpl;
import UI.VakcineUI;

public class Application {
	
	private static void initDatabase() throws Exception {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/vakcinisanje?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Europe/Belgrade", 
				"root", 
				"root");
		VakcineDAO vakcineDAO = new VakcineDAOImpl(conn);
		VakcineUI.setVakcineDAO(vakcineDAO);
		PrijaveDAO prijaveDAO = new PrijaveDAOImpl(conn, vakcineDAO);
		PrijaveUI.setPrijaveUI(prijaveDAO);
		IzvestavanjeDAO izvestavanjeDAO = new IzvestavanjeDAOImpl(conn);
		IzvestavanjeUI.setIzvestavanjeUI(izvestavanjeDAO);
		
		}
	
	static {
		try {
			initDatabase();
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Greska pri ucitavanju baze");
			System.exit(1);
		}
	}

	public static void main(String[] args) throws Exception {
		
		//VakcineUI.ucitajVakcine();
		//PrijaveUI.addVakcina();
		//PrijaveUI.addVakcina();
		//PrijaveUI.addVakcina();
		//PrijaveUI.addVakcina();
		//PrijaveUI.prikaziVakcine();
		//IzvestavanjeUI.izvestavanje();
		Meni.MeniInit();

	}

}
