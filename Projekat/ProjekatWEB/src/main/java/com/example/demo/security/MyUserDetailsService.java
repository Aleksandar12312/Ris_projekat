package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.KorisnikRepository;

import model.Korisnik;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private KorisnikRepository kr;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik k=kr.findByKorisnickoIme(username);
		if(k==null) {
			throw new UsernameNotFoundException("Korisnik nije pronadjen!");
		}
		MyUserDetails myUser=new MyUserDetails(k);
		
		return myUser;
	}

}
