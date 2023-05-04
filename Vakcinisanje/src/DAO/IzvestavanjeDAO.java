package DAO;

import java.util.Collection;

import model.Izvestaj;

public interface IzvestavanjeDAO {
	
	public Collection <Izvestaj> getIzvestaj()throws Exception; 

}
