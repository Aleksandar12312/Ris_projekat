package model;

import java.io.Serializable;
import java.time.Year;

import jakarta.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;




/**
 * The persistent class for the knjiga database table.
 * 
 */
@Entity
@NamedQuery(name="Knjiga.findAll", query="SELECT k FROM Knjiga k")
public class Knjiga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKnjiga;

	
	private Integer godinaIzdanja;

	
	private String naslov;

	private String opis;

	private String originalniJezik;

	//bi-directional many-to-one association to Pisac
	@ManyToOne
	@JoinColumn(name="idPisac")
	private Pisac pisac;

	//bi-directional many-to-one association to Kolekcijakorisnika
	@OneToMany(mappedBy="knjiga")
	private List<Kolekcijakorisnika> kolekcijakorisnikas;

	//bi-directional many-to-one association to Ocena
	@OneToMany(mappedBy="knjiga")
	private List<Ocena> ocenas;

	//bi-directional many-to-one association to Omiljena
	@OneToMany(mappedBy="knjiga")
	private List<Omiljena> omiljenas;

	//bi-directional many-to-one association to Procitana
	@OneToMany(mappedBy="knjiga")
	private List<Procitana> procitanas;

	//bi-directional many-to-one association to Zanrknjige
	@OneToMany(mappedBy="knjiga")
	private List<Zanrknjige> zanrknjiges;

	//bi-directional many-to-one association to Zeliprocitati
	@OneToMany(mappedBy="knjiga")
	private List<Zeliprocitati> zeliprocitatis;

	public Knjiga() {
		this.zanrknjiges=new LinkedList<Zanrknjige>();//Moram inicijalizovati svaku kolekciju
	}

	public int getIdKnjiga() {
		return this.idKnjiga;
	}

	public void setIdKnjiga(int idKnjiga) {
		this.idKnjiga = idKnjiga;
	}

	public Integer getGodinaIzdanja() {
		return this.godinaIzdanja;
	}

	public void setGodinaIzdanja(Integer godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getOriginalniJezik() {
		return this.originalniJezik;
	}

	public void setOriginalniJezik(String originalniJezik) {
		this.originalniJezik = originalniJezik;
	}

	public Pisac getPisac() {
		return this.pisac;
	}

	public void setPisac(Pisac pisac) {
		this.pisac = pisac;
	}

	public List<Kolekcijakorisnika> getKolekcijakorisnikas() {
		return this.kolekcijakorisnikas;
	}

	public void setKolekcijakorisnikas(List<Kolekcijakorisnika> kolekcijakorisnikas) {
		this.kolekcijakorisnikas = kolekcijakorisnikas;
	}

	public Kolekcijakorisnika addKolekcijakorisnika(Kolekcijakorisnika kolekcijakorisnika) {
		getKolekcijakorisnikas().add(kolekcijakorisnika);
		kolekcijakorisnika.setKnjiga(this);

		return kolekcijakorisnika;
	}

	public Kolekcijakorisnika removeKolekcijakorisnika(Kolekcijakorisnika kolekcijakorisnika) {
		getKolekcijakorisnikas().remove(kolekcijakorisnika);
		kolekcijakorisnika.setKnjiga(null);

		return kolekcijakorisnika;
	}

	public List<Ocena> getOcenas() {
		return this.ocenas;
	}

	public void setOcenas(List<Ocena> ocenas) {
		this.ocenas = ocenas;
	}

	public Ocena addOcena(Ocena ocena) {
		getOcenas().add(ocena);
		ocena.setKnjiga(this);

		return ocena;
	}

	public Ocena removeOcena(Ocena ocena) {
		getOcenas().remove(ocena);
		ocena.setKnjiga(null);

		return ocena;
	}

	public List<Omiljena> getOmiljenas() {
		return this.omiljenas;
	}

	public void setOmiljenas(List<Omiljena> omiljenas) {
		this.omiljenas = omiljenas;
	}

	public Omiljena addOmiljena(Omiljena omiljena) {
		getOmiljenas().add(omiljena);
		omiljena.setKnjiga(this);

		return omiljena;
	}

	public Omiljena removeOmiljena(Omiljena omiljena) {
		getOmiljenas().remove(omiljena);
		omiljena.setKnjiga(null);

		return omiljena;
	}

	public List<Procitana> getProcitanas() {
		return this.procitanas;
	}

	public void setProcitanas(List<Procitana> procitanas) {
		this.procitanas = procitanas;
	}

	public Procitana addProcitana(Procitana procitana) {
		getProcitanas().add(procitana);
		procitana.setKnjiga(this);

		return procitana;
	}

	public Procitana removeProcitana(Procitana procitana) {
		getProcitanas().remove(procitana);
		procitana.setKnjiga(null);

		return procitana;
	}

	public List<Zanrknjige> getZanrknjiges() {
		return this.zanrknjiges;
	}

	public void setZanrknjiges(List<Zanrknjige> zanrknjiges) {
		this.zanrknjiges = zanrknjiges;
	}

	public Zanrknjige addZanrknjige(Zanrknjige zanrknjige) {
		this.getZanrknjiges().add(zanrknjige);
		zanrknjige.setKnjiga(this);

		return zanrknjige;
	}

	public Zanrknjige removeZanrknjige(Zanrknjige zanrknjige) {
		getZanrknjiges().remove(zanrknjige);
		zanrknjige.setKnjiga(null);

		return zanrknjige;
	}

	public List<Zeliprocitati> getZeliprocitatis() {
		return this.zeliprocitatis;
	}

	public void setZeliprocitatis(List<Zeliprocitati> zeliprocitatis) {
		this.zeliprocitatis = zeliprocitatis;
	}

	public Zeliprocitati addZeliprocitati(Zeliprocitati zeliprocitati) {
		getZeliprocitatis().add(zeliprocitati);
		zeliprocitati.setKnjiga(this);

		return zeliprocitati;
	}

	public Zeliprocitati removeZeliprocitati(Zeliprocitati zeliprocitati) {
		getZeliprocitatis().remove(zeliprocitati);
		zeliprocitati.setKnjiga(null);

		return zeliprocitati;
	}

}