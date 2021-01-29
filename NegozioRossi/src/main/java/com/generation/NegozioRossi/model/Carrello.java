package com.generation.NegozioRossi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Carrello {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idOrdine;
	@JoinColumn(name = "id_utente", nullable = false)
	
	@ManyToMany
	@JoinTable
	private List<Articolo> articoli;
	private String data;
	private double prezzoTotale;
	
	
	
	
}
