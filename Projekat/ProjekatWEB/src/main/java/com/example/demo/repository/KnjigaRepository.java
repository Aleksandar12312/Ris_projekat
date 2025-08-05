package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Knjiga;

public interface KnjigaRepository extends JpaRepository<Knjiga, Integer>{
	List<Knjiga> findByNaslovContainingIgnoreCase(String naslov);
	
	@Query("SELECT k FROM Knjiga k WHERE k.pisac.ime=:ime")
	List<Knjiga> findByPisacIme(@Param("ime") String ime);
	
	
	List<Knjiga> findByPisacIdPisac(Integer idPisac);
	
	//List<Knjiga> findByPisacImeContainingIgnoreCase(String ime);
}
