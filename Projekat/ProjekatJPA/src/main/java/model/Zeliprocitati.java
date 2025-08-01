package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the zeliprocitati database table.
 * 
 */
@Entity
@NamedQuery(name="Zeliprocitati.findAll", query="SELECT z FROM Zeliprocitati z")
public class Zeliprocitati implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZeliProcitati;

	//bi-directional many-to-one association to Knjiga
	@ManyToOne
	@JoinColumn(name="idKnjiga")
	private Knjiga knjiga;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idKorisnik")
	private Korisnik korisnik;

	public Zeliprocitati() {
	}

	public int getIdZeliProcitati() {
		return this.idZeliProcitati;
	}

	public void setIdZeliProcitati(int idZeliProcitati) {
		this.idZeliProcitati = idZeliProcitati;
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