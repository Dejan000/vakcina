package DAO;

import java.sql.Connection;
import java.util.Collection;

import model.Prijave;
import model.Vakcine;

public interface PrijaveDAO {
	
	
	
	public void dodajPrijavu()throws Exception;
	public Collection<Prijave> getPrijave() throws Exception;
	
	
	

}
