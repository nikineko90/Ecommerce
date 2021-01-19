package com.generation.NegozioRossi.model;

import com.generation.NegozioRossi.util.IMappablePro;

public class Utente implements IMappablePro{

	private int id;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String indirizzo;
	
	public Utente() {
		super();
	}
	
	public Utente(int id, String username, String password, String nome, String cognome, String indirizzo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	
	
	
}
