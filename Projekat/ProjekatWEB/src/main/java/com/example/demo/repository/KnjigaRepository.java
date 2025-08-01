package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Knjiga;

public interface KnjigaRepository extends JpaRepository<Knjiga, Integer>{
	List<Knjiga> findByNaslovContainingIgnoreCase(String naslov);
}
