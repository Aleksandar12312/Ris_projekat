package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the procitana database table.
 * 
 */
@Entity
@NamedQuery(name="Procitana.findAll", query="SELECT p FROM Procitana p")
public class Procitana implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProcitane;

	//bi-directional many-to-one association to Knjiga
	@ManyToOne
	@JoinColumn(name="idKnjiga")
	private Knjiga knjiga;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idKorisnik")
	private Korisnik korisnik;

	public Procitana() {
	}

	public int getIdProcitane() {
		return this.idProcitane;
	}

	public void setIdProcitane(int idProcitane) {
		this.idProcitane = idProcitane;
	}

	public Knjiga getKnjiga() {
		return this.knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}