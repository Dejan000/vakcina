package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Prijave {
	
	private long id;
	private long jmbg;
	private String imePrezime;
	Vakcine vakcina;
	LocalDateTime vremePrijave;
	private String naziv;
	public Prijave(long id, long jmbg, String imePrezime, Vakcine vakcina, LocalDateTime vremePrijave) {
		super();
		this.naziv = null;
		this.id = id;
		this.jmbg = jmbg;
		this.imePrezime = imePrezime;
		this.vakcina = vakcina;
		this.vremePrijave = vremePrijave;
	}
	public Prijave(long id, long jmbg, String imePrezime, String nazivVakcine, LocalDateTime vremePrijave) {
		super();
		this.naziv = nazivVakcine;
		this.id = id;
		this.jmbg = jmbg;
		this.imePrezime = imePrezime;
		this.vakcina = null;
		this.vremePrijave = vremePrijave;
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
		Prijave other = (Prijave) obj;
		return id == other.id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getJmbg() {
		return jmbg;
	}
	public void setJmbg(long jmbg) {
		this.jmbg = jmbg;
	}
	public String getImePrezime() {
		return imePrezime;
	}
	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}
	public Vakcine getVakcina() {
		return vakcina;
	}
	public void setVakcina(Vakcine vakcina) {
		this.vakcina = vakcina;
	}
	public LocalDateTime getVremePrijave() {
		return vremePrijave;
	}
	public void setVremePrijave(LocalDateTime vremePrijave) {
		this.vremePrijave = vremePrijave;
	}
	@Override
	public String toString() {
		return "id=" + id + ", jmbg=" + jmbg + ", imePrezime=" + imePrezime + ", vremePrijave=" + vremePrijave
				+ ", naziv Vakcine=" + naziv + "" +"\n" ;
	}

}
