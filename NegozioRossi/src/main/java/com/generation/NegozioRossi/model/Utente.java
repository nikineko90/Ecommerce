package com.generation.NegozioRossi.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.NegozioRossi.security.Roles;
import com.generation.NegozioRossi.util.IMappablePro;

@Entity
public class Utente implements UserDetails {

	private static final Map<String, Collection<? extends GrantedAuthority>> AUTHORITIES = new HashMap<>();

	{
		AUTHORITIES.put(Roles.ADMIN, Arrays.asList(new GrantedAuthority[] { new SimpleGrantedAuthority("ROLE_ADMIN"),
				new SimpleGrantedAuthority("management"), }));
		AUTHORITIES.put(Roles.USER, Arrays.asList(new GrantedAuthority[] { new SimpleGrantedAuthority("ROLE_USER") }));

	}

	public static Collection<? extends GrantedAuthority> getAuthorityOfRole(String role) {
		return AUTHORITIES.get(role);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(unique = true)
	private String email;
	@Column(unique = true) // Non possono esserci due utenti con stessa email
	private String username;
	private String password;
	private String ruolo;
	private String nome;
	private String cognome;
	private String indirizzo;
	
	public Utente(long id, 
				String username, 
				String password, 
				String nome, 
				String cognome, 
				String indirizzo,
				String ruolo) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.ruolo = ruolo;
	}

	public Utente() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
		
	}

	public String getRuolo() {
		return ruolo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getAuthorityOfRole(this.ruolo);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
	@Override
	public String toString() {
		return "Utente [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", ruolo=" + ruolo + "]";
	}
	
}