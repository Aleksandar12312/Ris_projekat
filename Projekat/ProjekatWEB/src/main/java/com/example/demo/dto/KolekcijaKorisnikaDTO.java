package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class KolekcijaKorisnikaDTO {
	@NotNull
	private Integer idKnjiga;
	@NotNull
	private Integer idKorisnik;
	
	public KolekcijaKorisnikaDTO(@NotNull Integer idKnjiga, @NotNull Integer idKorisnik) {
		super();
		this.idKnjiga = idKnjiga;
		this.idKorisnik = idKorisnik;
		
	}
	public Integer getIdKnjiga() {
		return idKnjiga;
	}
	public void setIdKnjiga(Integer idKnjiga) {
		this.idKnjiga = idKnjiga;
	}
	public Integer getIdKorisnik() {
		return idKorisnik;
	}
	public void setIdKorisnik(Integer idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	
}
