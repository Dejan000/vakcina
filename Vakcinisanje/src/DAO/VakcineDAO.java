package DAO;

import java.util.Collection;

import model.Prijave;
import model.Vakcine;

public interface VakcineDAO {
	
	public Collection <Vakcine> getVakcine() throws Exception;
	
	

}
