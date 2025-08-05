package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class KnjigaJasperDTO {
	@NotNull
	@NotBlank
	private String naslov;
	
	@NotNull
	@Min(1)
	private float prosecnaOcena;
	@Min(0)
	private int brojOmiljenih;
	@Min(0)
	private int brojProcitanih;
}
