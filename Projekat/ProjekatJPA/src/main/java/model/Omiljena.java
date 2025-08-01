package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the omiljena database table.
 * 
 */
@Entity
@NamedQuery(name="Omiljena.findAll", query="SELECT o FROM Omiljena o")
public class Omiljena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOmiljena;

	//bi-directional many-to-one association to Knjiga
	@ManyToOne
	@JoinColumn(name="idKnjiga")
	private Knjiga knjiga;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idKorisnik")
	private Korisnik korisnik;

	public Omiljena() {
	}

	public int getIdOmiljena() {
		return this.idOmiljena;
	}

	public void setIdOmiljena(int idOmiljena) {
		this.idOmiljena = idOmiljena;
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