package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import model.Pisac;

public class PisacDTO {
	
	@NotNull
	private Integer id;
	
	@NotNull
	private String ime;
	
	
	private boolean domaci;


	public PisacDTO(Pisac p) {
		this.ime=p.getIme();
		this.domaci=p.getDomaci()==1?true:false;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public boolean isDomaci() {
		return domaci;
	}


	public void setDomaci(boolean domaci) {
		this.domaci = domaci;
	}
	
	
}
