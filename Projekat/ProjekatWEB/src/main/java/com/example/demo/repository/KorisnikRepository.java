package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer>{

	Korisnik findByKorisnickoIme(String korisnickoIme);
	
}
