package model;

import java.util.Collection;
import java.util.Objects;

public class Vakcine {
	
	private long id;
	private String naziv;
	private String tip;
	private int temperatura;
	private Collection <Prijave> prijave;
	
	
	public Vakcine(long id, String naziv, String tip, int temperatura) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.tip = tip;
		this.temperatura = temperatura;
		this.prijave = null;
	}


	@Override
	public String toString() {
		if(this.temperatura > 0) {
			return "Vakcine [id=" + id + ", naziv=" + naziv + ", tip=" + tip + ", temperatura=+" + temperatura + "]";
			
		}else{
		return "Vakcine [id=" + id + ", naziv=" + naziv + ", tip=" + tip + ", temperatura=" + temperatura + "]";}
	}
		


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getTip() {
		return tip;
	}


	public void setTip(String tip) {
		this.tip = tip;
	}


	public int getTemperatura() {
		return temperatura;
	}


	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}


	public Collection<Prijave> getPrijave() {
		return prijave;
	}


	public void setPrijave(Collection<Prijave> prijave) {
		this.prijave = prijave;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vakcine other = (Vakcine) obj;
		return id == other.id;
	}

}
