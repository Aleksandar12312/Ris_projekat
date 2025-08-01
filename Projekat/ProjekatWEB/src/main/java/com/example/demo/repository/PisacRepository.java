package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Pisac;
import java.util.List;


public interface PisacRepository extends JpaRepository<Pisac, Integer>{
	List<Pisac> findByImeContainingIgnoreCase(String ime);
}
