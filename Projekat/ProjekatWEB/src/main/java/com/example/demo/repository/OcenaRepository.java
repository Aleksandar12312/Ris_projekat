package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import model.Ocena;

public interface OcenaRepository extends JpaRepository<Ocena, Integer>{
	
	Ocena findByKorisnikIdKorisnikAndKnjigaIdKnjiga(int korisnikId, int knjigaId);
	
	@Modifying
	@Transactional
	@Query("UPDATE Ocena o SET o.ocena = :ocena, o.komentar = :komentar WHERE o.korisnik.id = :idKorisnik AND o.knjiga.id = :idKnjiga")
	void updateOcena(@Param("ocena") int ocena,
	                @Param("komentar") String komentar,
	                @Param("idKorisnik") int idKorisnik,
	                @Param("idKnjiga") int idKnjiga);
	
	@Query("SELECT AVG(o.ocena) FROM Ocena o WHERE o.knjiga.id = :idKnjiga")
	float averageOcena(@Param("idKnjiga") int idKnjiga);



}
