package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import model.Uloga;

public class KorisnikResponseDTO {
	
	@NotNull
	private String token;
	
	@NotNull
	private Uloga uloga;
//	@NotNull
//	private String korisnickoIme;
	@NotNull
	private int idKorisnik;
	private String email;
	
	
	
	public KorisnikResponseDTO(String token, Uloga uloga, int idKorisnik, String email) {
		super();
		this.token = token;
		this.uloga = uloga;
//		this.korisnickoIme = korisnickoIme;
		this.idKorisnik = idKorisnik;
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Uloga getUloga() {
		return uloga;
	}
	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
//	public String getKorisnickoIme() {
//		return korisnickoIme;
//	}
//	public void setKorisnickoIme(String korisnickoIme) {
//		this.korisnickoIme = korisnickoIme;
//	}
	public int getIdKorisnik() {
		return idKorisnik;
	}
	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
