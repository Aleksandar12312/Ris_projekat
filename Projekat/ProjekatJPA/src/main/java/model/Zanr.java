package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the zanr database table.
 * 
 */
@Entity
@NamedQuery(name="Zanr.findAll", query="SELECT z FROM Zanr z")
public class Zanr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZanr;
	
	@Column(unique=true)
	private String nazivZanra;

	//bi-directional many-to-one association to Zanrknjige
	@OneToMany(mappedBy="zanr")
	private List<Zanrknjige> zanrknjiges;

	public Zanr() {
	}

	public int getIdZanr() {
		return this.idZanr;
	}

	public void setIdZanr(int idZanr) {
		this.idZanr = idZanr;
	}

	public String getNazivZanra() {
		return this.nazivZanra;
	}

	public void setNazivZanra(String nazivZanra) {
		this.nazivZanra = nazivZanra;
	}

	public List<Zanrknjige> getZanrknjiges() {
		return this.zanrknjiges;
	}

	public void setZanrknjiges(List<Zanrknjige> zanrknjiges) {
		this.zanrknjiges = zanrknjiges;
	}

	public Zanrknjige addZanrknjige(Zanrknjige zanrknjige) {
		getZanrknjiges().add(zanrknjige);
		zanrknjige.setZanr(this);

		return zanrknjige;
	}

	public Zanrknjige removeZanrknjige(Zanrknjige zanrknjige) {
		getZanrknjiges().remove(zanrknjige);
		zanrknjige.setZanr(null);

		return zanrknjige;
	}

}