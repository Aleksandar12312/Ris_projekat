package com.example.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OcenaDTO {
	@NotNull
	@Max(5)
	@Min(1)
	private Integer ocena;
	
	
	private String komentar;
	
	@NotNull
	private Integer knjigaId;
	
	@NotNull
	private Integer korisnikId;
	

	public Integer getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public Integer getKnjigaId() {
		return knjigaId;
	}

	public void setKnjigaId(int knjigaId) {
		this.knjigaId = knjigaId;
	}

	public Integer getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(int korisnikId) {
		this.korisnikId = korisnikId;
	}
	
	
}
