package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the prijateljstvo database table.
 * 
 */
@Entity
@NamedQuery(name="Prijateljstvo.findAll", query="SELECT p FROM Prijateljstvo p")
public class Prijateljstvo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrijateljstvo;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idPrijateljJedan")
	private Korisnik korisnik1;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idPrijiateljDva")
	private Korisnik korisnik2;

	public Prijateljstvo() {
	}

	public int getIdPrijateljstvo() {
		return this.idPrijateljstvo;
	}

	public void setIdPrijateljstvo(int idPrijateljstvo) {
		this.idPrijateljstvo = idPrijateljstvo;
	}

	public Korisnik getKorisnik1() {
		return this.korisnik1;
	}

	public void setKorisnik1(Korisnik korisnik1) {
		this.korisnik1 = korisnik1;
	}

	public Korisnik getKorisnik2() {
		return this.korisnik2;
	}

	public void setKorisnik2(Korisnik korisnik2) {
		this.korisnik2 = korisnik2;
	}

}