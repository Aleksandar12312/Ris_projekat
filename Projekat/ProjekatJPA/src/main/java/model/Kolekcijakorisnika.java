package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the kolekcijakorisnika database table.
 * 
 */
@Entity
@NamedQuery(name="Kolekcijakorisnika.findAll", query="SELECT k FROM Kolekcijakorisnika k")
@Table(
	    name = "Kolekcijakorisnika",
	    uniqueConstraints = @UniqueConstraint(columnNames = {"idKnjiga", "idKorisnik"})
	)
public class Kolekcijakorisnika implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKolekcijaKorisnika;

	//bi-directional many-to-one association to Knjiga
	@ManyToOne
	@JoinColumn(name="idKnjiga")
	private Knjiga knjiga;

	//bi-directional many-to-one association to Kolekcija
	@ManyToOne
	@JoinColumn(name="idKolekcija")
	private Kolekcija kolekcija;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idKorisnik")
	private Korisnik korisnik;

	public Kolekcijakorisnika() {
	}
	
	

	public Kolekcijakorisnika(Knjiga knjiga, Kolekcija kolekcija, Korisnik korisnik) {
		super();
		this.knjiga = knjiga;
		this.kolekcija = kolekcija;
		this.korisnik = korisnik;
	}



	public int getIdKolekcijaKorisnika() {
		return this.idKolekcijaKorisnika;
	}

	public void setIdKolekcijaKorisnika(int idKolekcijaKorisnika) {
		this.idKolekcijaKorisnika = idKolekcijaKorisnika;
	}

	public Knjiga getKnjiga() {
		return this.knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public Kolekcija getKolekcija() {
		return this.kolekcija;
	}

	public void setKolekcija(Kolekcija kolekcija) {
		this.kolekcija = kolekcija;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}