package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;



/**
 * The persistent class for the pisac database table.
 * 
 */
@Entity
@NamedQuery(name="Pisac.findAll", query="SELECT p FROM Pisac p")
public class Pisac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPisac;

	private byte domaci;

	private String ime;

	//bi-directional many-to-one association to Knjiga
	@OneToMany(mappedBy="pisac")
	private List<Knjiga> knjigas;

	public Pisac() {
	}

	public int getIdPisac() {
		return this.idPisac;
	}

	public void setIdPisac(int idPisac) {
		this.idPisac = idPisac;
	}

	public byte getDomaci() {
		return this.domaci;
	}

	public void setDomaci(byte domaci) {
		this.domaci = domaci;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}


	public List<Knjiga> getKnjigas() {
		return this.knjigas;
	}

	public void setKnjigas(List<Knjiga> knjigas) {
		this.knjigas = knjigas;
	}

	public Knjiga addKnjiga(Knjiga knjiga) {
		getKnjigas().add(knjiga);
		knjiga.setPisac(this);

		return knjiga;
	}

	public Knjiga removeKnjiga(Knjiga knjiga) {
		getKnjigas().remove(knjiga);
		knjiga.setPisac(null);

		return knjiga;
	}

}