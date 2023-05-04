package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import DAO.VakcineDAO;
import model.Prijave;
import model.Vakcine;

public class VakcineDAOImpl implements VakcineDAO {
	
	private Connection conn;

	public VakcineDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Collection<Vakcine> getVakcine() throws Exception {
		Collection <Vakcine> vakcine = new ArrayList<Vakcine>();
		String sql = "SELECT id, naziv,tip,temperaturaCuvanja FROM vakcine";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			try(ResultSet rset = stmt.executeQuery()){
				while(rset.next()) {
					int kolona = 0;
					long id = rset.getLong(++kolona);
					String naziv = rset.getString(++kolona);
					String tip = rset.getString(++kolona);
					int temperaturaCuvanja = rset.getInt(++kolona);
					Vakcine vakcina =  new Vakcine(id,naziv,tip,temperaturaCuvanja);
					vakcine.add(vakcina);
				}
				
			}
		}
		return vakcine;
	}

}
