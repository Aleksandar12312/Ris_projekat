package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */


@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
	private Uloga uloga;

	private String korisnickoIme;

	private String lozinka;
	
	private String email;
	//bi-directional many-to-one association to Kolekcijakorisnika
	@OneToMany(mappedBy="korisnik")
	private List<Kolekcijakorisnika> kolekcijakorisnikas;

	//bi-directional many-to-one association to Ocena
	@OneToMany(mappedBy="korisnik")
	private List<Ocena> ocenas;

	//bi-directional many-to-one association to Omiljena
	@OneToMany(mappedBy="korisnik")
	private List<Omiljena> omiljenas;

	//bi-directional many-to-one association to Poruka
	@OneToMany(mappedBy="korisnik1")
	private List<Poruka> porukas1;

	//bi-directional many-to-one association to Poruka
	@OneToMany(mappedBy="korisnik2")
	private List<Poruka> porukas2;

	//bi-directional many-to-one association to Prijateljstvo
	@OneToMany(mappedBy="korisnik1")
	private List<Prijateljstvo> prijateljstvos1;

	//bi-directional many-to-one association to Prijateljstvo
	@OneToMany(mappedBy="korisnik2")
	private List<Prijateljstvo> prijateljstvos2;

	//bi-directional many-to-one association to Procitana
	@OneToMany(mappedBy="korisnik")
	private List<Procitana> procitanas;

	//bi-directional many-to-one association to Zeliprocitati
	@OneToMany(mappedBy="korisnik")
	private List<Zeliprocitati> zeliprocitatis;

	public Korisnik() {
	}
	
	

	public Korisnik( String korisnickoIme, String lozinka, String email,Uloga uloga) {
		super();
		this.uloga = uloga;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
	}



	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public String getKorisnickoIme() {
		return this.korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return this.lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public List<Kolekcijakorisnika> getKolekcijakorisnikas() {
		return this.kolekcijakorisnikas;
	}

	public void setKolekcijakorisnikas(List<Kolekcijakorisnika> kolekcijakorisnikas) {
		this.kolekcijakorisnikas = kolekcijakorisnikas;
	}

	public Kolekcijakorisnika addKolekcijakorisnika(Kolekcijakorisnika kolekcijakorisnika) {
		getKolekcijakorisnikas().add(kolekcijakorisnika);
		kolekcijakorisnika.setKorisnik(this);

		return kolekcijakorisnika;
	}

	public Kolekcijakorisnika removeKolekcijakorisnika(Kolekcijakorisnika kolekcijakorisnika) {
		getKolekcijakorisnikas().remove(kolekcijakorisnika);
		kolekcijakorisnika.setKorisnik(null);

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
		ocena.setKorisnik(this);

		return ocena;
	}

	public Ocena removeOcena(Ocena ocena) {
		getOcenas().remove(ocena);
		ocena.setKorisnik(null);

		return ocena;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Omiljena> getOmiljenas() {
		return this.omiljenas;
	}

	public void setOmiljenas(List<Omiljena> omiljenas) {
		this.omiljenas = omiljenas;
	}

	public Omiljena addOmiljena(Omiljena omiljena) {
		getOmiljenas().add(omiljena);
		omiljena.setKorisnik(this);

		return omiljena;
	}

	public Omiljena removeOmiljena(Omiljena omiljena) {
		getOmiljenas().remove(omiljena);
		omiljena.setKorisnik(null);

		return omiljena;
	}

	public List<Poruka> getPorukas1() {
		return this.porukas1;
	}

	public void setPorukas1(List<Poruka> porukas1) {
		this.porukas1 = porukas1;
	}

	public Poruka addPorukas1(Poruka porukas1) {
		getPorukas1().add(porukas1);
		porukas1.setKorisnik1(this);

		return porukas1;
	}

	public Poruka removePorukas1(Poruka porukas1) {
		getPorukas1().remove(porukas1);
		porukas1.setKorisnik1(null);

		return porukas1;
	}

	public List<Poruka> getPorukas2() {
		return this.porukas2;
	}

	public void setPorukas2(List<Poruka> porukas2) {
		this.porukas2 = porukas2;
	}

	public Poruka addPorukas2(Poruka porukas2) {
		getPorukas2().add(porukas2);
		porukas2.setKorisnik2(this);

		return porukas2;
	}

	public Poruka removePorukas2(Poruka porukas2) {
		getPorukas2().remove(porukas2);
		porukas2.setKorisnik2(null);

		return porukas2;
	}

	public List<Prijateljstvo> getPrijateljstvos1() {
		return this.prijateljstvos1;
	}

	public void setPrijateljstvos1(List<Prijateljstvo> prijateljstvos1) {
		this.prijateljstvos1 = prijateljstvos1;
	}

	public Prijateljstvo addPrijateljstvos1(Prijateljstvo prijateljstvos1) {
		getPrijateljstvos1().add(prijateljstvos1);
		prijateljstvos1.setKorisnik1(this);

		return prijateljstvos1;
	}

	public Prijateljstvo removePrijateljstvos1(Prijateljstvo prijateljstvos1) {
		getPrijateljstvos1().remove(prijateljstvos1);
		prijateljstvos1.setKorisnik1(null);

		return prijateljstvos1;
	}

	public List<Prijateljstvo> getPrijateljstvos2() {
		return this.prijateljstvos2;
	}

	public void setPrijateljstvos2(List<Prijateljstvo> prijateljstvos2) {
		this.prijateljstvos2 = prijateljstvos2;
	}

	public Prijateljstvo addPrijateljstvos2(Prijateljstvo prijateljstvos2) {
		getPrijateljstvos2().add(prijateljstvos2);
		prijateljstvos2.setKorisnik2(this);

		return prijateljstvos2;
	}

	public Prijateljstvo removePrijateljstvos2(Prijateljstvo prijateljstvos2) {
		getPrijateljstvos2().remove(prijateljstvos2);
		prijateljstvos2.setKorisnik2(null);

		return prijateljstvos2;
	}

	public List<Procitana> getProcitanas() {
		return this.procitanas;
	}

	public void setProcitanas(List<Procitana> procitanas) {
		this.procitanas = procitanas;
	}

	public Procitana addProcitana(Procitana procitana) {
		getProcitanas().add(procitana);
		procitana.setKorisnik(this);

		return procitana;
	}

	public Procitana removeProcitana(Procitana procitana) {
		getProcitanas().remove(procitana);
		procitana.setKorisnik(null);

		return procitana;
	}

	public List<Zeliprocitati> getZeliprocitatis() {
		return this.zeliprocitatis;
	}

	public void setZeliprocitatis(List<Zeliprocitati> zeliprocitatis) {
		this.zeliprocitatis = zeliprocitatis;
	}

	public Zeliprocitati addZeliprocitati(Zeliprocitati zeliprocitati) {
		getZeliprocitatis().add(zeliprocitati);
		zeliprocitati.setKorisnik(this);

		return zeliprocitati;
	}

	public Zeliprocitati removeZeliprocitati(Zeliprocitati zeliprocitati) {
		getZeliprocitatis().remove(zeliprocitati);
		zeliprocitati.setKorisnik(null);

		return zeliprocitati;
	}
	

}