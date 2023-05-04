package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class Izvestaj {
	
	private String nazivVakcine;
	private int brojPrijava;
	//LocalDateTime datumPoslednjePrijave;
	public String getNazivVakcine() {
		return nazivVakcine;
	}
	public void setNazivVakcine(String nazivVakcine) {
		this.nazivVakcine = nazivVakcine;
	}
	public int getBrojPrijava() {
		return brojPrijava;
	}
	public void setBrojPrijava(int brojPrijava) {
		this.brojPrijava = brojPrijava;
	}
	@Override
	public String toString() {
		return "Izvestaj [nazivVakcine=" + nazivVakcine + ", brojPrijava=" + brojPrijava + "]" ;
	}
	public Izvestaj(String nazivVakcine, int brojPrijava) {
		super();
		this.nazivVakcine = nazivVakcine;
		this.brojPrijava = brojPrijava;
	}
	public static Collection<Izvestaj> IzvestajSort(Collection <Izvestaj> i) {
		Collection <Izvestaj> sortiraneIzjave = new ArrayList<Izvestaj>();
		Collection <Izvestaj> kopi = i;
		int max = -1;
		
		
		
		while(sortiraneIzjave.size() != i.size()) {
			//System.out.println(sortiraneIzjave.size());
			//System.out.println("Usli");
			
			for(Izvestaj iz:kopi) {
				//System.out.println("Usli2");
				//System.out.println(iz.brojPrijava);
				
			if(iz.getBrojPrijava()>max) {
				max = iz.getBrojPrijava();
				//System.out.println("Max u loopu:");
				//System.out.println(max);
			}
			
				}
			for(Izvestaj iz:kopi) {
				//System.out.println(iz.getBrojPrijava());
				//System.out.println(max);
				
				if(iz.getBrojPrijava()==max) {
					Izvestaj izve = new Izvestaj(iz.getNazivVakcine(),iz.getBrojPrijava());
					izve.setBrojPrijava(iz.getBrojPrijava());
					sortiraneIzjave.add(izve);
					
					iz.setBrojPrijava(-10);
					
					
					
				}
				
			}
			max = -1;
			
			}
		
		
		return sortiraneIzjave;
		
	}
	
	
}
