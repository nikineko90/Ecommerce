package com.generation.NegozioRossi.dao;

import java.util.List;

import com.generation.NegozioRossi.model.Articolo;

public interface IDaoArticoli {

	List<Articolo> articoli();
	
	Articolo articolo(int id);
	
	void addArticolo(Articolo articolo);
	
	void updateArticolo(Articolo articolo);
	
	void deleteArticolo(int id);
}
