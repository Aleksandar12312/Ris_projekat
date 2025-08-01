package com.example.demo.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.KnjigaDTO;
import com.example.demo.dto.KnjigaResponseDTO;
import com.example.demo.dto.KolekcijaKorisnikaDTO;
import com.example.demo.dto.KorisnikResponseDTO;
import com.example.demo.dto.OcenaDTO;
import com.example.demo.dto.PisacDTO;
import com.example.demo.repository.KnjigaRepository;
import com.example.demo.repository.KolekcijaKorisnikaRepository;
import com.example.demo.repository.KolekcijaRepository;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.OcenaRepository;
import com.example.demo.repository.PisacRepository;
import com.example.demo.repository.ZanrRepository;
import com.example.demo.security.JwtService;

import io.jsonwebtoken.security.InvalidKeyException;
import jakarta.validation.Valid;
import model.Knjiga;
import model.Kolekcija;
import model.Kolekcijakorisnika;
import model.Korisnik;
import model.Ocena;
import model.Pisac;
import model.Uloga;
import model.Zanr;
import model.Zanrknjige;
@Service
public class Servis {
	
	@Autowired
	KnjigaRepository kr;
	
	@Autowired
	ZanrRepository zr;
	
	@Autowired
	PisacRepository pr;
	
	@Autowired
	KorisnikRepository korr;
	
	@Autowired
	OcenaRepository or;
	
	@Autowired
	KolekcijaKorisnikaRepository kkr;
	
	@Autowired
	KolekcijaRepository kolekcijar;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JwtService jwtService;
	
	//save
	public boolean saveKnjiga(KnjigaDTO kd) {
		
		Knjiga k=new Knjiga();
		k.setGodinaIzdanja(kd.getGodinaIzdanja());
		k.setNaslov(kd.getNaslov());
		k.setOpis(kd.getOpis());
		k.setOriginalniJezik(kd.getOriginalniJezik());
		k.setPisac(pr.findById(kd.getIdPisac()).get()); 
		List<Zanr> listaZanrova=new LinkedList<Zanr>();
		
		for(Integer id:kd.getZanrovi()) {//dodavanje Zanrknjige u knjigu
			listaZanrova.add(zr.findById(id).get());
		}
		for(Zanr z:listaZanrova) {
			Zanrknjige zk=new Zanrknjige(k,z);
			k.addZanrknjige(zk);
			z.addZanrknjige(zk);
		}
		try {
			kr.save(k);
			return true;
			}
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}

	
	public boolean savePisac(String imePisca,boolean domaci) {
		if(imePisca==null || imePisca.trim().isEmpty()) {
			imePisca="unknown";
		}
		Pisac p=new Pisac();
		
		byte b=0;//u bazi podataka boolean se cuva sa byte
		if(domaci)
			b=1;
		
		p.setDomaci(b);
		p.setIme(imePisca);
		try {
		pr.save(p);
		return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	public boolean saveZanr(String naziv) {
		try {
			Zanr z=new Zanr();
			z.setNazivZanra(naziv);
			
			return zr.save(z)!=null?true:false;//save vraca ili exception ili taj objekat
			
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public void saveOcena(OcenaDTO ocenaDTO) {
		try {
			
			Ocena o=new Ocena();
			o.setOcena(ocenaDTO.getOcena());
			o.setKomentar(ocenaDTO.getKomentar());
			o.setKorisnik(korr.findById(ocenaDTO.getKorisnikId()).get());
			o.setKnjiga(kr.findById(ocenaDTO.getKnjigaId()).get());
			if(or.findByKorisnikIdKorisnikAndKnjigaIdKnjiga(ocenaDTO.getKorisnikId(), ocenaDTO.getKnjigaId())!=null) {
				or.updateOcena(ocenaDTO.getOcena(), ocenaDTO.getKomentar(), ocenaDTO.getKorisnikId(), ocenaDTO.getKnjigaId());
			}
			else {
				or.save(o);
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	//save
	
	public List<KnjigaResponseDTO> searchKnjiga(String searchTitle){
		List<KnjigaResponseDTO> responseKnjige = new ArrayList<>();
		for(Knjiga k: kr.findByNaslovContainingIgnoreCase(searchTitle)) {
			responseKnjige.add(new KnjigaResponseDTO(k));
		}
		return responseKnjige;
	}
	
	public List<PisacDTO> searchPisac(String searchName){
		
		List<PisacDTO> pisciDTO=new ArrayList<>();
		for(Pisac p:pr.findByImeContainingIgnoreCase(searchName)) {
			pisciDTO.add(new PisacDTO(p));
		}
		return pisciDTO;
	}

	
	public List<Zanr> getZanrovi(){
		return zr.findAll();
	}
	public List<Pisac> getPisci(){
		return pr.findAll();
	}
	public List<Knjiga> getKnjige(){
		return kr.findAll();
	}
	
	
	
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);
	
	public boolean saveKorisnik(String naziv,String sifra,String email,Uloga uloga) {
		try {
			String sifraEncoded=encoder.encode(sifra);
			Korisnik k=new Korisnik(naziv,sifraEncoded,email,uloga);
			korr.save(k);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public String saveKorisnik(Korisnik k) {
		try {
			k.setLozinka(encoder.encode(k.getLozinka()));
			korr.save(k);
			
			return jwtService.generateToken(k.getKorisnickoIme());
		}
		catch(Exception e) {
			return "Neuspesna registracija";
		}
	}
	
	public void saveKolekcijaKorisnika(@Valid KolekcijaKorisnikaDTO kolekcijaDTO,int idKolekcija) {
		Optional<Knjiga> knjiga=kr.findById(kolekcijaDTO.getIdKnjiga());
		Optional<Korisnik> korisnik=korr.findById(kolekcijaDTO.getIdKorisnik());
		Optional<Kolekcija> kolekcija=kolekcijar.findById(idKolekcija);
		if(knjiga.get()!=null&&korisnik.get()!=null) {
			Kolekcijakorisnika kol=new Kolekcijakorisnika(knjiga.get(), kolekcija.get(), korisnik.get());
			kkr.save(kol);
		}
		
	}

	
	public KorisnikResponseDTO verify(Korisnik k) {
	    
		Authentication authentication = authManager.authenticate(
		        new UsernamePasswordAuthenticationToken(k.getKorisnickoIme(), k.getLozinka())
		    );
		if(authentication.isAuthenticated()) {
			try {	
				System.out.println("Uspesno smo se logovali!");
				String jwtToken=jwtService.generateToken(k.getKorisnickoIme());
				
				Korisnik korisnik=korr.findByKorisnickoIme(k.getKorisnickoIme());
				
				return new KorisnikResponseDTO(jwtToken, korisnik.getUloga(), korisnik.getIdKorisnik(), korisnik.getEmail());
			} catch (InvalidKeyException | NoSuchAlgorithmException e) {
			
				System.out.println("Greska prilikom pravljenja tokena");
				e.printStackTrace();
			}
		}
		return null;
			
	}


	public Integer findId(String username) {
		return korr.findByKorisnickoIme(username).getIdKorisnik();
		
	}


	 public void obrisiOmiljenuKnjigu(int korisnikId, int knjigaId,int kolekcijaId) {
	        kkr.deleteByKorisnikIdAndKnjigaId(korisnikId, knjigaId,kolekcijaId);
	    }
	
}
