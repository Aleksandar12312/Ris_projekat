package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import model.Korisnik;
import model.Uloga;

public class MyUserDetails implements UserDetails{
	private Korisnik k;
	
	

	public MyUserDetails(Korisnik k) {
		super();
		this.k = k;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {//Ovde zadajem uloge 
		Collection<SimpleGrantedAuthority> uloge=new ArrayList<>();
		if(k.getUloga()==Uloga.ROLE_ADMIN) 
			uloge.add(new SimpleGrantedAuthority("ADMIN"));
		
		else if(k.getUloga()==Uloga.ROLE_USER) 
			uloge.add(new SimpleGrantedAuthority("USER"));
		
		else
			uloge.add(new SimpleGrantedAuthority("GUEST"));
		
		return  uloge;
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return k.getLozinka();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return k.getKorisnickoIme();
	}
}
