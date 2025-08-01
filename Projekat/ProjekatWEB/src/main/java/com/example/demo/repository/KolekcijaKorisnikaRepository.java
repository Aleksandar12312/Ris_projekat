package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import model.Kolekcijakorisnika;

public interface KolekcijaKorisnikaRepository extends JpaRepository<Kolekcijakorisnika, Integer>{
	@Transactional
    @Modifying
    @Query("DELETE FROM Kolekcijakorisnika kk "
    		+ "WHERE kk.korisnik.idKorisnik = :korisnikId AND kk.knjiga.idKnjiga = :knjigaId AND kk.kolekcija.idKolekcija=:kolekcijaId")
    void deleteByKorisnikIdAndKnjigaId(@Param("korisnikId") int korisnikId, @Param("knjigaId") int knjigaId,@Param("kolekcijaId") int kolekcijaId);
}
