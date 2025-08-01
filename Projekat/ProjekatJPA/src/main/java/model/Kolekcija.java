package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the kolekcija database table.
 * 
 */
@Entity
@NamedQuery(name="Kolekcija.findAll", query="SELECT k FROM Kolekcija k")
public class Kolekcija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKolekcija;

	private String nazivKolekcije;

	//bi-directional many-to-one association to Kolekcijakorisnika
	@OneToMany(mappedBy="kolekcija")
	private List<Kolekcijakorisnika> kolekcijakorisnikas;

	public Kolekcija() {
	}

	public int getIdKolekcija() {
		return this.idKolekcija;
	}

	public void setIdKolekcija(int idKolekcija) {
		this.idKolekcija = idKolekcija;
	}

	public String getNazivKolekcije() {
		return this.nazivKolekcije;
	}

	public void setNazivKolekcije(String nazivKolekcije) {
		this.nazivKolekcije = nazivKolekcije;
	}

	public List<Kolekcijakorisnika> getKolekcijakorisnikas() {
		return this.kolekcijakorisnikas;
	}

	public void setKolekcijakorisnikas(List<Kolekcijakorisnika> kolekcijakorisnikas) {
		this.kolekcijakorisnikas = kolekcijakorisnikas;
	}

	public Kolekcijakorisnika addKolekcijakorisnika(Kolekcijakorisnika kolekcijakorisnika) {
		getKolekcijakorisnikas().add(kolekcijakorisnika);
		kolekcijakorisnika.setKolekcija(this);

		return kolekcijakorisnika;
	}

	public Kolekcijakorisnika removeKolekcijakorisnika(Kolekcijakorisnika kolekcijakorisnika) {
		getKolekcijakorisnikas().remove(kolekcijakorisnika);
		kolekcijakorisnika.setKolekcija(null);

		return kolekcijakorisnika;
	}

}