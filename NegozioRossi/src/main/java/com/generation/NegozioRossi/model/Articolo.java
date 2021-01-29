package com.generation.NegozioRossi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.generation.NegozioRossi.util.IMappablePro;

@Entity
public class Articolo implements IMappablePro{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String codicearticolo;
	private String categoria;
	private double prezzo;
	private String colore;
	private String taglia;
	private int quantita;
	private String sesso;
	private String brand;
	private String immagine;
	
	public Articolo() {
		super();
	}

	public Articolo(long id, String nome, String codicearticolo, String categoria, double prezzo, String colore,
			String taglia, int quantita, String sesso, String brand, String immagine) {
		super();
		this.id = id;
		this.nome = nome;
		this.codicearticolo = codicearticolo;
		this.categoria = categoria;
		this.prezzo = prezzo;
		this.colore = colore;
		this.taglia = taglia;
		this.quantita = quantita;
		this.sesso = sesso;
		this.brand = brand;
		this.immagine = immagine;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	
	
	
}
