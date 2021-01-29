package com.generation.NegozioRossi.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.NegozioRossi.model.Articolo;
import com.generation.NegozioRossi.model.Utente;
import com.generation.NegozioRossi.repository.UtenteRepository;
import com.generation.NegozioRossi.security.Roles;
import com.generation.NegozioRossi.util.BasicDao;

@Service
//Un Service è simile ad una Repository, ma non ha accesso diretto ai dati. 
//Implementiamo UserDetailsService, l'interfaccia di SprignSecurity 
//che utilizza come oggetto per andare a controllare gli utenti attraverso l'username
public class AuthService implements UserDetailsService {

	private UtenteRepository dao;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public AuthService(UtenteRepository dao, PasswordEncoder passwordEncoder) {
		this.dao = dao;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<? extends UserDetails> user = dao.findByUsername(username);

		if (user.isPresent())
			return user.get();

		throw new UsernameNotFoundException("Nessun utente col username: " + username);
	}
	

	public void signup(Utente nuovo) {
		Utente newUtente = new Utente();
		newUtente.setEmail(nuovo.getEmail());
		newUtente.setUsername(nuovo.getUsername());
		newUtente.setPassword(passwordEncoder.encode(nuovo.getPassword()));
		newUtente.setRuolo(Roles.USER);
		try {			
			dao.save(newUtente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}