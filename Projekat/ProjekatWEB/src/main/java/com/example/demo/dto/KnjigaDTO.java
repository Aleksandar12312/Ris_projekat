package com.example.demo.dto;

import java.time.Year;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import model.Zanr;
import model.Zanrknjige;

public class KnjigaDTO {
	
	@NotNull
	private Integer idKnjiga;
	
	private Integer godinaIzdanja;//moramo napisati coverter iz string u Integer
	
//	@Size(max = 50)
	@NotNull
	private String naslov;
	
	private String opis;
	
	private String originalniJezik;
	
	@NotNull
	private Integer idPisac;
	
	@NotEmpty
	private List<Integer> zanrovi;
	
	public Integer getGodinaIzdanja() {
		return godinaIzdanja;
	}

	public void setGodinaIzdanja(Integer godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getOriginalniJezik() {
		return originalniJezik;
	}

	public void setOriginalniJezik(String originalniJezik) {
		this.originalniJezik = originalniJezik;
	}


	

	public Integer getIdPisac() {
		return idPisac;
	}

	public void setIdPisac(Integer idPisac) {
		this.idPisac = idPisac;
	}

	public List<Integer> getZanrovi() {
		return zanrovi;
	}

	public void setZanrovi(List<Integer> zanrovi) {
		this.zanrovi = zanrovi;
	}
	
	
}
