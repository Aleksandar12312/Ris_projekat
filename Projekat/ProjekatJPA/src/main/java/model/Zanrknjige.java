package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the zanrknjige database table.
 * 
 */
@Entity
@NamedQuery(name="Zanrknjige.findAll", query="SELECT z FROM Zanrknjige z")
public class Zanrknjige implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZanrKnjige;

	//bi-directional many-to-one association to Knjiga
	@ManyToOne
	@JoinColumn(name="idKnjiga")
	private Knjiga knjiga;

	//bi-directional many-to-one association to Zanr
	@ManyToOne
	@JoinColumn(name="idZanr")
	private Zanr zanr;

	public Zanrknjige() {
	}
	public Zanrknjige(Knjiga k,Zanr z) {
		this.knjiga=k;
		this.zanr=z;
	}

	public int getIdZanrKnjige() {
		return this.idZanrKnjige;
	}

	public void setIdZanrKnjige(int idZanrKnjige) {
		this.idZanrKnjige = idZanrKnjige;
	}

	public Knjiga getKnjiga() {
		return this.knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public Zanr getZanr() {
		return this.zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

}