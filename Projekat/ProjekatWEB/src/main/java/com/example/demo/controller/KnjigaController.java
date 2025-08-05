package com.example.demo.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.ConversionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.KnjigaDTO;
import com.example.demo.dto.KnjigaResponseDTO;
import com.example.demo.dto.KolekcijaKorisnikaDTO;
import com.example.demo.dto.OcenaDTO;
import com.example.demo.dto.PisacDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import model.Knjiga;
import model.Kolekcijakorisnika;
import model.Pisac;
import model.Zanr;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("knjigaController")
public class KnjigaController {
	
	@Autowired
	Servis servis;
	
	@PostMapping("saveKnjiga")
	public ResponseEntity<?> saveKnjiga(@RequestBody @Valid KnjigaDTO knjigaDTO,BindingResult br) {
		
		if(br.hasErrors()) {
			List<ObjectError> resultErrors=br.getAllErrors();
			List<String> errors=new ArrayList<>();
			for(ObjectError e:resultErrors) {
				errors.add(e.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(errors);
		}
		
		servis.saveKnjiga(knjigaDTO);
		return ResponseEntity.ok().body("Knjiga uspesno sacuvana!");
	}
	
	@GetMapping("searchKnjiga")
	public List<KnjigaResponseDTO> searchKnjiga(@RequestParam String query){
		
		return servis.searchKnjiga(query);
	} 
	
	@PostMapping("savePisac")
	public ResponseEntity<?> savePisac(@RequestBody @Valid PisacDTO pisacDto,BindingResult br) {
		if(br.hasErrors()) {
			List<ObjectError> resultErrors=br.getAllErrors();
			List<String> errors=new ArrayList<>();
			for(ObjectError e:resultErrors) {
				errors.add(e.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(errors);
		}
		
		servis.savePisac(pisacDto.getIme(), pisacDto.isDomaci());
		return ResponseEntity.ok("Pisac sačuvan uspešno.");
	}
	public ResponseEntity<?> updatePisac(PisacDTO pisacDto,BindingResult br){
		return null;
	}
	
	@GetMapping("searchPisac")
	public List<PisacDTO> searchPisac(@RequestParam String query){
		return servis.searchPisac(query);
	}
	

	@PostMapping("saveZanr")
	public ResponseEntity<?> saveZanr(@RequestBody String nazivZanra) {//moram napraviti proveru za prazan unos
		//in http request body is containg only naziv 
		if(nazivZanra.trim()=="") {
			return ResponseEntity.badRequest().body("Prazno polje!");
		}
		else {
			servis.saveZanr(nazivZanra);
			return ResponseEntity.ok().body("Zanr uspesno sacuvan!");
		}
		
	}
	
	@PostMapping("/oceni")
	public ResponseEntity<?> oceni(@RequestBody @Valid OcenaDTO ocenaDTO, BindingResult br){
		
		if(br.hasErrors()) {
			
			List<ObjectError> resultErrors=br.getAllErrors();
			List<String> errors=new ArrayList<>();
			for(ObjectError e:resultErrors) {
				errors.add(e.getDefaultMessage());
				System.out.println(e);
			}
			System.out.println("Greska unutar /oceni");
			return ResponseEntity.badRequest().body(errors);
		}
		
		servis.saveOcena(ocenaDTO);
		return ResponseEntity.ok("Ocena uspesno uneta");
	}
	
	private int OMILJENA_KOLEKCIJA=2; //Ovo nije dovrseno
	private int PROCITANA_KOLEKCIJA=1;
	
	@PostMapping("/saveOmiljena")
	public ResponseEntity<?> dodajUKolekcijuOmiljena(@RequestBody @Valid KolekcijaKorisnikaDTO kolekcijaDTO,BindingResult br){
		if(br.hasErrors()) {
			
			List<ObjectError> resultErrors=br.getAllErrors();
			List<String> errors=new ArrayList<>();
			for(ObjectError e:resultErrors) {
				errors.add(e.getDefaultMessage());
				System.out.println(e);
			}
			System.out.println("Greska unutar /dodajUkolekcijuOmiljena");
			
			return ResponseEntity.badRequest().body(errors);
		}
		servis.saveKolekcijaKorisnika(kolekcijaDTO,OMILJENA_KOLEKCIJA);
		
		return ResponseEntity.ok("Uspesno dodato u kolekciju");
	}
	@PostMapping("/saveProcitana")
	public ResponseEntity<?> dodajUKolekcijuProcitana(@RequestBody @Valid KolekcijaKorisnikaDTO kolekcijaDTO,BindingResult br){
		if(br.hasErrors()) {
			
			List<ObjectError> resultErrors=br.getAllErrors();
			List<String> errors=new ArrayList<>();
			for(ObjectError e:resultErrors) {
				errors.add(e.getDefaultMessage());
				System.out.println(e);
			}
			System.out.println("Greska unutar /dodajUkolekcijuProcitana");
			
			return ResponseEntity.badRequest().body(errors);
		}
		servis.saveKolekcijaKorisnika(kolekcijaDTO,PROCITANA_KOLEKCIJA);
		
		return ResponseEntity.ok("Uspesno dodato u kolekciju");
	}
	@PostMapping("/removeOmiljena")
	public ResponseEntity<?> obrisiIzKolekcijeOmiljena(@RequestBody @Valid KolekcijaKorisnikaDTO kolekcijaDTO,BindingResult br){
		if(br.hasErrors()) {
			List<ObjectError> resultErrors=br.getAllErrors();
			List<String> errors=new ArrayList<>();
			for(ObjectError e:resultErrors) {
				errors.add(e.getDefaultMessage());
				System.out.println(e);
			}
			System.out.println("Greska unutar /obrisiIzKolekcijeOmiljena   ");
			
			return ResponseEntity.badRequest().body(errors);
		}
		servis.obrisiOmiljenuKnjigu(kolekcijaDTO.getIdKorisnik(),kolekcijaDTO.getIdKnjiga(), OMILJENA_KOLEKCIJA);
		return ResponseEntity.ok("Uspesno obrisano iz kolekcije");
	}
	
	@PostMapping("/removeProcitana")
	public ResponseEntity<?> obrisiIzKolekcijeProcitana(@RequestBody @Valid KolekcijaKorisnikaDTO kolekcijaDTO,BindingResult br){
		if(br.hasErrors()) {
			List<ObjectError> resultErrors=br.getAllErrors();
			List<String> errors=new ArrayList<>();
			for(ObjectError e:resultErrors) {
				errors.add(e.getDefaultMessage());
				System.out.println(e);
			}
			System.out.println("Greska unutar /obrisiIzKolekcijeProcitana");
			
			return ResponseEntity.badRequest().body(errors);
		}
		servis.obrisiOmiljenuKnjigu(kolekcijaDTO.getIdKorisnik(),kolekcijaDTO.getIdKnjiga(), PROCITANA_KOLEKCIJA);
		return ResponseEntity.ok("Uspesno obrisano iz kolekcije");
	}
	
	@GetMapping("pisacIzvestaj")
	public ResponseEntity<?> pisacIzvestaj(@RequestParam Integer idPisac) {//RequestBody je samo za testiranje
		try {
			
			byte[] izvestaj=servis.kreirajIzvestaj(idPisac);
			
        	if (izvestaj == null) { //u slucaju da nema izvodjenja za unete parametre
    		return ResponseEntity.ok("Nema izvodjenja za unete parametre.");
    	}
    	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.setContentDispositionFormData("attachment", "pisacIzvestaj.pdf");
        return ResponseEntity.ok()
            .headers(headers)
            .body(izvestaj);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Greška prilikom generisanja izveštaja.");
		}
	}
	
}
