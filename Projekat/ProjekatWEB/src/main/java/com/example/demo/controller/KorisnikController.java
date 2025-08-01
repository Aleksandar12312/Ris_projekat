package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.KorisnikResponseDTO;

import jakarta.servlet.http.HttpServletRequest;
import model.Korisnik;

@RestController
@RequestMapping("korisnikController")
public class KorisnikController {
	@Autowired
	Servis servis;

	@GetMapping("/proba")
	public String proba() {
		
		return "Dobrodosli!";
	}
	
	
	@PostMapping("/register")
	public String register(@RequestBody Korisnik korisnik) {
		
		return servis.saveKorisnik(korisnik);
		
	}
	
	@PostMapping("/login")
	public KorisnikResponseDTO login(@RequestBody Korisnik korisnik) {
		return servis.verify(korisnik);
	}
	@GetMapping("/usernameId")
	public Integer usernameId(@RequestParam("query")String username) {//vraca id korisnika 
		return servis.findId(username);
	}
}
