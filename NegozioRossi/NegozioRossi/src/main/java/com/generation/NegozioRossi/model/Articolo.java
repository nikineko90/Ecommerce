package com.generation.NegozioRossi.model;

import com.generation.NegozioRossi.util.IMappablePro;

public class Articolo implements IMappablePro{

	private int id;
	private String nome;
	private String codicearticolo;
	private String categoria;
	private double prezzo;
	private String colore;
	private String taglia;
	private int quantita;
	
	public Articolo() {
		super();
	}

	public Articolo(int id, String nome, String codicearticolo, String categoria, double prezzo, String colore,
			String taglia, int quantita) {
		super();
		this.id = id;
		this.nome = nome;
		this.codicearticolo = codicearticolo;
		this.categoria = categoria;
		this.prezzo = prezzo;
		this.colore = colore;
		this.taglia = taglia;
		this.quantita = quantita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodicearticolo() {
		return codicearticolo;
	}

	public void setCodicearticolo(String codicearticolo) {
		this.codicearticolo = codicearticolo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getTaglia() {
		return taglia;
	}

	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	
	
}
