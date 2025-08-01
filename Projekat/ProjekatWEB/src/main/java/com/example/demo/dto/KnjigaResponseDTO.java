package com.example.demo.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import model.Knjiga;


public class KnjigaResponseDTO {
	
	@NotNull
	private Integer idKnjiga;
	
	private String naslov;
	
	private String opis;
	
	private String originalniJezik;
	
	private String pisacIme;
	
	private List<String> zanrovi;
	
	public KnjigaResponseDTO(Knjiga k) {
		this.idKnjiga=k.getIdKnjiga();
		this.naslov=k.getNaslov();
		this.opis=k.getOpis();
		this.originalniJezik=k.getOriginalniJezik();
		this.pisacIme=k.getPisac().getIme();
		this.zanrovi=k.getZanrknjiges().stream().map(zanrknjiga->zanrknjiga.getZanr().getNazivZanra()).toList();
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

	public String getPisacIme() {
		return pisacIme;
	}

	public void setPisacIme(String pisacIme) {
		this.pisacIme = pisacIme;
	}

	public List<String> getZanrovi() {
		return zanrovi;
	}

	public void setZanrovi(List<String> zanrovi) {
		this.zanrovi = zanrovi;
	}
	public Integer getIdKnjiga() {
		return idKnjiga;
	}
	public void setIdKnjiga(Integer idKnjiga) {
		this.idKnjiga = idKnjiga;
	}
	
	
	
}
