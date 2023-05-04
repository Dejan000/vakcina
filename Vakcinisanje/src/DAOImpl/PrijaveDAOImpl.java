package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import DAO.PrijaveDAO;
import DAO.VakcineDAO;
import model.Prijave;
import model.Vakcine;
import util.Konzola;

public class PrijaveDAOImpl implements PrijaveDAO {
	
	private Connection conn;
	private VakcineDAO vakcineDAO;
	

	
	public PrijaveDAOImpl(Connection conn, VakcineDAO vakcineDAO) {
		super();
		this.conn = conn;
		this.vakcineDAO = vakcineDAO;
	}
	
	


	public void dodajPrijavu() throws Exception {
		int provera = 0;
		List <String> lista = new ArrayList<String>();
		String sql =  "INSERT INTO prijave(jmbg,imePrezime,vakcina,datum) VALUES(?,?,?,?)";
		String sql2 = "SELECT jmbg FROM prijave ";
		Collection <Vakcine> vakcine = vakcineDAO.getVakcine();
		try(PreparedStatement stmt = conn.prepareStatement(sql2)){
			try(ResultSet rset= stmt.executeQuery()){
				while(rset.next()) {
					long jmbg = rset.getLong(1);
					System.out.println(jmbg);
					lista.add(String.valueOf(jmbg));
				}
			}
		}
		long jmbg = Konzola.ocitajLong("Upisite svoj jmbg");
		
		for(String jmbg2:lista) {
			if(jmbg2.equalsIgnoreCase(String.valueOf(jmbg))) {
				System.out.println("Isti jmbg postoji");
				return;
			}
			
		}
		long idVakcine = Konzola.ocitajLong("Upisite ID vakcine");
		for(Vakcine v:vakcine) {
			if(v.getId() == idVakcine) {
				provera = 1;
			}
		}
		if(provera ==0) {
			System.out.println("Ne postoji ta vakcina!");
			return;
		}
		String imePrezime = Konzola.ocitajString("UPISITE IME I PREZIME");
		
		LocalDateTime datumPrijave = LocalDateTime.now();
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			int kolona = 0;
			stmt.setLong(++kolona, jmbg);
			stmt.setString(++kolona, imePrezime);
			stmt.setLong(++kolona,idVakcine);
			stmt.setTimestamp(++kolona, Timestamp.valueOf(datumPrijave));
			stmt.execute();
		}
				}
		
	@Override	
	public Collection <Prijave> getPrijave()throws Exception{
		Collection <Prijave> prijave = new ArrayList<Prijave>();
		String sql = "SELECT p.id,p.jmbg,p.imePrezime,p.vakcina,p.datum,v.naziv\r\n"
				+ "FROM prijave p JOIN vakcine v on v.id = p.vakcina";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			try(ResultSet rset =stmt.executeQuery()){
				while(rset.next()) {
					int kolona = 0;
					long id = rset.getLong(++kolona);
					long jmbg = rset.getLong(++kolona);
					String imePrezime = rset.getString(++kolona);
					long idVakcine = rset.getLong(++kolona);
					LocalDateTime vremeVakcine = rset.getTimestamp(++kolona).toLocalDateTime();
					String nazivVakcine = rset.getString(++kolona);
					Prijave prijava = new Prijave(id,jmbg,imePrezime,nazivVakcine,vremeVakcine);
					prijave.add(prijava);
				}
			}
		}
		return prijave;
	}




}	
	



