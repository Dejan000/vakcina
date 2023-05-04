package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import DAO.IzvestavanjeDAO;
import model.Izvestaj;
import util.Konzola;

public class IzvestavanjeDAOImpl implements IzvestavanjeDAO {
	
	private Connection conn;

	public IzvestavanjeDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Collection<Izvestaj> getIzvestaj() throws Exception {
		LocalDateTime pocetnoVreme = Konzola.ocitajDateTime("Upisite pocetno vreme: ");
		LocalDateTime krajVreme = Konzola.ocitajDateTime("Upisite kraj vremena: ");
		Collection <Izvestaj> izvestaji = new ArrayList<Izvestaj>();
		HashSet <String> imenaVakcina = new HashSet<String>();
		List <String> ponavljanjeVakcina = new ArrayList<String>();
		String sql = "SELECT v.naziv,p.datum\r\n"
				+ "FROM vakcine v\r\n"
				+ "JOIN prijave p ON v.id = p.vakcina ;";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			try(ResultSet rset = stmt.executeQuery()){
				while (rset.next()){
					if (pocetnoVreme.isBefore(rset.getTimestamp(2).toLocalDateTime())) {
						if(rset.getTimestamp(2).toLocalDateTime().isBefore(krajVreme)) {
							ponavljanjeVakcina.add(rset.getString(1));
							
							
						}
						
					}
					
				}	
			}
			for(String vak:ponavljanjeVakcina) {
				imenaVakcina.add(vak);
			}
			for(String vakcina:imenaVakcina) {
				int brojVakcina = 0;
				for(String ponovljene: ponavljanjeVakcina) {
					
					if (vakcina.equalsIgnoreCase(ponovljene)) {
						brojVakcina ++;
					}
					
					
				}
				Izvestaj izvestaj = new Izvestaj(vakcina,brojVakcina);
				izvestaji.add(izvestaj);
				
			}
			
			
		}
		return izvestaji;
	}
	
	

}
